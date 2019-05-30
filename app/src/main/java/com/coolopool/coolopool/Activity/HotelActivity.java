package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.coolopool.coolopool.R;

public class HotelActivity extends AppCompatActivity {

    ImageButton mHomeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

    mHomeButton = findViewById(R.id.homeBtn);
    mHomeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Log_test","Home button is clicked");
            Intent intent = new Intent(HotelActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    });
    }
}
