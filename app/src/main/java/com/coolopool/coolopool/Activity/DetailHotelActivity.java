package com.coolopool.coolopool.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.coolopool.coolopool.Adapter.AmenitiesAdapter;
import com.coolopool.coolopool.Adapter.ReviewAdapter;
import com.coolopool.coolopool.Class.Amenities;
import com.coolopool.coolopool.Class.Review;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class DetailHotelActivity extends AppCompatActivity {

    Boolean infoReadMoreExpanded = false;
    Boolean amenitiesReadMoreExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        setUpToolbar();

        setUpAmenities();

        setUpHotelInfo();

        setUpReview();

    }


    private void setUpReview(){
        String des = "Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions and limitations under the License.";
        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(new Review(R.drawable.pic1, 4, "Delhi, Near hauz khas metro", "Clean and comfortable", des, "20 Jun 2019"));
        reviews.add(new Review(R.drawable.pic2, 3.5f, "varanasi, Near godowlia khas metro", "Excellent stay", des, "02 Apr 2019"));
        reviews.add(new Review(R.drawable.pic3, 2.5f, "Delhi, Near hauz khas metro", "Strange, but liked it", des, "20 May 2017"));
        reviews.add(new Review(R.drawable.google_logo, 4, "Chennai, Near hauz khas metro", "Well organised", des, "01 Jan 2018"));
        reviews.add(new Review(R.drawable.pic3, 2.0f, "Delhi, Near hauz khas metro", "Very poor", des, "09 Sep 2019"));
        reviews.add(new Review(R.drawable.pic1, 3f, "Hyderabad, Near hauz khas metro", "Average, great location", des, "23 Feb 2019"));
        reviews.add(new Review(R.drawable.pic1, 4.7f, "Bangalore, Near hauz khas metro", "Memorable stay", des, "03 May 2017"));


        ReviewAdapter reviewAdapter = new ReviewAdapter(reviews, DetailHotelActivity.this);
        RecyclerView reviewRecyclerView = findViewById(R.id.detail_hotel_activity_review_list_recyclerView);
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(DetailHotelActivity.this));
        reviewRecyclerView.setHasFixedSize(false);

        reviewRecyclerView.setAdapter(reviewAdapter);
    }

    private void sentMapIntent(String location){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    private void setUpAmenities(){
        final ArrayList<Amenities> amenities = new ArrayList<>();
        final AmenitiesAdapter adapter = new AmenitiesAdapter(amenities, DetailHotelActivity.this);
        final EditText locationText = findViewById(R.id.detail_hotel_activity_location_info_editText);

        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Wifi"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Food"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Laundry And many more services are included"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Room service"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Parking"));
        amenities.add(new Amenities(R.drawable.ic_wifi_black, "Spa"));

        final TextView seeAllButton = findViewById(R.id.detail_hotel_activity_see_all_amenities_textView);

        seeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(amenitiesReadMoreExpanded){
                    seeAllButton.setText("See all amenities");
                    amenities.removeAll(amenities.subList(6, amenities.size()));
                    amenitiesReadMoreExpanded = false;
                }else{
                    seeAllButton.setText("Less");
                    amenities.add(new Amenities(R.drawable.ic_wifi_black, "Bar/Lounge"));
                    amenities.add(new Amenities(R.drawable.ic_wifi_black, "Unknown"));
                    amenitiesReadMoreExpanded = true;
                }
                adapter.notifyDataSetChanged();

            }
        });

        locationText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentMapIntent(locationText.getText().toString().trim());
            }
        });


        RecyclerView recyclerView = findViewById(R.id.detail_hotel_activity_amenities_recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new GridLayoutManager(DetailHotelActivity.this, 2));

        recyclerView.setAdapter(adapter);

    }

    private void setUpHotelInfo(){
        final TextView hotelInfo = findViewById(R.id.detail_hotel_activity_info_textView);
        final TextView readMoreButton = findViewById(R.id.detail_hotel_activity_readMore_textView);

        readMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(infoReadMoreExpanded){
                    readMoreButton.setText("Read more");
                    hotelInfo.setMaxLines(3);
                    infoReadMoreExpanded = false;
                }else{
                    readMoreButton.setText("Less");
                    hotelInfo.setMaxLines(Integer.MAX_VALUE);
                    infoReadMoreExpanded = true;
                }
            }
        });
    }

    private void setUpToolbar(){
        final Toolbar toolbar = findViewById(R.id.toolbar);

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
