package com.example.HomeTask2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.HomeTask2.R;
import com.example.HomeTask2.entities.Client;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Client> objects;

    public ClientListAdapter(Context context, ArrayList<Client> clienttList) {
        ctx = context;
        objects = clienttList;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return objects.size();

    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.client_item, parent, false);
        }

        Client client = getClient(position);

        ((TextView) view.findViewById(R.id.clientName)).setText(client.getName());
        ((TextView) view.findViewById(R.id.clientAdress)).setText(client.getAdress());
        return view;
    }


    Client getClient(int position) {
        return ((Client) getItem(position));
    }

}

