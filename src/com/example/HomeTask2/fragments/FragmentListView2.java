package com.example.HomeTask2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.renderscript.ProgramVertexFixedFunction;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.HomeTask2.DataHelper;
import com.example.HomeTask2.R;
import com.example.HomeTask2.activities.DetailActivity;
import com.example.HomeTask2.adapters.ClientListAdapter;
import com.example.HomeTask2.adapters.ExpandableListAdapter;
import com.example.HomeTask2.entities.Tablet;

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
    HashMap<String, List<Tablet>> listDataChild;
    View v;
    FragmentDetail fragmentDetail;
    TextView name;
    TextView fullName;
    TextView details;
    TextView price;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_view2, null);
        return v;
    }

    public void initElement() {
        fragmentDetail = (FragmentDetail) getFragmentManager().findFragmentById(R.id.details_frag);
        if (fragmentDetail != null) {
            name = (TextView)fragmentDetail.getView().findViewById(R.id.name);
            fullName = (TextView)fragmentDetail.getView().findViewById(R.id.fullName);
            details = (TextView)fragmentDetail.getView().findViewById(R.id.details);
            price = (TextView)fragmentDetail.getView().findViewById(R.id.price);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initElement();
        prepareListData();
        expListView = (ExpandableListView) v.findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Tablet currentTablet = (Tablet)listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if (fragmentDetail != null && fragmentDetail.isInLayout()) {
                    setDetails(currentTablet);
                } else {
                    createActivity(currentTablet);
                }
                showMessage(groupPosition, childPosition);
                return false;
            }
        });
    }

    private void setDetails(Tablet currentTablet) {
        name.setText(currentTablet.getName());
        fullName.setText(currentTablet.getFullName());
        details.setText(currentTablet.getDescription());
        price.setText(String.valueOf(currentTablet.getPrice()));
    }

    private void createActivity(Tablet currentTablet) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("tablet", currentTablet);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void showMessage(int groupPosition, int childPosition) {
        Toast.makeText(
                getActivity(),
                listDataHeader.get(groupPosition)
                        + " : "
                        + listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition).getName(), Toast.LENGTH_SHORT)
                .show();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Tablet>>();

        listDataHeader.add("Планшеты Sumsung");
        listDataHeader.add("Планшеты Aser");
        listDataHeader.add("Планшеты Lenovo");

        List<Tablet> sumsung = new ArrayList<Tablet>();
        sumsung.add(new Tablet(1,"Samsung Galaxy Tab 2 7.0","Samsung Galaxy Tab 2 7.0 (GT-P3110ZWASEK) White",
                "Экран 7 (1024x600) емкостный Multi-Touch / процессор 1 ГГц / RAM 1 ГБ / SSD 8 ГБ + поддержка карт памяти microSD / Wi-Fi / Bluetooth 3.0 / основная камера 3 Мп + фронтальная / GPS / ОС Android 4.0 (Ice Cream Sandwich)",235));
        sumsung.add(new Tablet(2,"Samsung Galaxy Tab 3 7.0","Samsung Galaxy Tab 3 7.0 8GB 3G (SM-T2110ZWASEK) White",
                "Экран 7 (1024x600) емкостный Multi-Touch / двухъядерный процессор 1.2 ГГц / RAM 1 ГБ / 8 ГБ встроенной памяти + поддержка карт памяти microSD / 3G / Wi-Fi / Bluetooth 3.0 / основная камера 3 Мп + фронтальная 1.3 Мп / A-GPS / ОС Android 4.2 / 111.1 x 188.0 x 9.9 мм, 306 г / белый",235));
        sumsung.add(new Tablet(3,"Samsung Galaxy Tab 2 7.4 Titanium","Samsung Galaxy Tab 2 7.4 3G (GT-P3100TSASEK) Titanium",
                "Экран 7 (1024x600) емкостный Multi-Touch / процессор 1 ГГц / RAM 1 ГБ / SSD 8 ГБ + поддержка карт памяти microSD / 3G / Wi-Fi / Bluetooth 3.0 / основная камера 3 Мп + фронтальная / GPS / ОС Android 4.0 (Ice Cream Sandwich) / вес 344 г",235));

        List<Tablet> aser = new ArrayList<Tablet>();
        aser.add(new Tablet(1,"Lenovo IdeaTab A3000","Lenovo IdeaTab A3000 16GB White (59366238)",
                "Экран 7 (1024x600) TFT, емкостный Multi-Touch / MediaTek MTK8317T (1.2 ГГц) / RAM 512 МБ / флеш-память 8 ГБ + поддержка карт памяти microSD / Wi-Fi / Bluetooth 4.0 / GPS / фронтальная камера 0.3 Мп / ОС Android 4.1.2 / 320 г / черный",250));
        aser.add(new Tablet(2, "Lenovo IdeaTab A1000", "Lenovo IdeaTab A1000 16GB White (59374146)",
                "Экран 7.9 IPS (1024x768), емкостный Multi-Touch / MediaTek MTK8125 (1.2 ГГц) / RAM 1 ГБ / флеш-память 16 ГБ + поддержка карт памяти microSD / основная камера 5 Мп + фронтальная 0.3 Мп / Wi-Fi / Bluetooth / GPS / ОС Android 4.2 / 208.7 x 145.7 x 11.1 мм, 410 г / белый",300));
        aser.add(new Tablet(3,"Lenovo IdeaTab A2107","Lenovo IdeaTab A2107 16GB 3G (59-344785)",
                "Экран 7.9 IPS (1024x768), емкостный Multi-Touch / MediaTek MTK8125 (1.2 ГГц) / RAM 1 ГБ / флеш-память 8 ГБ + поддержка карт памяти microSD / основная камера 5 Мп + фронтальная 0.3 Мп / Wi-Fi / Bluetooth / GPS / ОС Android 4.2 / 208.7 x 145.7 x 11.1 мм, 410 г / белый",350));

        List<Tablet> lenovo = new ArrayList<Tablet>();
        lenovo.add(new Tablet(1,"Lenovo IdeaTab A3000","Lenovo IdeaTab A3000 16GB White (59366238)",
                "Экран 7\" (1024x600, IPS) емкостный Multi-Touch / MediaTek MTK8125/8389 (1.2 ГГц) / RAM 1 ГБ / 16 ГБ + поддержка карт памяти microSD / 3G / Wi-Fi b/g/n / Bluetooth 4.0 / GPS/A-GPS / фронтальная камера 0.3 Мп, основная - 5 Мп / Android 4.2 (Jelly Bean) / 350 г",199) );
        lenovo.add(new Tablet(2,"Lenovo IdeaTab A1000","Lenovo IdeaTab A1000 16GB White (59374146)",
                "Экран 7.0\" (1024x600) емкостный Multi-Touch / MediaTek MTK8317T (1.2 ГГц) / RAM 1 ГБ / 16 ГБ + поддержка карт памяти microSD / Wi-Fi b/g/n / Bluetooth 3.0 / GPS / фронтальная камера 0.3 Мп / Android 4.1 (Jelly Bean) / 340 г",250) );
        lenovo.add(new Tablet(3,"Lenovo IdeaTab A3000","Lenovo IdeaTab A3000 16GB Black (59366258)",
                "Экран 7\" (1024x600, IPS) емкостный Multi-Touch / MediaTek MTK8125/8389 (1.2 ГГц) / RAM 1 ГБ / 16 ГБ + поддержка карт памяти microSD / Wi-Fi b/g/n / Bluetooth 4.0 / GPS / фронтальная камера 0.3 Мп, основная - 5 Мп / Android 4.2 (Jelly Bean) / 350 г",299) );

        listDataChild.put(listDataHeader.get(0), sumsung); // Header, Child data
        listDataChild.put(listDataHeader.get(1), aser);
        listDataChild.put(listDataHeader.get(2), lenovo);

    }
}