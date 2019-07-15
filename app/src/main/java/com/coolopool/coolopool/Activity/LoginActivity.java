package com.coolopool.coolopool.Activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.coolopool.coolopool.R;
import com.coolopool.coolopool.Storage.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    // ImageButton mBackButton;  uncomment if back button is required.
    TextView signUpbtn;
    String UserName, Password;

    // Dummy URL only for testing, change it when get the real URL of the api
    private final String LOGIN_URL = "https://my-json-server.typicode.com/typicode/demo/posts/1";
    private EditText etusername;
    private EditText etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername = findViewById(R.id.login_name);
        etpassword = findViewById(R.id.login_pass);

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


        ConnectivityManager connMgr =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        final NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log_test","Login button is clicked");
                // If there is a network connection, setup Login
                if (networkInfo != null && networkInfo.isConnected()) {
                    setUpLogin();
                } else {
                    Toast.makeText(LoginActivity.this,"No Internet Connection.",Toast.LENGTH_SHORT).show();
                }
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

    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void setUpLogin(){
        UserName = etusername.getText().toString().trim();
        Password = etpassword.getText().toString().trim();

        if(UserName.isEmpty()){
            etusername.setError("Please enter a valid Username!");
            etusername.requestFocus();
            return;
        }

        if(Password.isEmpty() || Password.length() < 4){
            etpassword.setError("Please enter a valid Password!");
            etpassword.requestFocus();
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.GET, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(SharedPrefManager.getInstance(LoginActivity.this).saveUser(response) == 1) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Log_test", error.toString());
            }
        }) ;

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
