package com.coolopool.coolopool.Activity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coolopool.coolopool.Adapter.NewDayAdapter;
import com.coolopool.coolopool.Class.NewDay;
import com.coolopool.coolopool.Class.NewTrip;
import com.coolopool.coolopool.Interface.TripClient;
import com.coolopool.coolopool.R;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

                adapter.addPhoto(data.getData());
            }
        }
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

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        int imageNumber = count;

        List<Map<String, List<String>>> tripList = new ArrayList<>();
        for (int i = 0; i < days.size(); i++) {
            List<String> imagesNames = new ArrayList<>();
            for (int j = 0; j < days.get(i).getmImageUri().size(); j++)
                imagesNames.add(LoginActivity.getUsername() + count++);
            Map<String, List<String>> map = new HashMap<>();
            map.put("Description", new ArrayList<String>(Arrays.asList(days.get(i).getmDescription())));
            map.put("Images Name", imagesNames);
            tripList.add(map);
        }
        NewTrip trip = new NewTrip(tripTitle, tripDescription, tripDate, tripList);
        String string = new Gson().toJson(trip);

        TripClient client = retrofit.create(TripClient.class);

        List<MultipartBody.Part> parts = new ArrayList<>();

        for (int i = 0; i < days.size(); i++) {
            NewDay currentDay = days.get(i);
            for (int j = 0; j < currentDay.getmImageUri().size(); j++)
                parts.add(prepareFilePart(LoginActivity.getUsername() + imageNumber++, currentDay.getmImageUri().get(j)));
        }

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), string);

        Call<ResponseBody> call = client.uploadTrip(
                parts, body
        );
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(PostDraftActivity.this, "Trip Uploaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PostDraftActivity.this, "Sorry, trip isn't Uploaded.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {

        File file = new File(fileUri.getPath());

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(Objects.requireNonNull(getContentResolver().getType(fileUri))),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
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
