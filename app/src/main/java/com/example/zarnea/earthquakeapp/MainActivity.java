package com.example.zarnea.earthquakeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.zarnea.earthquakeapp.Models.EarthQuake;
import com.example.zarnea.earthquakeapp.Utils.ApiUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<EarthQuake> earthQuakes = new ArrayList<>();

    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.show);

        ApiUtils.getEarthQuake(getApplicationContext(), new Response.Listener(){

            @Override
            public void onResponse(Object response) {
                try {
                    JSONObject json = new JSONObject(response.toString());
                    for(int i = 0; i < json.getJSONArray("features").length();i++){
                        EarthQuake earthQuake = new EarthQuake(json.getJSONArray("features").getJSONObject(i));
                        earthQuakes.add(earthQuake);
                    }

                    for(EarthQuake earthQuake : earthQuakes){
                        System.out.println(earthQuake);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EarthQuakeActivity.class);
                startActivity(i);
            }
        });

    }
}
