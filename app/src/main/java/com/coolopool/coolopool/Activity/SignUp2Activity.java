package com.coolopool.coolopool.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Class.User;
import com.coolopool.coolopool.Interface.TripClient;
import com.coolopool.coolopool.R;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 1;
    Button mCreateButton;
    TextView mLoginButton;
    CircleImageView mUserProfilePic;
    private String username, password, name, phoneNo, email;

    EditText etname, etphoneNo, etemail;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

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
                    if(createAccount() == 1) {
                        Intent createAccountIntent = new Intent(SignUp2Activity.this, LoginActivity.class);
                        startActivity(createAccountIntent);
                    }
                } else {
                    Toast.makeText(SignUp2Activity.this,"No Internet Connection.",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private int createAccount() {

        name = etname.getText().toString().trim();
        phoneNo = etphoneNo.getText().toString().trim();
        email = etemail.getText().toString().trim();

        if(name.isEmpty()){
            etname.setError("Please enter a valid Name.");
            etname.requestFocus();
            return 0;
        }

        if(phoneNo.isEmpty() || phoneNo.length() < 10){
            etphoneNo.setError("Please enter a valid phone number.");
            etphoneNo.requestFocus();
            return 0;
        }

        if(email.isEmpty()){
            etemail.setError("Please enter a valid email.");
            etemail.requestFocus();
            return 0;
        }

        User user = new User(username, password, name, phoneNo, email);

        // add the url here
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TripClient client = retrofit.create(TripClient.class);
        Call<ResponseBody> call = client.createAccount(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(SignUp2Activity.this, "Account created.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SignUp2Activity.this, "Oops something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        return 1;
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

    private void getIntentData() {

        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
        password = intent.getStringExtra("Password");
    }

}
