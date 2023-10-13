package ru.vtb.hackathon.repository.maps;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.vtb.hackathon.model.dto.maps.DistanceMatrix;

public interface MapsRepository {

    @GET("/distancematrix")
    public Call<DistanceMatrix> getDistanceMatrix(
            @Query("origins") String origins,
            @Query("destinations") String destinations,
            @Query("mode") String mode
    );

}