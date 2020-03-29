package tech.tedybear.infocovid19.model;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class RingkasanModel {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String updated_Date;

    @SerializedName("cases")
    private int confirmed;
    @SerializedName("deaths")
    private int deaths;
    @SerializedName("recovered")
    private int recovered;
    @SerializedName("active")
    private int active;
    @SerializedName("updated")
    private String updated;

    public RingkasanModel(int confirmed, int deaths, int recovered, int active, String updated) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.updated = updated;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
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

    public String getUpdated() {

        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
