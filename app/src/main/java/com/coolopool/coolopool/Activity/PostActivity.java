package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.widget.ShareActionProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.coolopool.coolopool.Adapter.ImageAdapter;
import com.coolopool.coolopool.Adapter.NewDayAdapter;
import com.coolopool.coolopool.Class.NewDay;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareActionProvider shareActionProvider = new ShareActionProvider(PostActivity.this);
                startActivity(createShareIntent());
            }
        });

        final ImageView back = findViewById(R.id.post_activity_back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ArrayList<Integer> id = new ArrayList<>();

        id.add(R.drawable.photo2);
        id.add(R.drawable.photo4);
        id.add(R.drawable.photo1);
        id.add(R.drawable.photo5);
        id.add(R.drawable.photo3);
        id.add(R.drawable.photo1);
        id.add(R.drawable.photo2);
        id.add(R.drawable.photo3);

        ArrayList<Uri> images = new ArrayList<>();
        images.add(Uri.parse("http://i.dailymail.co.uk/i/pix/2015/09/01/18/2BE1E88B00000578-3218613-image-m-5_1441127035222.jpg"));
        images.add(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW4Nk37FHhnKN751J2Q_NkQyZbmyxcXrLc07zuNkMTc2dEW1tL"));
        images.add(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0okvrDXft-KUed0v_z14BvNzuKqgpCNIrdHh4m-xOQ9u0fQLa"));
        images.add(Uri.parse("https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_960_720.jpg"));
        images.add(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcy6Jw27D75372TBFKumrXhCIV6TA3ckCMJocWwng-V-eNdKkjwg"));




        ArrayList<NewDay> days = new ArrayList<>();
        NewDay.COUNT = 1;
        days.add(new NewDay("Demo description: 1", PostActivity.this, images));
        days.add(new NewDay("Demo description: 2", PostActivity.this));
        days.add(new NewDay("Demo description: 3", PostActivity.this, images));
        days.add(new NewDay("Demo description: 4", PostActivity.this));
        days.add(new NewDay("Demo description: 5", PostActivity.this, images));




        NewDayAdapter newDayAdapter = new NewDayAdapter(days, this, 1);





        RecyclerView recyclerView = findViewById(R.id.post_activity_days_recyclerView);
        ImageAdapter adapter = new ImageAdapter(id, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);

        recyclerView.setAdapter(newDayAdapter);



    }


    private Intent createShareIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ruby.bastardsbook.com/chapters/html-parsing/"));
        return intent;
    }
}
