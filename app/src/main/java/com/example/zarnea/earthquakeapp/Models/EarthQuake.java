package com.example.zarnea.earthquakeapp.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class EarthQuake {

    String location;
    Double magnitude;
    int date;
    String alert;
    int tsunami;
    String eventUrl;

    public EarthQuake(JSONObject json) throws JSONException {
        location = json.getJSONObject("properties").getString("place");
        magnitude = json.getJSONObject("properties").getDouble("mag");
        date = json.getJSONObject("properties").getInt("time");
        alert = json.getJSONObject("properties").getString("alert");
        tsunami = json.getJSONObject("properties").getInt("tsunami");
        eventUrl = json.getJSONObject("properties").getString("url");
    }

    @Override
    public String toString() {
        return "EarthQuake{" +
                "location='" + location + '\'' +
                ", magnitude=" + magnitude +
                ", date=" + date +
                ", alert='" + alert + '\'' +
                ", tsunami=" + tsunami +
                ", eventUrl='" + eventUrl + '\'' +
                '}';
    }
}
