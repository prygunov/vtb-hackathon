package ru.vtb.hackathon.service.maps;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.hackathon.entity.ATMEntity;
import ru.vtb.hackathon.repository.atm.ATMRepository;
import ru.vtb.hackathon.repository.maps.MapsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapsServiceImpl implements MapsService{

    private final MapsRepository mapsRepository;
    private final ATMRepository repository;

    @Override
    public List<ATMEntity> findATMAllAround(Double latitude, Double longitude) {
        return repository.findAllWithInRadius(latitude, longitude, 100d);
    }
}
