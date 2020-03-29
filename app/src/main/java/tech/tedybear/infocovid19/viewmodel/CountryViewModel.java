package tech.tedybear.infocovid19.viewmodel;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.tedybear.infocovid19.api.ApiEndPoint;
import tech.tedybear.infocovid19.api.ApiService;
import tech.tedybear.infocovid19.model.CountryModel;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class CountryViewModel extends ViewModel {

    private MutableLiveData<CountryModel> mutableLiveData = new MutableLiveData<>();

    public void setCountryData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<CountryModel> call = apiEndpoint.getSummaryIn();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {
                // TODO: Here Comes the failure Message...
            }
        });
    }

    public LiveData<CountryModel> getCountryData() {
        return mutableLiveData;
    }
}
