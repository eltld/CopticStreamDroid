package com.copticstream.copticstreamdroid;

import android.app.DownloadManager;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;
import com.facebook.Session;
import org.json.JSONException;
import org.json.JSONObject;

import demo.Constants;
import util.VolleySingleton;

/**
 * Created by Mina on 2/28/2015.
 */
public class FragmentMain extends Fragment implements Constants {
    View view;
    TextView arabic;
    TextView english;
    Toolbar toolbar;
    ProgressDialog progressDialog;
    private static final String TAG = "FragmentMain";

    public FragmentMain() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);


        progressDialog = ProgressDialog.show(getActivity(),"","Loading...");

        toolbar = (Toolbar) view.findViewById(R.id.app_bar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.drawer_icon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawerLayout.openDrawer(MainActivity.drawerPane);
            }
        });

         arabic = (TextView) view.findViewById(R.id.arabic_verse);
         english = (TextView) view.findViewById(R.id.english_verse);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, VERSE_OF_THE_DAY, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "Verse Loaded...");


                            try {
                                String arabicVerse = response.getString("verseArabic");
                                String englishVerse = response.getString("verseEnglish");
                                arabic.setText(arabicVerse);
                                english.setText(englishVerse);
                                progressDialog.dismiss();
                            } catch (JSONException e) {

                                e.printStackTrace();
                            }
                        }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        arabic.setText("اشْكُرُوا فِي كُلِّ شَيْءٍ، لأَنَّ هَذِهِ هِيَ مَشِيئَةُ اللهِ فِي الْمَسِيحِ يَسُوعَ مِنْ جِهَتِكُمْ.. 1 تسالونيكي 5 : 18");
                        english.setText("In everything give thanks; for this is the will of God in Christ Jesus for you. 1 THESSALONIANS 5 : 18");
                        progressDialog.dismiss();
                    }
                });

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);






        return view;
    }


}
