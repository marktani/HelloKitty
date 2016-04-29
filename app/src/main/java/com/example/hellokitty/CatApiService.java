package com.example.hellokitty;

import com.example.hellokitty.model.Image;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CatApiService {
    @Headers({
            "Accept: application/xml",
            "Content-Type: application/xml"
    })
    @GET("get?format=xml")
    Call<Image> getRandomImage();

    @GET("random")
    Call<Image> getSomething();
}
