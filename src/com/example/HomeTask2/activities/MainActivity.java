package com.example.HomeTask2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import com.example.HomeTask2.ActivityEvent;
import com.example.HomeTask2.R;
import com.example.HomeTask2.fragments.Fragment1;
import com.example.HomeTask2.fragments.Fragment2;
import com.example.HomeTask2.fragments.FragmentListView;


public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener {
    final String LOG_TAG = "myLogs";
    String[] data = new String[] { "one", "two", "three" };

    private String[] mTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    FragmentListView fragmentListView;
    Fragment fragment1;
    Fragment fragment2;
    FragmentTransaction fTrans;


    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.navigationdraw);

        fragmentListView = new FragmentListView();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        initNavigDraw();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar.setListNavigationCallbacks(adapter, (ActionBar.OnNavigationListener) this);

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Toast.makeText(getApplicationContext(), String.valueOf(itemPosition), Toast.LENGTH_SHORT).show();
        return false;
    }

    private void initNavigDraw() {
        mTitles = new String[]{"Фрагмент 1", "Фрагмент 2", "ListView", "Анимация"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_item, mTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                fTrans.replace(R.id.content_frame, fragment1).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 1:
                fTrans.replace(R.id.content_frame, fragment2).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 2:
                fTrans.replace(R.id.content_frame, fragmentListView).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 3:
                Intent intent = new Intent();
                intent.setClass(this, AnimationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
