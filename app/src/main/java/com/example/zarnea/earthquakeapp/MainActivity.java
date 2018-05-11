package com.example.zarnea.earthquakeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {



    Button show;
    Button showEmailPage;
    Button showTelephonePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.show);
        showEmailPage = findViewById(R.id.showEmailPage);
        showTelephonePage = findViewById(R.id.showTelephonePage);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EarthQuakeActivity.class);
                startActivity(i);
            }
        });
        showEmailPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EmailActivity.class);
                startActivity(i);
            }
        });
        showTelephonePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CallActivity.class);
                startActivity(i);
            }
        });

    }
}
