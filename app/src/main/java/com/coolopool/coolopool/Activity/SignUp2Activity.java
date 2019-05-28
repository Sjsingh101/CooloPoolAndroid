package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class SignUp2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 1;
    Button mCreateButton;
    TextView mLoginButton;
    ImageButton mUserProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        mUserProfilePic = findViewById(R.id.userProfilePic);
        mCreateButton = findViewById(R.id.createAccountButton);
        mLoginButton = findViewById(R.id.Login_btn);

        mUserProfilePic.setOnClickListener(this);
        mCreateButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
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
                Intent createAccountIntent = new Intent(SignUp2Activity.this,LoginActivity.class);
                startActivity(createAccountIntent);
                break;
            case R.id.Login_btn:
                Intent loginIntent = new Intent(SignUp2Activity.this,LoginActivity.class);
                startActivity(loginIntent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE &&resultCode == RESULT_OK && data != null ){
            Uri selectedImage = data.getData();
            mUserProfilePic.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            mUserProfilePic.setImageURI(selectedImage);

        }
    }
}
