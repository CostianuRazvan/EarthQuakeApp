package com.example.zarnea.earthquakeapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.zarnea.earthquakeapp.Adapter.EarthQuakeAdapter;
import com.example.zarnea.earthquakeapp.Models.EarthQuake;
import com.example.zarnea.earthquakeapp.Utils.ApiUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EarthQuakeActivity extends Activity {


    RecyclerView viewPager;
    EarthQuakeAdapter adapter;
    ArrayList<EarthQuake> earthQuakes = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.eathquake_activity);
        viewPager = findViewById(R.id.pager);



        ApiUtils.getEarthQuake(getApplicationContext(), new Response.Listener(){

            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Object response) {
                try {
                    JSONObject json = new JSONObject(response.toString());
                    for(int i = 0; i < json.getJSONArray("features").length();i++){
                        EarthQuake earthQuake = new EarthQuake(json.getJSONArray("features").getJSONObject(i));
                        earthQuakes.add(earthQuake);
                        if(earthQuake.getMagnitude() > 6.5){
                            sendNotification(getApplicationContext(), "Cutremur foarte mare","WARNING");
                        }
                    }
                    // Creating ViewPager Adapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs
                    adapter = new EarthQuakeAdapter(earthQuakes, getApplicationContext(), EarthQuakeActivity.this, getResources());

                    // Assigning ViewPager View and setting the adapter
                    viewPager.setAdapter(adapter);
                    linearLayoutManager = new LinearLayoutManager(EarthQuakeActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    viewPager.setLayoutManager(linearLayoutManager);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });




    }

    public static void sendNotification(Context context, String messageBody, String title) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle extras = new Bundle();
        extras.putBoolean("NotificationTap", true);
        intent.putExtras(extras);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title == null ? "YOUniverse" : title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(messageBody));

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }
}
