package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class SignUpActivity extends AppCompatActivity {

    Button mNextButton;
    TextView mLoginButton;
    private EditText etusername, etpassword, etconfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etusername =  findViewById(R.id.userName);
        etpassword =  findViewById(R.id.password);
        etconfirmPassword =  findViewById(R.id.confPassword);

        // use for creating account
        mNextButton = findViewById(R.id.nextButtton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Next button has clicked");
                setUpSignUp();
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

    private void setUpSignUp(){
        String username = etusername.getText().toString().trim();
        String password = etpassword.getText().toString().trim();
        String confirmPassword = etconfirmPassword.getText().toString().trim();
        Intent intent = new Intent(SignUpActivity.this,SignUp2Activity.class);
        if(username.isEmpty()){
            etusername.setError("Please enter a valid Username.");
            etusername.requestFocus();
            return;
        }

        if(password.isEmpty() || password.length() < 4){
            etpassword.setError("Please enter a valid Password.");
            etpassword.requestFocus();
            return;
        }

        if(!confirmPassword.equals(password)){
            etconfirmPassword.setError("Password doesn't match.");
            etconfirmPassword.requestFocus();
            return;
        }
        intent.putExtra("Username", username);
        intent.putExtra("Password", password);
        startActivity(intent);
    }
}
