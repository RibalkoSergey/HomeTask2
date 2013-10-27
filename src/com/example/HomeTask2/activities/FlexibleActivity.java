package com.example.HomeTask2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.HomeTask2.R;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/27/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlexibleActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_flexible);
    }
}

