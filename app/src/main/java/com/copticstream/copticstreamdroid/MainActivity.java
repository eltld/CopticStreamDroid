package com.copticstream.copticstreamdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


import custom.DrawerItem;
import util.DrawerListBaseAdapter;


public class MainActivity extends ActionBarActivity {

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
        drawerItems.add(new DrawerItem("Live Stream", R.drawable.tv));


        DrawerListBaseAdapter drawerListBaseAdapter = new DrawerListBaseAdapter(MainActivity.this, drawerItems);
        drawerList = (ListView) findViewById(R.id.navList);
        drawerList.setAdapter(drawerListBaseAdapter);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);


        fragment = new FragmentMain();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainContent,fragment).commit();

    }


}
