package com.copticstream.copticstreamdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import demo.StreamTest;


public class MainActivity extends ActionBarActivity {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        To Test the Live Stream -RTMP - last test Was 2/28/2015
//        Intent intent = new Intent(this, StreamTest.class);
//        startActivity(intent);

        fragment = new FragmentMain();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainContent,fragment).commit();

    }


}
