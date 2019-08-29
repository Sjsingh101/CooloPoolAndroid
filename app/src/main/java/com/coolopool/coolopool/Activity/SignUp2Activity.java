package com.coolopool.coolopool.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Backend.Authentication;
import com.coolopool.coolopool.R;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 1;
    Button mCreateButton;
    TextView mLoginButton;
    CircleImageView mUserProfilePic;
    private String username, password, name, phoneNo, email;

    EditText etname, etphoneNo, etemail;
    NetworkInfo networkInfo;

    Authentication authentication;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        authentication = new Authentication(this, SignUp2Activity.this);

        getIntentData();

        etname =  findViewById(R.id.Name);
        etphoneNo =  findViewById(R.id.phoneNo);
        etemail =  findViewById(R.id.email);

        mUserProfilePic = findViewById(R.id.userProfilePic);
        mCreateButton = findViewById(R.id.createAccountButton);

        mUserProfilePic.setOnClickListener(this);
        mCreateButton.setOnClickListener(this);

        ConnectivityManager connMgr =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        networkInfo = connMgr.getActiveNetworkInfo();
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.userProfilePic:
                Intent galleryintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryintent, RESULT_LOAD_IMAGE);
                break;
            case R.id.createAccountButton:
                if (networkInfo != null && networkInfo.isConnected()) {
                    createAccount();
                } else {
                    Toast.makeText(SignUp2Activity.this,"No Internet Connection.",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void createAccount() {

        name = etname.getText().toString().trim();
        phoneNo = etphoneNo.getText().toString().trim();
        email = etemail.getText().toString().trim();

        if(name.isEmpty()){
            etname.setError("Please enter a valid Name.");
            etname.requestFocus();
            return;
        }

        if(phoneNo.isEmpty() || phoneNo.length() < 10){
            etphoneNo.setError("Please enter a valid phone number.");
            etphoneNo.requestFocus();
            return;
        }

        if(email.isEmpty()){
            etemail.setError("Please enter a valid email.");
            etemail.requestFocus();
            return;
        }

        authentication.signUp(username, password, uri);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE &&resultCode == RESULT_OK && data != null ){
            uri = data.getData();

            mUserProfilePic.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            mUserProfilePic.setImageURI(uri);

        }
    }


    private void getIntentData() {

        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
        password = intent.getStringExtra("Password");
    }

}
