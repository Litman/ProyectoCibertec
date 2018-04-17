package com.example.ghostl.proyectocibertec.controllers;

import com.example.ghostl.proyectocibertec.model.PrincipalData;



import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface PrincipalApi {

    @GET("name/{name}")
    Observable<PrincipalData> getDataCountry(@Path("name") String name);
}
