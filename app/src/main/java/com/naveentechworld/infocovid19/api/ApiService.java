package com.naveentechworld.infocovid19.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class ApiService {

    public static Retrofit getRetrofitService() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
