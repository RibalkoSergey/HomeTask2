package com.example.HomeTask2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.HomeTask2.R;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/27/13
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FragmentDetail extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, null);
    }
}
