package com.example.HomeTask2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.HomeTask2.DataHelper;
import com.example.HomeTask2.R;
import com.example.HomeTask2.adapters.ClientListAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/14/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class FragmentListView extends Fragment {
    ListView clientList;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_view, null);
        clientList = (ListView)v.findViewById(R.id.clientList);

        ClientListAdapter clientListAdapter = new ClientListAdapter(v.getContext(), DataHelper.getClients());
        clientList.setAdapter(clientListAdapter);
        return v;
    }
}
