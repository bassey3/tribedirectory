package com.tribeapp.tribedirectory.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeoApiService{

    public GeocodingResult[] getGeocodeForAddress(String address) throws InterruptedException, ApiException, IOException{

        //GeocodingApiRequest req = GeocodingApi.newRequest(context).address("Sydney");

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBydcA-BAa958BQGP6mu05CNQY7yPWxpbI")
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context, address).await();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        log.warn(gson.toJson(results[0].addressComponents));

        return results;
    }

}
