package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.NestedImageAdapter;
import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewPicPostActivity extends AppCompatActivity {

    public static final int SELECT_COVER_PICTURE = 101;
    public static final int SELECT_POST_PICTURE = 201;

    ImageView coverImage;

    ArrayList<Uri> mImageUri;
    NestedImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pic_post);
        coverPhotoSetup();
       /* setUpBackButton();*/

        RecyclerView pics = (RecyclerView) findViewById(R.id.new_pic_post_activity_pics_recyclerView);
        pics.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        pics.setHasFixedSize(false);

        mImageUri = new ArrayList<>();
        adapter = new NestedImageAdapter(mImageUri, this, 1);

        pics.setAdapter(adapter);

        ((TextView) findViewById(R.id.new_pic_post_activity_add_pics_textView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPostImage();
            }
        });
    }

  /*  private void setUpBackButton(){
        ((ImageView)findViewById(R.id.new_pic_post_activity_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }*/

    private void coverPhotoSetup() {
        coverImage = (ImageView) findViewById(R.id.new_pic_post_activity_cover_pic_imageView);

        coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickCoverImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_COVER_PICTURE) {

                //Get ImageURi and load with help of picasso
                Uri selectedImageURI = data.getData();

                Picasso.get().load(selectedImageURI).fit().centerCrop().into(coverImage);


            } else if (requestCode == SELECT_POST_PICTURE) {
                Uri selectedImageURI = data.getData();
                adapter.addUri(selectedImageURI);
                adapter.notifyDataSetChanged();
            }

        }
    }


    public void pickPostImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Post Picture"), SELECT_POST_PICTURE);

    }


    public void pickCoverImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_COVER_PICTURE);

    }

    private void setUpBackButton(){
        ((ImageView)findViewById(R.id.new_pic_post_activity_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


}
