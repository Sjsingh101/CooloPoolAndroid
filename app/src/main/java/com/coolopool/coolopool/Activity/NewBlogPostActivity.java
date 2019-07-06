package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.coolopool.coolopool.R;
import com.squareup.picasso.Picasso;

public class NewBlogPostActivity extends AppCompatActivity {

    public static final int SELECT_COVER_PICTURE = 300;

    ImageView coverImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_blog_post);
        coverPhotoSetup();
        setUpBackButton();
    }

    private void setUpBackButton(){
        ((ImageView)findViewById(R.id.new_blog_post_activity_back_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void coverPhotoSetup() {
        coverImage = (ImageView) findViewById(R.id.new_blog_post_activity_cover_pic_imageView);

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

            }

        }
    }

    public void pickCoverImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_COVER_PICTURE);

    }

}
