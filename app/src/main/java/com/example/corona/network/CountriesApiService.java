package com.example.corona.network;

import com.example.corona.model.CountriesResponce;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface CountriesApiService {

@GET("summary")
Observable<CountriesResponce> getCountries();

}
