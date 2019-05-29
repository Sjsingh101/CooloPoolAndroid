package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
   // ImageButton mBackButton;  uncomment if back button is required.
    TextView signUpbtn;
    String UserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // testing
        UserName="Sj Singh";

        loginbtn = findViewById(R.id.login_btn);
        signUpbtn = findViewById(R.id.SignUp_btn);

       //  uncomment if back button is required.
       /* mBackButton = findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });*/

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Login button is clicked");
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("name",UserName);
                startActivity(intent);
            }
        });

        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Sign UP button is clicked");
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
