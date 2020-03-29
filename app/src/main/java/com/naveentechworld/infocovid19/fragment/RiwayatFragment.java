package com.naveentechworld.infocovid19.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.naveentechworld.infocovid19.R;
import com.naveentechworld.infocovid19.model.CountryModel;
import com.naveentechworld.infocovid19.viewmodel.CountryViewModel;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class RiwayatFragment extends Fragment {

    //    private HistoryListAdapter adapter;
    private ProgressDialog mProgressApp;
    TextView confirmedstats;
    TextView recoveredstats;
    TextView deathstats;
    TextView activestats;
    TextView todaystats;


    public RiwayatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);

        mProgressApp = new ProgressDialog(getActivity());
        String wait = getString(R.string.please_wait);
        String display = getString(R.string.display_data);
        mProgressApp.setTitle(wait);
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage(display);

        confirmedstats = view.findViewById(R.id.confirmed_textview);
        recoveredstats = view.findViewById(R.id.recovered_textview);
        deathstats = view.findViewById(R.id.deaths_textview);
        activestats = view.findViewById(R.id.active_textview);
        todaystats = view.findViewById(R.id.todaydeaths_textview);
        CountryViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(CountryViewModel.class);
        viewModel.setCountryData();
        viewModel.getCountryData().observe(this, new Observer<CountryModel>() {
            @Override
            public void onChanged(CountryModel countryModel) {
                mProgressApp.dismiss();
                confirmedstats.setText(String.valueOf(countryModel.getCases()));
                recoveredstats.setText(String.valueOf(countryModel.getRecovered()));
                deathstats.setText(String.valueOf(countryModel.getDeaths()));
                activestats.setText(String.valueOf(countryModel.getActive()));
                todaystats.setText(String.valueOf(countryModel.getTodayDeaths()));


            }
        });
        return view;
    }


}
