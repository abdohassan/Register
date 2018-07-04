package com.example.abdelrhman.register.Utlitis;

import com.example.abdelrhman.register.Models.RegisterResponce;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiMethod {
    @POST ("Register")
    Call<RegisterResponce> register(@QueryMap Map<String,String> queryMab);

}
