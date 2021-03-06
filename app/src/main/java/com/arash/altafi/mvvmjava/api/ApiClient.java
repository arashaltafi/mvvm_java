package com.arash.altafi.mvvmjava.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null)
        {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://novindevelopers.ir/").addConverterFactory(GsonConverterFactory.create()).build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
