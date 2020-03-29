package tech.tedybear.infocovid19.model;

import com.google.gson.annotations.SerializedName;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class CountryModel {

    @SerializedName("cases")
    private int cases;
    @SerializedName("todayCases")
    private int todayCases;
    @SerializedName("deaths")
    private int deaths;
    @SerializedName("todayDeaths")
    private int todayDeaths;
    @SerializedName("recovered")
    private int recovered;
    @SerializedName("active")
    private int active;

    public CountryModel(int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active) {
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
