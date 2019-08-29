package com.coolopool.coolopool.Backend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.coolopool.coolopool.Activity.HomeActivity;
import com.coolopool.coolopool.Activity.LoginActivity;
import com.coolopool.coolopool.Activity.SignUp2Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Authentication {

    String EMAIL = "@coolopool.com";

    Context context;
    Activity activity;

    FirebaseAuth auth;



    //use the correct activity for authentication
    public Authentication(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        init();
    }

    private void init(){
        auth = FirebaseAuth.getInstance();
    }

    public void signUp(String userName, String password, final Uri uri){
        if(activity instanceof LoginActivity){ return; }
        auth.createUserWithEmailAndPassword(userName+EMAIL, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(activity, "User with this email already exist.", Toast.LENGTH_SHORT).show();
                            activity.onBackPressed();
                        }
                        if(task.isSuccessful()){
                            Storage storage = new Storage(context, activity, uri);
                            storage.storeProfilePic(task.getResult().getUser().getUid());
                            context.startActivity(new Intent(activity, HomeActivity.class));
                        }
                    }
                });
    }

    public void loginUser(String userName, String password){
        if(activity instanceof SignUp2Activity){ return; }
        if (isUserLoggedIn()){
            context.startActivity(new Intent(context, HomeActivity.class));
        }else{
            auth.signInWithEmailAndPassword(userName+EMAIL, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.getException() != null)
                    Toast.makeText(activity, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    if(task.isSuccessful()){
                        context.startActivity(new Intent(activity, HomeActivity.class));
                    }
                }
            });
        }
    }

    public boolean isUserLoggedIn(){
        if(auth.getCurrentUser() != null){
            return true;
        }
        return false;
    }

}
