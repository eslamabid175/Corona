package com.example.corona.model;

import java.util.ArrayList;

public class CountriesResponce {
private String ID;
private String Message;
private ArrayList<Global>globals;
private ArrayList<Countries>Countries;


    public CountriesResponce(String ID, String message,
                             ArrayList<Global> globals, ArrayList<Countries> countries) {
        this.ID = ID;
        Message = message;
        this.globals = globals;
        this.Countries = countries;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ArrayList<Global> getGlobals() {
        return globals;
    }

    public void setGlobals(ArrayList<Global> globals) {
        this.globals = globals;
    }
    public ArrayList<com.example.corona.model.Countries> getCountries() {
        return Countries;
    }

    public void setCountries(ArrayList<com.example.corona.model.Countries> countries) {
        Countries = countries;
    }


}
