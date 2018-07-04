package com.example.abdelrhman.register.Presnter;

import android.content.Context;

import com.example.abdelrhman.register.Utlitis.ApiClinte;
import com.example.abdelrhman.register.Utlitis.ApiMethod;
import com.example.abdelrhman.register.Models.RegisterResponce;
import com.example.abdelrhman.register.Models.User;
import com.example.abdelrhman.register.Views.RegisterView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter {
    RegisterView registerView;
    public UserPresenter(Context context,RegisterView registerView)
    {
        this.registerView=registerView;

    }
    public void register(User user) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("name", user.getName());
        queryMap.put("password",user.getPassword() );
        queryMap.put("mail", user.getMail());
        queryMap.put("gender", user.getGender());
        queryMap.put("cityId", "67");
        queryMap.put("districtId","1" );
        queryMap.put("address",user.getAddress() );
        queryMap.put("phone", user.getPhone());

        ApiMethod apiInterface = ApiClinte.getClient().create(ApiMethod.class);


        Call<RegisterResponce> call = apiInterface.register(queryMap);
        call.enqueue(new Callback<RegisterResponce>() {
            @Override
            public void onResponse(Call<RegisterResponce> call, Response<RegisterResponce> response) {

                if (response.isSuccessful()) {
                    registerView.openMain();
                }
                else
                    {
                        registerView.showError("");
                    }
            }


            @Override
            public void onFailure(Call<RegisterResponce> call, Throwable t) {
                registerView.showError("");

            }
        });
    }

}
