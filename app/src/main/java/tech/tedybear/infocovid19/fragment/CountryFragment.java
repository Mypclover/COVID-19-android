package tech.tedybear.infocovid19.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import tech.tedybear.infocovid19.R;
import tech.tedybear.infocovid19.model.CountryModel;
import tech.tedybear.infocovid19.viewmodel.CountryViewModel;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class CountryFragment extends Fragment {

    private ProgressDialog mProgressApp;

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);

        mProgressApp = new ProgressDialog(getActivity());
        String wait = getString(R.string.please_wait);
        String display = getString(R.string.display_data);
        mProgressApp.setTitle(wait);
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage(display);
        mProgressApp.show();

        PieChart pieChart = view.findViewById(R.id.idnSummaryPie);
        CountryViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(CountryViewModel.class);
        viewModel.setCountryData();
        viewModel.getCountryData().observe(this, new Observer<CountryModel>() {
            @Override
            public void onChanged(CountryModel countryModel) {
                mProgressApp.dismiss();
                List<PieEntry> pieEntries = new ArrayList<>();
                pieEntries.add(new PieEntry(countryModel.getCases(), getResources().getString(R.string.confirmed)));
                pieEntries.add(new PieEntry(countryModel.getDeaths(), getResources().getString(R.string.deaths)));
                pieEntries.add(new PieEntry(countryModel.getRecovered(), getResources().getString(R.string.recovered)));
//                pieEntries.add(new PieEntry(countryModel.getActive(), getResources().getString(R.string.active)));

                PieDataSet pieDataSet = new PieDataSet(pieEntries, getResources().getString(R.string.from_corona));
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(14);

                Description description = new Description();
                description.setText(getResources().getString(R.string.last_update) + " :  Just Now" );
                description.setTextColor(Color.BLACK);
                description.setTextSize(12);

                Legend legend = pieChart.getLegend();
                legend.setTextColor(Color.BLACK);
                legend.setTextSize(12);
                legend.setForm(Legend.LegendForm.SQUARE);

                PieData pieData = new PieData(pieDataSet);
                pieChart.setVisibility(View.VISIBLE);
                pieChart.animateXY(2000, 2000);
                pieChart.setDescription(description);
                pieChart.setHoleRadius(60);
                pieChart.setRotationAngle(130);
                pieChart.setHoleColor(Color.TRANSPARENT);
                pieChart.setData(pieData);
            }
        });
        return view;
    }

}
