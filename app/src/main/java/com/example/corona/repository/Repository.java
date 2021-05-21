package com.example.corona.repository;

import androidx.lifecycle.LiveData;

import com.example.corona.db.CountriesDao;
import com.example.corona.model.Countries;
import com.example.corona.model.CountriesResponce;
import com.example.corona.network.CountriesApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {

    private CountriesApiService countriesApiService;
    private CountriesDao countriesDao;
@Inject
    public Repository(CountriesApiService countriesApiService,CountriesDao countriesDao) {
        this.countriesApiService = countriesApiService;
        this.countriesDao=countriesDao;
    }



    public Observable<CountriesResponce> getCountries(){
return countriesApiService.getCountries();

    }

public void insertCountry(Countries countries){

    countriesDao.insertCountry(countries);
}

public void deletCountry(String Country){countriesDao.deleteCountry(Country);  }
public LiveData<List<Countries>> getFavCountries(){

    return countriesDao.getallCountries();
}
}
