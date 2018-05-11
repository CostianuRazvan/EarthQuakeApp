package com.example.zarnea.earthquakeapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CardDetailsActivity extends Activity {

    Bundle data;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.card_details_activity);
        data = getIntent().getBundleExtra("data");

        TextView location = findViewById(R.id.location);
        TextView date = findViewById(R.id.date);
        TextView magnitude = findViewById(R.id.magnitude);
        TextView tsunami = findViewById(R.id.tsunami);
        TextView alert = findViewById(R.id.alert);
        TextView eventUrl = findViewById(R.id.eventUrl);

        location.setText("Location:" + data.getString("location"));
        date.setText("Date:" + data.getString("date"));
        magnitude.setText("Magnitude:" + String.valueOf(data.getDouble("magnitude")));
        tsunami.setText("Tsunami:" + String.valueOf(data.getInt("tsunami")));
        alert.setText("Alert:" + data.getString("alert"));
        eventUrl.setText("Event Url:" + data.getString("eventUrl"));

        eventUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getString("eventUrl")));
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}
