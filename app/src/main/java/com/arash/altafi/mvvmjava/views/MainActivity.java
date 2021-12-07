package com.arash.altafi.mvvmjava.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arash.altafi.mvvmjava.R;
import com.arash.altafi.mvvmjava.api.ApiClient;
import com.arash.altafi.mvvmjava.api.AppDataBase;
import com.arash.altafi.mvvmjava.models.ResponseBanner;
import com.arash.altafi.mvvmjava.repositories.BannerRepository;
import com.arash.altafi.mvvmjava.viewModels.BannerViewModel;
import com.arash.altafi.mvvmjava.viewModels.BannerViewModelFactory;
import com.arash.altafi.mvvmjava.views.adapter.Adapter_Banner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recy_banner;
    private Adapter_Banner adapter_banner;
    private BannerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this , new BannerViewModelFactory(new BannerRepository(ApiClient.getApiService() ,
                AppDataBase.getAppDataBase(getApplicationContext()).getDao()))).get(BannerViewModel.class);

        FindView();
        Listener();
    }

    private void FindView() {
        recy_banner = findViewById(R.id.recy_banner);
    }

    private void Listener() {
        viewModel.getBanners().observe(this, new Observer<List<ResponseBanner>>() {
            @Override
            public void onChanged(List<ResponseBanner> responseBanners) {
                adapter_banner = new Adapter_Banner(responseBanners);
                recy_banner.setAdapter(adapter_banner);
                recy_banner.setLayoutManager(new LinearLayoutManager(getApplicationContext() , RecyclerView.VERTICAL , false));
            }
        });
    }

}