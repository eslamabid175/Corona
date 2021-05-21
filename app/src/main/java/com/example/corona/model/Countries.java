package com.example.corona.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fav_table")
public class Countries {

    @PrimaryKey(autoGenerate = true)
 private  int id;
    private String Country;

    private int NewConfirmed;

    private int TotalConfirmed;

    private int NewDeaths;

    private int TotalDeaths;

    private int NewRecovered;

    private int TotalRecovered;

    private String Date;

    public Countries() {
    }

    public Countries(int id, String country, int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths
            , int newRecovered, int totalRecovered, String date) {
        this.id = id;
        Country = country;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
        Date = date;
    }

    public Countries(String country, int newConfirmed, int totalConfirmed, int newDeaths
            , int totalDeaths, int newRecovered, int totalRecovered, String date) {
        Country = country;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        NewDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        NewRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
