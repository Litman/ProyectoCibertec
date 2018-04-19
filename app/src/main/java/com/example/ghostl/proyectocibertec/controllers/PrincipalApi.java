package com.example.ghostl.proyectocibertec.controllers;


import com.example.ghostl.proyectocibertec.model.UserData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrincipalApi {

    @GET("posts/{id}")
    Call<UserData> getDataCountry(@Path("id") int id);
}
