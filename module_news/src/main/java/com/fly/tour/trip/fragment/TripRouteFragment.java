package com.fly.tour.trip.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fly.tour.common.base.BaseFragment;
import com.fly.tour.trip.R;


/**
 * Description: <出游路线><br>
 * Author:      gxl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class TripRouteFragment extends BaseFragment {
    public static TripRouteFragment newInstance() {
        return new TripRouteFragment();
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_trip_route, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
