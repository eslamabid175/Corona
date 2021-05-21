package com.example.corona.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.corona.model.Countries;

@Database(entities = Countries.class,version = 1,exportSchema = false)
public abstract class CountriesDb extends RoomDatabase {

    public abstract CountriesDao countriesDao();
}
