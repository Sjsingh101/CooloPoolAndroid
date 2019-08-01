package com.coolopool.coolopool.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.coolopool.coolopool.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSettingActivity extends AppCompatActivity {


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

        CircleImageView circleImageView = findViewById(R.id.profilepic);
        context = ProfileSettingActivity.this;

        Glide
                .with(context)
                .load(R.drawable.userfacepic)
                .into(circleImageView);
    }
}
