package com.coolopool.coolopool.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.AmenitiesAdapter;
import com.coolopool.coolopool.Class.Amenities;
import com.coolopool.coolopool.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailHotelActivity extends AppCompatActivity {

    Boolean readMoreExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        setUpToolbar();

        setUpRecyclerViewForAmenities();

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

    private void setUpRecyclerViewForAmenities(){
        ArrayList<Amenities> amenities = new ArrayList<>();
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Wifi"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Food"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Laundry And many more services are included"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Room service"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Parking"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Spa"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Bar/Lounge"));

        AmenitiesAdapter adapter = new AmenitiesAdapter(amenities, DetailHotelActivity.this);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.detail_hotel_activity_amenities_recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new GridLayoutManager(DetailHotelActivity.this, 2));

        recyclerView.setAdapter(adapter);






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
