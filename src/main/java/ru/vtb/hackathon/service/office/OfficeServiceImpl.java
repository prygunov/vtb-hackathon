package ru.vtb.hackathon.service.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.vtb.hackathon.entity.GeoPosition;
import ru.vtb.hackathon.entity.OfficeEntity;
import ru.vtb.hackathon.model.DirectionMode;
import ru.vtb.hackathon.repository.office.OfficeRepository;
import ru.vtb.hackathon.service.geo.GeoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository repository;
    private final GeoService geoService;
    private final ObjectMapper mapper;

    @PostConstruct
    public void init(){
        try {
            List<OfficeEntity> offices = readOffices();
            log.info("Read {} offices from config.", offices.size());
            repository.saveAll(offices);
        } catch (IOException e) {
            log.error("Error with reading offices", e);
        }
    }

    private List<OfficeEntity> readOffices() throws IOException {
        Resource resource = new ClassPathResource("static/offices.txt");
        return Arrays.asList(mapper.readValue(resource.getInputStream(), OfficeEntity[].class));
    }

    @Override
    public List<OfficeEntity> findAllOfficesAround(Double latitude, Double longitude, Double radius) {
        return repository.findAllWithInRadius(latitude, longitude, radius);
    }

    @Override
    public List<OfficeEntity> findNearOffices(Double latitude, Double longitude, Double radius) {
        return null;
    }

    @Override
    public List<OfficeEntity> findNearOffices(Double latitude, Double longitude, Double radius, DirectionMode mode) {
        List<OfficeEntity> officesAround = findAllOfficesAround(latitude, longitude, radius);
        var routes = geoService.getRoutes(new GeoPosition(latitude, longitude), officesAround, mode);

        return null;
    }


}
