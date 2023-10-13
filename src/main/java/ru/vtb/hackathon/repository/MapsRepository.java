package ru.vtb.hackathon.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.vtb.hackathon.model.dto.maps.DistanceMatrix;

public interface MapsRepository {

    @GET("/distancematrix?origins={lat},{lon}&destinations={distLat},{distLon}")
    public Call<DistanceMatrix> getDistanceMatrix(
            @Path("lat1") double fromLat,
            @Path("lon1") double fromLon,
            @Path("distLat") double distLat,
            @Path("distLon") double distLon,
            @Query("mode") String mode
    );

}