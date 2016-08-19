package com.example.user.tcardv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 2016-07-28.
 */
public class MinewriteFragment extends Fragment {
    public static MinewriteFragment newInstance() {
        MinewriteFragment fragment = new MinewriteFragment();
        return fragment;
    }

    public MinewriteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minewrite, container, false);
    }
}
