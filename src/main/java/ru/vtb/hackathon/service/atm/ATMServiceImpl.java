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
import ru.vtb.hackathon.repository.atm.AtmRepository;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ATMServiceImpl implements ATMService {

    private final AtmRepository repository;
    private final ObjectMapper mapper;

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
    public List<AtmEntity> findAllATMAround(Double latitude, Double longitude, Double radius) {
        return repository.findAllWithInRadius(latitude, longitude, radius);
    }
}
