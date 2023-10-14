package ru.vtb.hackathon.service.geo;

import ru.vtb.hackathon.entity.GeoObject;
import ru.vtb.hackathon.entity.GeoPosition;
import ru.vtb.hackathon.model.DirectionMode;
import ru.vtb.hackathon.model.geo.Route;

import java.util.List;
import java.util.Map;

public interface GeoService {

    <T extends GeoObject> Map<T, Route> getRoutes(GeoPosition geoPosition, List<T> targets, DirectionMode mode);

}
