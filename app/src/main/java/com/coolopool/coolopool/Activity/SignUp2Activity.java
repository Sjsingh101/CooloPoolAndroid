package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class SignUp2Activity extends AppCompatActivity {

    Button mCreateButton;
    TextView mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        // use for creating account
        mCreateButton = findViewById(R.id.createAccountButton);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Create Account has clicked");
                Intent intent = new Intent(SignUp2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        // Use if there is a account
        mLoginButton = findViewById(R.id.Login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","I have account has Login clicked");
                Intent intent = new Intent(SignUp2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
