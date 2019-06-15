package com.coolopool.coolopool.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.coolopool.coolopool.R;

import org.w3c.dom.Text;

public class DetailHotelActivity extends AppCompatActivity {

    Boolean readMoreExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        setUpToolbar();

        final TextView hotelInfo = (TextView)findViewById(R.id.detail_hotel_activity_info_textView);
        final TextView readMoreButton = (TextView)findViewById(R.id.detail_hotel_activity_readMore_textView);

        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(readMoreExpanded){
                    readMoreButton.setText("Read more");
                    hotelInfo.setMaxLines(3);
                    readMoreExpanded = false;
                }else{
                    readMoreButton.setText("Less");
                    hotelInfo.setMaxLines(Integer.MAX_VALUE);
                    readMoreExpanded = true;
                }
            }
        });



    }

    private void setUpToolbar(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Hotel Name");

        setSupportActionBar(toolbar);

        (getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);

    }
}
