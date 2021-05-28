package com.example.corona.ViewModels;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.corona.model.Countries;
import com.example.corona.model.CountriesResponce;
import com.example.corona.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CountriesViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<ArrayList<Countries>> CountriesList = new MutableLiveData<>();
    private LiveData<List<Countries>> favList = null;

    public LiveData<List<Countries>> getFavList() {
        return favList;
    }

    @ViewModelInject
    public CountriesViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<Countries>> getCountriesList() {
        return CountriesList;
    }

    @SuppressLint("CheckResult")
    public void getCountries() {


        repository.getCountries().subscribeOn(Schedulers.io())

                .map(new Function<CountriesResponce, ArrayList<Countries>>() {


                    @Override
                    public ArrayList<Countries> apply(CountriesResponce countriesResponce) throws Throwable {
                        ArrayList<Countries> list = countriesResponce.getCountries();


                        return list;

                    }
                })

                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(result -> CountriesList.setValue(result),
                        error -> Log.e("ViewModel", error.getMessage()));
    }
//public void search (){
//
//        ArrayList<Countries>l=new ArrayList<>();
//
//}

    public void insertCountry(Countries countries) {
        repository.insertCountry(countries);
    }

    public void deleteCountry(String Country) {
        repository.deletCountry(Country);
    }

    public void getfavdata() {

        favList = repository.getFavCountries();
    }
}
