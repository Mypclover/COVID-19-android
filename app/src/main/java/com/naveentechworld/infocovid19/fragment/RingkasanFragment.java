package com.naveentechworld.infocovid19.fragment;

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

import com.naveentechworld.infocovid19.R;
import com.naveentechworld.infocovid19.model.RingkasanModel;
import com.naveentechworld.infocovid19.viewmodel.RingkasanViewModel;

/*
 * Created by Naveen Kumar on 3/23/20 5:33 PM
 * Copyright (c) 2020. All rights reserved.
 */

public class RingkasanFragment extends Fragment {


    private ProgressDialog mProgressApp;

    public RingkasanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ringkasan, container, false);

        mProgressApp = new ProgressDialog(getActivity());
        String wait = getString(R.string.please_wait);
        String display = getString(R.string.display_data);
        mProgressApp.setTitle(wait);
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage(display);
        mProgressApp.show();

        PieChart pieChart = view.findViewById(R.id.worldSummaryPie);
        RingkasanViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(RingkasanViewModel.class);
        viewModel.setSummaryWorldData();
        viewModel.getSummaryWorldData().observe(this, new Observer<RingkasanModel>() {
            @Override
            public void onChanged(RingkasanModel ringkasanModel) {
                mProgressApp.dismiss();
                List<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(ringkasanModel.getConfirmed(), getResources().getString(R.string.confirmed)));
                entries.add(new PieEntry(ringkasanModel.getRecovered(), getResources().getString(R.string.recovered)));
                entries.add(new PieEntry(ringkasanModel.getDeaths(), getResources().getString(R.string.deaths)));
                entries.add(new PieEntry(ringkasanModel.getActive(), getResources().getString(R.string.active)));

                PieDataSet pieDataSet = new PieDataSet(entries, getResources().getString(R.string.from_corona));
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(14);

                Description description = new Description();
                description.setText(getResources().getString(R.string.last_update) + " : " + "Just Now");
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
                pieChart.setHoleColor(Color.TRANSPARENT);
                pieChart.setHoleRadius(60);
                pieChart.setRotationAngle(320);
                pieChart.setData(pieData);
            }
        });
        return view;
    }

}
