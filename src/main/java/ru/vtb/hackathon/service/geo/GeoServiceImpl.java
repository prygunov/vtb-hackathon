package ru.vtb.hackathon.service.geo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import ru.vtb.hackathon.entity.GeoObject;
import ru.vtb.hackathon.entity.GeoPosition;
import ru.vtb.hackathon.dto.DirectionMode;
import ru.vtb.hackathon.dto.geo.DistanceMatrix;
import ru.vtb.hackathon.dto.geo.Route;
import ru.vtb.hackathon.dto.geo.Row;
import ru.vtb.hackathon.repository.maps.MapsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeoServiceImpl implements GeoService {

    private final MapsRepository mapsRepository;

    @Override
    public <T extends GeoObject> Map<T, Route> getRoutes(GeoPosition origin, List<T> targets, DirectionMode mode) {
        Objects.requireNonNull(origin);
        Objects.requireNonNull(mode);

        if (targets.isEmpty())
            return new HashMap<>();

        String geoOrigin = getGeoString(origin);
        String geoTarget = getGeoString(targets.toArray(new GeoObject[0]));

        Map<T, Route> response = new HashMap<>();
        try {
            Response<DistanceMatrix> httpResponse = mapsRepository
                    .getDistanceMatrix(geoOrigin, geoTarget, mode.name())
                    .execute();

            DistanceMatrix distanceMatrix = httpResponse.body();

            Objects.requireNonNull(distanceMatrix);
            Row rootRow = distanceMatrix.rows.get(0);

            if (targets.size() != rootRow.routes.size())
                throw new IOException();

            for (int i = 0; i < targets.size(); i++) {
                Route route = rootRow.routes.get(i);
                response.put(targets.get(i), route);
            }
        } catch (IOException e) {
            log.error("Error while parsing duration - result.", e);
        }

        return sortByValue(response);
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

        for (int i = 1; i < o.length && i<99; i++) {
            geoBuilder
                    .append('|')
                    .append(o[i].getGeoPosition().getLatitude())
                    .append(',')
                    .append(o[i].getGeoPosition().getLongitude());
        }
        return geoBuilder.toString();
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        var list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (var entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
