package com.example.sajib.retrofitsimple22;

import android.telecom.Call;

import com.example.sajib.retrofitsimple22.modelpackasge.Model;

import retrofit2.http.GET;

public interface Api {
    @GET("api/web/get-req-data/food-price-limit")
   public retrofit2.Call<Model> getprice();
}
