package com.copticstream.copticstreamdroid;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Mina on 2/28/2015.
 */
public class FragmentMain extends Fragment {
    View view;
    Toolbar toolbar;
    private static final String TAG = "FragmentMain";

    public FragmentMain() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_drawer));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MainActivity.drawerLayout.openDrawer(MainActivity.drawerPane);
            }
        });

        return view;
    }
}
