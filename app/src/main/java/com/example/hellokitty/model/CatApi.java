package com.example.hellokitty.model;

import com.example.hellokitty.CatApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CatApi {
    private CatApiService apiService;

    public CatApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
         Retrofit retrofit = new Retrofit.Builder()
             .baseUrl("http://thecatapi.com/api/images/")
             .addConverterFactory(SimpleXmlConverterFactory.create())
             .client(client)
             .build();

        apiService = retrofit.create(CatApiService.class);
    }

    public Call<Image> getRandomImage() {
        return apiService.getRandomImage();
    }
}
