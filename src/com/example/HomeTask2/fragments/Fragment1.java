package com.example.HomeTask2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.HomeTask2.ActivityEvent;
import com.example.HomeTask2.R;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/14/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fragment1 extends Fragment {
    ActivityEvent activityEvent;
    EditText editText;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //activityEvent = (ActivityEvent) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, null);
        Button button = (Button) v.findViewById(R.id.btnSendMessage);
        editText = (EditText) v.findViewById(R.id.message1);
        button.setOnClickListener(oclBtnOk);

        return v;
    }

    View.OnClickListener oclBtnOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
