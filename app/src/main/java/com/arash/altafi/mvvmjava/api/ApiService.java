package com.arash.altafi.mvvmjava.api;

import com.arash.altafi.mvvmjava.models.ResponseBanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("banner.php")
    Call<List<ResponseBanner>> getBanner();

}