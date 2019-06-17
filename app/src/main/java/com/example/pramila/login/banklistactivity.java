package com.example.pramila.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class banklistactivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banklistactivity);

        listView = (ListView) findViewById(R.id.listview);

        ArrayList<String > arrayList=new ArrayList<>();
        arrayList.add("Redcross Blood Bank (Balkumari, Lalitpur) : 01-5186065 / 01-5186390");
        arrayList.add("Bhaktapur Blood Bank Phone Number: 01-6612266 / 016611661");
        arrayList.add("Pulchowk Blood Bank (Lalitpur): 01-5527033");
        arrayList.add("Noble Hospital Blood Bank (Sinamangal Kathmandu): 01-4110842");
        arrayList.add("Teaching Hospital Blood Bank (Kathmandu): 01-4412303");
        arrayList.add("GanganLal Hospital Blood Bank (Bansbari, Kathmandu) Phone Number: 01-4371374");
        arrayList.add("Grande Blood Bank (Dhapashi, Kathmandu): 01-5159277");
        arrayList.add("Trauma Center Blood Bank (Mahaboudhha, Kathmandu): 01-4239161");
        arrayList.add("Banepa Blood Bank Phone Number: 01-1661431");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }
}
