package ru.vtb.hackathon.service.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.model.RootAtm;
import ru.vtb.hackathon.model.dto.atm.Atm;
import ru.vtb.hackathon.model.dto.atm.AtmMapper;
import ru.vtb.hackathon.model.dto.feature.Feature;
import ru.vtb.hackathon.model.dto.feature.FeatureActivityState;
import ru.vtb.hackathon.repository.atm.AtmRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AtmServiceImpl implements AtmService {

    private final AtmRepository repository;
    private final ObjectMapper mapper;
    private final AtmMapper atmMapper;

    @PostConstruct
    public void init(){
        try {
            List<AtmEntity> atms = readATMs();
            log.info("Read {} atms from config.", atms.size());
            repository.saveAll(atms);
        } catch (IOException e) {
            log.error("Error with reading ATMs", e);
        }
    }

    private List<AtmEntity> readATMs() throws IOException {
        Resource resource = new ClassPathResource("static/atms.txt");
        return mapper.readValue(resource.getInputStream(), RootAtm.class).getAtms();
    }

    @Override
    public List<Atm> findAllAtmAround(Double latitude, Double longitude, Double radius) {
        return atmMapper.dto(repository.findAllWithInRadius(latitude, longitude, radius));
    }

    @Override
    public List<Atm> FilterByFeatures(List<Atm> atms, Map<Feature, Boolean> features) {
        if (features.get(Feature.WHEELCHAIR)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getWheelchair().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.BLIND)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getBlind().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.NFC_FOR_BANK_CARDS)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getNfcForBankCards().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.QR_READ)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getQrRead().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.SUPPORTS_USD)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getSupportsUsd().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.SUPPORTS_CHARGE_RUB)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getSupportsChargeRub().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.SUPPORTS_EUR)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getSupportsEur().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        if (features.get(Feature.SUPPORTS_RUB)) {
            atms = atms.stream().filter(atm -> atm.getFeatures().getSupportsRub().getFeatureActivity() == FeatureActivityState.AVAILABLE).collect(Collectors.toList());
        }
        return atms;
    }
}
