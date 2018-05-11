package com.example.zarnea.earthquakeapp.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class EarthQuake {

    String location;
    Double magnitude;
    Long date;
    String alert;
    int tsunami;
    String eventUrl;

    public EarthQuake(JSONObject json) throws JSONException {
        location = json.getJSONObject("properties").getString("place");
        magnitude = json.getJSONObject("properties").getDouble("mag");
        date = json.getJSONObject("properties").getLong("time");
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

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
