package com.arash.altafi.mvvmjava.api;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.arash.altafi.mvvmjava.models.ResponseBanner;

import java.util.List;

@Dao
public interface BannerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBanner(List<ResponseBanner> responseBanners);

    @Query("SELECT * FROM tbl_banner")
    LiveData<List<ResponseBanner>> getBanners();

}