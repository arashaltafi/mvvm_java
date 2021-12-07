package com.arash.altafi.mvvmjava.repositories;

import androidx.lifecycle.LiveData;

import com.arash.altafi.mvvmjava.api.ApiService;
import com.arash.altafi.mvvmjava.api.BannerDao;
import com.arash.altafi.mvvmjava.models.ResponseBanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerRepository {

    private ApiService apiService;
    private BannerDao bannerDao;

    public BannerRepository(ApiService apiService, BannerDao bannerDao) {
        this.apiService = apiService;
        this.bannerDao = bannerDao;
    }

    public void getBannerWebService(){
        apiService.getBanner().enqueue(new Callback<List<ResponseBanner>>() {
            @Override
            public void onResponse(Call<List<ResponseBanner>> call, Response<List<ResponseBanner>> response) {
                List<ResponseBanner> banners = response.body();
                bannerDao.insertBanner(banners);
            }

            @Override
            public void onFailure(Call<List<ResponseBanner>> call, Throwable t) {

            }
        });
    }

    public LiveData<List<ResponseBanner>> getBannerLocal(){
        return bannerDao.getBanners();
    }

}