package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
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

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
                intent.putExtra("name",UserName);
                startActivity(intent);
            }
        });

        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,WelcomeActivity.class));
            }
        });
    }
}
