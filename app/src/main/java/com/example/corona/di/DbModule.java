package com.example.corona.di;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.corona.db.CountriesDao;
import com.example.corona.db.CountriesDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DbModule {
@Provides
@Singleton
    public static CountriesDb providecountriesDb(Application application){
return Room.databaseBuilder(application,CountriesDb.class,"fav_db")
.fallbackToDestructiveMigration()
        //ممكن استخدم اراكس جافا هنا بدل السطر اللي جاي
        .allowMainThreadQueries()
        .build();
    }
    @Provides
    @Singleton
public static CountriesDao provideDao(CountriesDb countriesDb){
return countriesDb.countriesDao();

}

}


