package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.coolopool.coolopool.Backend.Authentication;
import com.coolopool.coolopool.R;
import com.coolopool.coolopool.Storage.SharedPrefManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {


    Button mNextButton;
    TextView mLoginButton;
    private EditText etusername, etpassword, etconfirmPassword;
    CircleImageView googleLogin;
    GoogleApiClient mSignInClient;

    String googleProfileImageUrl;
    String googleAccountHolderName;
    public static final int GOOGLE_SIGN_IN = 100;
    Boolean isGoogleSignUp = false;

    Authentication authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        authentication = new Authentication(this, SignUpActivity.this);

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

        googleLogin = (CircleImageView) findViewById(R.id.google_login);

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication.googleSignIn();
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


        intent.putExtra("GoogleDisplayName", googleAccountHolderName);
        intent.putExtra("GooglePicUrl", googleProfileImageUrl);
        intent.putExtra("IsGoogleSignIn", isGoogleSignUp);

        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GOOGLE_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            etusername.setText(result.getSignInAccount().getEmail());
            googleAccountHolderName = result.getSignInAccount().getDisplayName();
            googleProfileImageUrl = result.getSignInAccount().getPhotoUrl().toString();
            isGoogleSignUp = true;
        }
    }

}