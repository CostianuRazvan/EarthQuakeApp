package com.example.zarnea.earthquakeapp.Utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class ApiUtils {

    private static final String BASE_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson";

    public static void getEarthQuake(Context context, Response.Listener<String> successListener, Response.ErrorListener errorListener) {
        RequestQueue queue = Volley.newRequestQueue(context);

        CustomStringRequest request = new CustomStringRequest(null, true, Request.Method.GET, BASE_URL, successListener, errorListener, context);
        queue.add(request);
    }

}
