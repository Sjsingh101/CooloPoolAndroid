package com.coolopool.coolopool.Activity;

import android.app.ActivityOptions;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Helper.OnSwipeTouchListener;
import com.coolopool.coolopool.R;

public class NewPostActivity extends AppCompatActivity {

    LinearLayout swipeUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        final EditText title = (EditText)findViewById(R.id.new_post_activity_title_editText);
        final EditText description = (EditText)findViewById(R.id.new_post_activity_description_editText);
        final DatePicker datePicker = (DatePicker)findViewById(R.id.new_post_activity_date_datePicker);

        swipeUp = findViewById(R.id.swipe_up);

        swipeUp.setOnTouchListener(new OnSwipeTouchListener(NewPostActivity.this){



            @Override
            public void onSwipeUp() {

                super.onSwipeUp();
                Intent draftPostActivity = new Intent(NewPostActivity.this,PostDraftActivity.class);
                draftPostActivity.putExtra("Title", title.getText().toString().trim());
                draftPostActivity.putExtra("Description", description.getText().toString().trim());
                String date = "";
                date = date + MyApplication.MONTHS[datePicker.getMonth()] + " " + datePicker.getDayOfMonth() + ", " + datePicker.getYear();
                draftPostActivity.putExtra("Date", date);

                Pair<View, String> pair_title = Pair.create((View)title, "POST_TITLE");
                Pair<View, String> pair_date = Pair.create((View)datePicker, "POST_DATE");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewPostActivity.this, pair_title, pair_date);


                startActivity(draftPostActivity, activityOptions.toBundle());
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                // your swipe down here.
            }
        });
    }


}
