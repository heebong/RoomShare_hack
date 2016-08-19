package com.example.user.tcardv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 2016-07-28.
 */
public class ScrapFragment extends Fragment {
    public static ScrapFragment newInstance() {
        ScrapFragment fragment = new ScrapFragment();
        return fragment;
    }

    public ScrapFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scrap, container, false);
    }
}
