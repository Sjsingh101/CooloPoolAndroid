package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class SignUpActivity extends AppCompatActivity {

    Button mNextButton;
    TextView mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        // use for creating account
        mNextButton = findViewById(R.id.nextButtton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Next button has clicked");
                Intent intent = new Intent(SignUpActivity.this,SignUp2Activity.class);
                startActivity(intent);
            }
        });

        // Use if there is a account
        mLoginButton = findViewById(R.id.Login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","I have account has Login clicked");
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
