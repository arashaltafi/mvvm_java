package com.arash.altafi.mvvmjava.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.arash.altafi.mvvmjava.models.ResponseBanner;
import com.arash.altafi.mvvmjava.repositories.BannerRepository;

import java.util.List;

public class BannerViewModel extends ViewModel {

    private BannerRepository repository;

    public BannerViewModel(BannerRepository repository) {
        this.repository = repository;
        repository.getBannerWebService();
    }

    public LiveData<List<ResponseBanner>> getBanners() {
        return repository.getBannerLocal();
    }

}