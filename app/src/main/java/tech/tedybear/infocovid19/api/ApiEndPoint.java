package tech.tedybear.infocovid19.api;

import retrofit2.Call;
import retrofit2.http.GET;
import tech.tedybear.infocovid19.model.CountryModel;
import tech.tedybear.infocovid19.model.RingkasanModel;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public interface ApiEndPoint {

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IN)
    Call<CountryModel> getSummaryIn();

}
