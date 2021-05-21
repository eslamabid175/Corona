package com.example.corona.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.corona.model.Countries;

import java.util.List;

@Dao
public interface CountriesDao {

    @Insert
    public void insertCountry(Countries countries);

@Query("delete from fav_table where Country=:CountryName")
public void deleteCountry(String CountryName);

@Query("select * from fav_table")
public LiveData<List<Countries>> getallCountries();
}
