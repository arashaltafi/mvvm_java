package com.arash.altafi.mvvmjava.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.arash.altafi.mvvmjava.repositories.BannerRepository;

public class BannerViewModelFactory implements ViewModelProvider.Factory {

    private BannerRepository repository;

    public BannerViewModelFactory(BannerRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BannerViewModel(repository);
    }

}