package com.example.ghostl.proyectocibertec.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrincipalControllerApi {

    private PrincipalApi principalApi;

    public PrincipalControllerApi(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        Gson gsonBuilder = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .client(client.build()).build();
        principalApi = retrofit.create(PrincipalApi.class);
    }

}
