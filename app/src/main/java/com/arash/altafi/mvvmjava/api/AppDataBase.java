package com.arash.altafi.mvvmjava.api;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.arash.altafi.mvvmjava.models.ResponseBanner;

@Database(version = 1 , exportSchema = false , entities = {ResponseBanner.class})
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase appDataBase;

    public static AppDataBase getAppDataBase(Context context) {
        if (appDataBase == null)
        {
            appDataBase = Room.databaseBuilder(context.getApplicationContext() , AppDataBase.class , "my_db").allowMainThreadQueries().build();
        }
        return appDataBase;
    }

    public abstract BannerDao getDao();

}