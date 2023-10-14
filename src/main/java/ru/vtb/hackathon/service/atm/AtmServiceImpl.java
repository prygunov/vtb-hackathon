package ru.vtb.hackathon.service.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.dto.RootAtm;
import ru.vtb.hackathon.dto.atm.AtmDto;
import ru.vtb.hackathon.dto.atm.AtmMapper;
import ru.vtb.hackathon.dto.feature.Feature;
import ru.vtb.hackathon.dto.feature.FeatureActivityState;
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
    public List<AtmDto> findAllAtmAround(Double latitude, Double longitude, Double radius) {
        return atmMapper.dto(repository.findAllWithInRadius(latitude, longitude, radius));
    }

    @Override
    public List<AtmDto> filterByFeatures(List<AtmDto> atms, Map<Feature, Boolean> features) {
        for (var entry : features.entrySet()){
            var feature = entry.getKey();
            var isActivated = entry.getValue();
            if (isActivated){
                atms = atms.stream().filter(atm -> atm.getFeatures()
                        .getFeatureState(feature)
                        .getFeatureActivity() == FeatureActivityState.AVAILABLE)
                        .collect(Collectors.toList());
            }
        }
        return atms;
    }
}
