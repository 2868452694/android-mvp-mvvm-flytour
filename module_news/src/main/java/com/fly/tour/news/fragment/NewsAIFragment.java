package com.fly.tour.news.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fly.tour.common.base.BaseFragment;
import com.fly.tour.trip.R;

/**
 * Description: <人工智能><br>
 * Author:      gxl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsAIFragment extends BaseFragment {
    public static NewsMobileFragment newInstance() {
        return new NewsMobileFragment();
    }


    @Override
    public int onBindLayout() {
        return R.layout.fragment_trip_route;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }
}
