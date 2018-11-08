package com.example.nonsleeping.downloadmultiimage;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.security.Identity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomListAdapter customListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItem> listData = getListDate();
        ListView listView = (ListView) findViewById(R.id.custom_list);
        customListAdapter = new CustomListAdapter(this, listData);
        listView.setAdapter(customListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem newsData = (ListItem) parent.getAdapter().getItem(position);

                Toast.makeText(MainActivity.this, "Selected :" + " " + newsData.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<ListItem> getListDate() {
        ArrayList<ListItem> listItems = new ArrayList<ListItem>();
        String[] images = getResources().getStringArray(R.array.images_array);
        String[] headlines = getResources().getStringArray(R.array.headline_array);

        for (int i=0 ; i < images.length ; i++) {
            ListItem newsData = new ListItem();
            newsData.setUrl(images[i]);
            newsData.setHeadline(headlines[i]);
            newsData.setReporterName("Pankaj Gupta");
            newsData.setDate("May 26, 2013, 13:35");

            listItems.add(newsData);
        }
        return listItems;
    }
}
