package com.example.HomeTask2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import com.example.HomeTask2.DataHelper;
import com.example.HomeTask2.R;
import com.example.HomeTask2.adapters.ClientListAdapter;
import com.example.HomeTask2.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/21/13
 * Time: 12:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class FragmentListView2 extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the listview

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_view2, null);

        expListView = (ExpandableListView) v.findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);
        return v;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Планшеты Sumsung");
        listDataHeader.add("Планшеты Aser");
        listDataHeader.add("Планшеты Lenovo");
        listDataHeader.add("Планшеты Asus");
        listDataHeader.add("Планшеты 3Q");


        // Adding child data
        List<String> sumsung = new ArrayList<String>();
        sumsung.add("Samsung Galaxy Tab 2 7.0 (GT-P3110ZWASEK) White");
        sumsung.add("Samsung Galaxy Tab 3 7.0 8GB 3G (SM-T2110ZWASEK) White");
        sumsung.add("Samsung Galaxy Tab 2 7.0 3G (GT-P3100TSASEK) Titanium");

        List<String> aser = new ArrayList<String>();
        aser.add("Acer Iconia Tab B1-A71 (NT.L15EE.003) GPS");
        aser.add("Acer Iconia Tab A1-810-81251G01nw (NT.L1CEU.002) 16GB White");
        aser.add("Acer Iconia Tab A1-810-81251G00nw (NT.L1DEU.002) 8GB White");

        List<String> lenovo = new ArrayList<String>();
        lenovo.add("Lenovo IdeaTab A3000 16GB White (59366238)");
        lenovo.add("Lenovo IdeaTab A1000 16GB White (59374146)");
        lenovo.add("Lenovo IdeaTab A3000 16GB Black (59366258)");
        lenovo.add("Lenovo IdeaTab A2107 16GB 3G (59-344785)");

        List<String> asus = new ArrayList<String>();
        asus.add("Asus FonePad 3G 16GB (ME371MG-1B037A) Titanium Gray");
        asus.add("Asus Google Nexus 7 2013 32GB (NEXUS7-1A036A))");
        asus.add("Asus Google Nexus 7 2013 16GB (NEXUS7-1A051A)");

        List<String> q = new ArrayList<String>();
        q.add("3Q Qoo! Q-pad RC0718");
        q.add("3Q Qoo! Q-pad RC0722C-DG Dark Grey");

        listDataChild.put(listDataHeader.get(0), sumsung); // Header, Child data
        listDataChild.put(listDataHeader.get(1), aser);
        listDataChild.put(listDataHeader.get(2), lenovo);
        listDataChild.put(listDataHeader.get(3), asus);
        listDataChild.put(listDataHeader.get(4), q);


    }
}