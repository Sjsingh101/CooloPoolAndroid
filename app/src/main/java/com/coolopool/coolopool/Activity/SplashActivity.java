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

import com.coolopool.coolopool.R;
import com.coolopool.coolopool.Storage.SharedPrefManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

                if (SharedPrefManager.getInstance(SplashActivity.this).isLoggedIn()) {
                    new Timer().schedule(new TimerTask(){
                        public void run() {
                            Log.d("Log_test","home screen open");
                            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000 );
                }
                else {
                    /*startActivity(new Intent(SplashActivity.this, HomeActivity.class));*/
                    new Timer().schedule(new TimerTask(){
                        public void run() {
                            Log.d("Log_test","Login screen open");
                            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000 );
                }
                }
    }