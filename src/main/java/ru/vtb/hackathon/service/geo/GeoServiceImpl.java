package ru.vtb.hackathon.service.geo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import ru.vtb.hackathon.entity.GeoObject;
import ru.vtb.hackathon.entity.GeoPosition;
import ru.vtb.hackathon.model.DirectionMode;
import ru.vtb.hackathon.model.geo.DistanceMatrix;
import ru.vtb.hackathon.model.geo.Element;
import ru.vtb.hackathon.model.geo.Row;
import ru.vtb.hackathon.repository.maps.MapsRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeoServiceImpl implements GeoService {

    private final MapsRepository mapsRepository;

    @Override
    public <T extends GeoObject> Map<T, Integer> getDurations(GeoPosition origin, List<T> targets, DirectionMode mode) {
        Objects.requireNonNull(origin);
        Objects.requireNonNull(mode);

        if (targets.isEmpty())
            return new HashMap<>();

        String geoOrigin = getGeoString(origin);
        String geoTarget = getGeoString(targets.toArray(new GeoObject[0]));

        Map<T, Integer> response = new HashMap<>();
        try {
            Response<DistanceMatrix> httpResponse = mapsRepository
                    .getDistanceMatrix(geoOrigin, geoTarget, mode.name())
                    .execute();

            DistanceMatrix distanceMatrix = httpResponse.body();

            Objects.requireNonNull(distanceMatrix);
            Row rootRow = distanceMatrix.rows.get(0);
            if (targets.size() != rootRow.elements.size())
                throw new IOException();

            for (int i = 0; i < targets.size(); i++) {
                Element element = rootRow.elements.get(i);
                response.put(targets.get(i), element.getDuration().getValue());
            }
        } catch (IOException e) {
            log.error("Error while parsing duration - result.", e);
        }

        return response;
    }

    private String getGeoString(GeoObject... o) {
        if (o.length < 1)
            throw new IllegalArgumentException();

        StringBuilder geoBuilder = new StringBuilder();
        GeoPosition firstPosition = o[0].getGeoPosition();
        geoBuilder
                .append(firstPosition.getLatitude())
                .append(',')
                .append(firstPosition.getLongitude());

        for (int i = 1; i < o.length; i++) {
            geoBuilder
                    .append('|')
                    .append(o[i].getGeoPosition().getLatitude())
                    .append(',')
                    .append(o[i].getGeoPosition().getLongitude());
        }
        return geoBuilder.toString();
    }
}
