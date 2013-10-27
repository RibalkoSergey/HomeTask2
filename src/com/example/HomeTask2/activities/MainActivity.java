package com.example.HomeTask2.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.HomeTask2.ActivityEvent;
import com.example.HomeTask2.R;
import com.example.HomeTask2.fragments.Fragment1;
import com.example.HomeTask2.fragments.Fragment2;
import com.example.HomeTask2.fragments.FragmentListView;
import com.example.HomeTask2.fragments.FragmentListView2;


public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener {
    final String LOG_TAG = "myLogs";
    String[] data = new String[] { "one", "two", "three" };

    private String[] mTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence title;


    FragmentListView fragmentListView;
    FragmentListView2 fragmentListView2;

    Fragment fragment1;
    Fragment fragment2;
    FragmentTransaction fTrans;



    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.navigationdraw);

        fragmentListView = new FragmentListView();
        fragmentListView2 = new FragmentListView2();

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
        mTitles = new String[]{"Фрагмент 1", "Фрагмент 2", "ListView", "ListView2", "Анимация", "Flexible UI"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_item, mTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close ) {

            public void onDrawerClosed(View view) {
                //getSupportActionBar().setTitle("Closed Drawer");
            }

            public void onDrawerOpened(View drawerView) {
                //getSupportActionBar().setTitle("Open Drawer");
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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
                getSupportActionBar().setTitle("fragment1");
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 1:
                fTrans.replace(R.id.content_frame, fragment2).commit();
                getSupportActionBar().setTitle("fragment2");
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 2:
                fTrans.replace(R.id.content_frame, fragmentListView).commit();
                getSupportActionBar().setTitle("listView1");
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 3:
                fTrans.replace(R.id.content_frame, fragmentListView2).commit();
                getSupportActionBar().setTitle("listView2");
                mDrawerList.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerList);
                break;
            case 4:
                Intent intent = new Intent();
                intent.setClass(this, AnimationActivity.class);
                startActivity(intent);
                break;
            case 5:
                Intent intentFl = new Intent();
                intentFl.setClass(this, FlexibleActivity.class);
                startActivity(intentFl);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

}
