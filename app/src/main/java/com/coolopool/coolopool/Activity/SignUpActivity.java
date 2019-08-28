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

import com.coolopool.coolopool.R;
import com.coolopool.coolopool.Storage.SharedPrefManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
    GoogleSignInClient msignInClient;
    private static final int RC_SIGN_IN = 0;

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

        googleLogin = (CircleImageView) findViewById(R.id.google_login);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            updateUI(account);
        } catch (ApiException e) {
            Log.w("Google Sign In Error", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(SignUpActivity.this, "Failed to Log in", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateUI(GoogleSignInAccount account) {
        account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            String name = account.getDisplayName();
            String email = account.getEmail();
            String img_url = account.getPhotoUrl().toString();
            LoginActivity.UserName = name;

            // THIS IS JUST TEMPORARY, HAVE TO CHANGE THIS
            JSONObject temp = new JSONObject();
            try {
                temp.put("id",1);
                temp.put("title", "Post 1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SharedPrefManager.getInstance(SignUpActivity.this).saveUser(temp.toString());
            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}