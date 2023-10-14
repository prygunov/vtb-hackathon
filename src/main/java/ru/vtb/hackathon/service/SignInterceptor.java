package ru.vtb.hackathon.service;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SignInterceptor extends BasePathMatchInterceptor {

    @Value("${services.maps.api.key}")
    private String apiKey;

    @Value("${services.maps.api.url}")
    private String baseMapsApiUrl;

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl url = original.url().newBuilder()
                .addQueryParameter("apikey", apiKey)
                .build();

        Request.Builder builder1 = original.newBuilder()
                .url(url.url());
        Request request = builder1.build();
        return chain.proceed(request);
    }
}