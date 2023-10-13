package ru.vtb.hackathon.service.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.vtb.hackathon.entity.ATMEntity;
import ru.vtb.hackathon.model.RootATM;
import ru.vtb.hackathon.repository.ATMRepository;
import ru.vtb.hackathon.repository.maps.MapsRepository;
import ru.vtb.hackathon.service.maps.MapsService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ATMServiceImpl implements ATMService {

    private final ATMRepository repository;
    private final ObjectMapper mapper;

    @PostConstruct
    public void init(){
        try {
            List<ATMEntity> atms = readATMs();
            log.info("Read {} atms from config.", atms.size());
            repository.saveAll(atms);
        } catch (IOException e) {
            log.error("Error with reading ATMs", e);
        }
    }

    private List<ATMEntity> readATMs() throws IOException {
        Resource resource = new ClassPathResource("static/atms.txt");
        return mapper.readValue(resource.getInputStream(), RootATM.class).getAtms();
    }

    @Override
    public List<ATMEntity> findAllATMAround(Double latitude, Double longitude, Double radius) {
        return repository.findAllWithInRadius(latitude, longitude, radius);
    }
}
