package com.coolopool.coolopool.Activity;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.coolopool.coolopool.Backend.Model.Day;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Adapter.NewDayAdapter;
import com.coolopool.coolopool.Class.NewDay;
import com.coolopool.coolopool.Class.NewTrip;
import com.coolopool.coolopool.Interface.TripClient;
import com.coolopool.coolopool.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostDraftActivity extends AppCompatActivity {

    public static final int SELECT_PICTURE = 100;

    private static int count = 1;
    private String tripTitle, tripDescription, tripDate;

    DrawerLayout drawer;

    ArrayList<NewDay> days;
    NewDayAdapter adapter;
    RecyclerView recyclerView;

    int noOfTrips;
    FirebaseAuth mAuth;
    ArrayList<String> downloadUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_draft);
        init();
        loadIntentData();
        setUpBackButton();
        setUpNavigationDrawer();
        setUpToolbar();
        setUpFabButton();

    }


    private void init() {
        mAuth = FirebaseAuth.getInstance();
        drawer = findViewById(R.id.drawer_layout);
        days = new ArrayList<>();
        adapter = new NewDayAdapter(days, this);
        recyclerView = (RecyclerView) findViewById(R.id.post_draft_activity_content_holder_linearLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(PostDraftActivity.this));
        recyclerView.setHasFixedSize(false);

        recyclerView.setAdapter(adapter);
    }

    public void pickImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == SELECT_PICTURE) {
                if(data.getClipData() != null){
                    getMultipleSelectedPics(data);
                }
                adapter.addPhoto(Collections.singletonList(data.getData()));
            }
        }
    }

    private void getMultipleSelectedPics(Intent data){
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        ArrayList<String> imagesEncodedList = new ArrayList<String>();
        String imageEncoded;
        ClipData mClipData = data.getClipData();
        ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
        for (int i = 0; i < mClipData.getItemCount(); i++) {

            ClipData.Item item = mClipData.getItemAt(i);
            Uri uri = item.getUri();
            mArrayUri.add(uri);
            // Get the cursor
            Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imageEncoded  = cursor.getString(columnIndex);
            imagesEncodedList.add(imageEncoded);
            cursor.close();
        }
        ArrayList<Uri> selectedPhotos = new ArrayList<>();
        for(int i=0; i<mArrayUri.size(); i++){
            if(mArrayUri.get(i) != null){
                selectedPhotos.add(mArrayUri.get(i));
            }
        }
        adapter.addPhoto(selectedPhotos);
    }

    private void setUpNavigationDrawer() {
        ImageView menuToggle = (ImageView) findViewById(R.id.post_draft_activity_toolbar_menu_opener_imageView);

        menuToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.RIGHT);
            }
        });

        ((ImageView) findViewById(R.id.menu_item_icon_new_day_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostDraftActivity.this, "New day", Toast.LENGTH_SHORT).show();
                adapter.addDays(new NewDay("", PostDraftActivity.this));
                adapter.notifyDataSetChanged();
            }
        });

        ((ImageView) findViewById(R.id.menu_item_photos_icon_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostDraftActivity.this, "Photos", Toast.LENGTH_SHORT).show();
                pickImage();
            }
        });

    }

    private void setUpFabButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadTrip();
            }
        });
    }

    private void uploadTrip() {
        //preparing required data that is to be uploaded
        ArrayList<NewDay> newDays = adapter.getNewDays();
        storePicsOfSingleDay(getUriOfSingleDay(newDays.get(0)), 0);


    }

    private ArrayList<Uri> getUriOfSingleDay(NewDay newDay){
        ArrayList<Uri> uris = new ArrayList<>();
        for(int i=0; i<newDay.getmImageUri().size(); i++){
            uris.add(newDay.getmImageUri().get(i));
        }
        return uris;
    }

    private void storePicsOfSingleDay(ArrayList<Uri> uris, int dayCounter){
        //Todo: create a day array and upload pics of all day in a nested loop
        int noOfBlogs = getNoOfTrips();
        StorageReference mRef = FirebaseStorage.getInstance().getReference()
                .child("blogs/"+mAuth.getUid().toString())
                .child("blog"+noOfBlogs).child("day"+dayCounter);
        for(int k=0; k<uris.size(); k++){
            if(uris.get(k) != null){
                final StorageReference currentRef = mRef.child("pic"+k);
                Task t = currentRef.putFile(uris.get(k));
                t.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){
                            Log.d(">>>>>>>>>>>>>>>>>>>>", currentRef.getDownloadUrl().toString());
                            addUrl(currentRef.getDownloadUrl().toString());
                        }
                    }
                });

            }


        }

    }

    private void addUrl(String url){
        downloadUrl.add(url);
        Log.d(">>>>>>>>>>>>>>>>>>>>", "Uploaded: "+downloadUrl.size());
    }

    private int getNoOfTrips(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(mAuth.getUid().toString()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                noOfTrips = documentSnapshot.getLong("noOfTrips").intValue();
            }
        });

        return noOfTrips;
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadIntentData() {
        Intent intent = getIntent();
        tripTitle = intent.getStringExtra("Title");
        tripDescription = intent.getStringExtra("Description");
        tripDate = intent.getStringExtra("Date");
        ((TextView) findViewById(R.id.post_draft_activity_toolbar_title_textView)).setText(tripTitle);
        ((TextView) findViewById(R.id.post_draft_activity_toolbar_date_textView)).setText(tripDate);

    }

    private void setUpBackButton() {
        ((ImageView) findViewById(R.id.post_draft_activity_toolbar_back_button_imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }
}
