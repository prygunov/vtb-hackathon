package ru.vtb.hackathon.service;

import lombok.Getter;
import lombok.Setter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import ru.vtb.hackathon.repository.maps.MapsRepository;

@Getter
@Setter
@Service
public class MapsServiceGenerator {

    @Value("${services.maps.api.key}")
    private String apiKey;

    @Value("${services.maps.api.url}")
    private String baseMapsApiUrl;

    private MapsRepository createService(final String apiKey) {
        Retrofit.Builder builder
                = new Retrofit.Builder()
                .baseUrl(baseMapsApiUrl);

        Retrofit retrofit = builder.build();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        var interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        if (apiKey != null) {
            httpClient.interceptors().clear();
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                interceptor.intercept(chain);
                HttpUrl url = original.url().newBuilder()
                        .addQueryParameter("apikey", apiKey)
                        .build();

                Request.Builder builder1 = original.newBuilder()
                        .url(url.url());
                Request request = builder1.build();
                return chain.proceed(request);
            });

            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(MapsRepository.class);
    }

    /*@Bean
    public MapsRepository getMapsRepository(){
        return createService(apiKey);
    }*/
}