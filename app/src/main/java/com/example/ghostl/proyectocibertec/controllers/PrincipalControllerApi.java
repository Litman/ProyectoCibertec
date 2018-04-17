package com.example.ghostl.proyectocibertec.controllers;

import com.example.ghostl.proyectocibertec.utils.ConnectionValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PrincipalControllerApi {

    private PrincipalApi principalApi;
    LoadViewInterface loadViewInterface;

    public PrincipalControllerApi(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        Gson gsonBuilder = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ConnectionValues.END_POIN_GENERAL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .client(client.build()).build();
        principalApi = retrofit.create(PrincipalApi.class);
    }

    public void onViewInit(LoadViewInterface view){
        loadViewInterface = view;
    }

    public void loadCountry(String name){
        principalApi.getDataCountry(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

}
