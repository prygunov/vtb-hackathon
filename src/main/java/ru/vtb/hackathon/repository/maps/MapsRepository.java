package ru.vtb.hackathon.repository.maps;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.vtb.hackathon.model.geo.DistanceMatrix;
import ru.vtb.hackathon.service.geo.Sign;

@RetrofitClient(baseUrl = "${services.maps.api.url}")
@Sign
public interface MapsRepository {

    @GET("/distancematrix")
    public Call<DistanceMatrix> getDistanceMatrix(
            @Query("origins") String origins,
            @Query("destinations") String destinations,
            @Query("mode") String mode
    );

}