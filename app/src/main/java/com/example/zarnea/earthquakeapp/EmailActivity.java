package com.example.zarnea.earthquakeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailActivity extends Activity {
    Button email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);
        email = findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("plain/text").putExtra(Intent.EXTRA_EMAIL, new String[]{"example@example.com"});
                startActivity(i);
            }
        });
    }
}
