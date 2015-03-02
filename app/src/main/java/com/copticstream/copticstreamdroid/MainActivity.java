package com.copticstream.copticstreamdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


import custom.DrawerItem;
import util.DrawerListBaseAdapter;
import util.VolleySingleton;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    public ListView drawerList;
    public static RelativeLayout drawerPane;
    public static DrawerLayout drawerLayout;

    private ArrayList<DrawerItem> drawerItems;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        To Test the Live Stream -RTMP - last test Was 2/28/2015
//        Intent intent = new Intent(this, StreamTest.class);
//        startActivity(intent);

        drawerItems = new ArrayList<DrawerItem>();
        drawerItems.add(new DrawerItem("Live TV", R.drawable.tv));


        DrawerListBaseAdapter drawerListBaseAdapter = new DrawerListBaseAdapter(MainActivity.this, drawerItems);
        drawerList = (ListView) findViewById(R.id.navList);
        drawerList.setAdapter(drawerListBaseAdapter);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id){
                    case 0 :

                        break;

                }
            }
        });






        fragment = new FragmentMain();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainContent,fragment).commit();

    }


}
