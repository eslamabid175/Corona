package com.example.corona.di;

import android.app.Application;

import com.example.corona.network.CountriesApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {
@Provides
@Singleton
public static CountriesApiService provideCountriesApiService(){


    return new Retrofit.Builder().baseUrl("https://api.covid19api.com/")
.addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(CountriesApiService.class);
}

}
