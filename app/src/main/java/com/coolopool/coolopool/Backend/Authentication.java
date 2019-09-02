package com.coolopool.coolopool.Backend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.coolopool.coolopool.Activity.HomeActivity;
import com.coolopool.coolopool.Activity.LoginActivity;
import com.coolopool.coolopool.Activity.SignUp2Activity;
import com.coolopool.coolopool.Backend.Model.User;
import com.coolopool.coolopool.Backend.Model.UserDatabase;
import com.coolopool.coolopool.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Authentication {

    Context context;
    Activity activity;
    FragmentActivity fActivity;

    FirebaseAuth auth;

    GoogleSignInOptions gso;
    GoogleApiClient googleSignInClient;


    //use the correct activity for authentication
    public Authentication(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        init();
    }

    private void init(){

        auth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        GoogleApiClient.OnConnectionFailedListener listener = new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }
        };
        googleSignInClient = new GoogleApiClient.Builder(context)
                .enableAutoManage((FragmentActivity) activity, listener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    public void fbSignIn(){

    }

    public void googleSignIn(){
        Intent googleIntent = Auth.GoogleSignInApi.getSignInIntent(googleSignInClient);
       activity.startActivityForResult(googleIntent, 100);
    }

    public void signUp(final User user, final Uri uri){
        if(activity instanceof LoginActivity){ return; }
        auth.createUserWithEmailAndPassword(user.getUsername(), user.getPassword())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(activity, "User with this email already exist.", Toast.LENGTH_SHORT).show();
                            activity.onBackPressed();
                        }
                        if(task.isSuccessful()){
                            user.setUid(task.getResult().getUser().getUid());
                            Storage storage = new Storage(context, activity, uri);
                            UserDatabase userDatabase = new UserDatabase(context, activity);
                            storage.storeProfilePic(task.getResult().getUser().getUid());
                            userDatabase.addUserToDatabase(user);

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
            auth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
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
