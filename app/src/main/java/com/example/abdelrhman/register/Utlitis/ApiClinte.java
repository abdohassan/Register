package com.example.abdelrhman.register.Utlitis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClinte {
    public static  String baseUrl="http://192.168.1.210:7778/androidApi/";
    public   static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();



        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}