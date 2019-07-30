package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class SettingActivity extends AppCompatActivity {

    TextView mProfileButton, mPrivacyButton, mAboutButton, mLogoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    mProfileButton = findViewById(R.id.profilebtn);
    mProfileButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =  new Intent(SettingActivity.this, ProfileSettingActivity.class);
            startActivity(intent);
        }
    });
    }
}
