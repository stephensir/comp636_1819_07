package com.stephensir.recyclerviewdemo;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Properties
    private String TAG = "MainActivity===>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // this is data for recycler view
        /*
        ItemData itemsData[] = { new ItemData("Help",android.R.drawable.ic_menu_help),
                new ItemData("Delete",android.R.drawable.ic_delete),
                new ItemData("Cloud",android.R.drawable.ic_menu_search),
                new ItemData("Favorite",android.R.drawable.ic_menu_mapmode),
                new ItemData("Like",android.R.drawable.ic_menu_myplaces),
                new ItemData("Rating",android.R.drawable.star_big_on)};
        */

        // this is data for recycler view
        String[] names = getResources().getStringArray(R.array.names);
        //int[] icons = getResources().getIntArray(R.array.icons);
        TypedArray icons = getResources().obtainTypedArray(R.array.icons);

        int size = names.length;
        Log.d(TAG,"size="+size);
        ItemData itemsData[] = new ItemData[size];
        for (int i=0; i<size; i++){
            int img = icons.getResourceId(i, -1);
            Log.d(TAG,"i="+i+"->name="+names[i].toString()+",icon="+img);
            itemsData[i] = new ItemData(names[i],img);
        }

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
