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
import ru.vtb.hackathon.model.dto.office.OfficeDto;
import ru.vtb.hackathon.model.dto.office.OfficeMapper;
import ru.vtb.hackathon.repository.office.OfficeRepository;
import ru.vtb.hackathon.service.geo.GeoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository repository;
    private final GeoService geoService;
    private final ObjectMapper objectMapper;
    private final OfficeMapper officeMapper;

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
        return Arrays.asList(objectMapper.readValue(resource.getInputStream(), OfficeEntity[].class));
    }

    @Override
    public List<OfficeDto> findAllOfficesAround(Double latitude, Double longitude, Double radius) {
        return officeMapper.dto(repository.findAllWithInRadius(latitude, longitude, radius));
    }

    private List<OfficeEntity> findAllAround(Double latitude, Double longitude, Double radius) {
        return repository.findAllWithInRadius(latitude, longitude, radius);
    }

    @Override
    public List<OfficeDto> findNearOffices(Double latitude, Double longitude, Double radius, DirectionMode mode) {
        List<OfficeEntity> officesAround = findAllAround(latitude, longitude, radius);
        var routes = geoService.getRoutes(new GeoPosition(latitude, longitude), officesAround, mode);

        List<OfficeDto> result = new ArrayList<>(routes.size());
        for (var entry : routes.entrySet()) {
            int distance = entry.getValue().getDistance().getValue();
            int duration = entry.getValue().getDuration().getValue();

            result.add(officeMapper.dto(entry.getKey(), distance, duration));
        }

        return result;
    }


}
