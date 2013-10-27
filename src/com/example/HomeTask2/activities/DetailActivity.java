package com.example.HomeTask2.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.example.HomeTask2.R;
import com.example.HomeTask2.entities.Tablet;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/27/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DetailActivity extends FragmentActivity {
    TextView textName;
    TextView textFullName;
    TextView textPrice;
    TextView textDetails;

    Tablet tablet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        initFields();
        getParametr();
        setParametr();
    }

    private void initFields() {
        textName = (TextView) getSupportFragmentManager().findFragmentById(R.id.details_frag).getView().findViewById(R.id.name);
        textFullName = (TextView) getSupportFragmentManager().findFragmentById(R.id.details_frag).getView().findViewById(R.id.fullName);
        textDetails = (TextView) getSupportFragmentManager().findFragmentById(R.id.details_frag).getView().findViewById(R.id.details);
        textPrice = (TextView) getSupportFragmentManager().findFragmentById(R.id.details_frag).getView().findViewById(R.id.price);
    }

    private void getParametr() {
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            tablet = (Tablet) b.getSerializable("tablet");
            //TextView textView = (TextView) findViewById(R.id.detail);
            //textView.setText(tablet.getName() + " " + tablet.getDescription());
        }
    }

    private void setParametr() {
        if (tablet != null) {
            textName.setText(tablet.getName());
            textFullName.setText(tablet.getFullName());
            textDetails.setText(tablet.getDescription());
            textPrice.setText(String.valueOf(tablet.getPrice()));
        }
    }

}
