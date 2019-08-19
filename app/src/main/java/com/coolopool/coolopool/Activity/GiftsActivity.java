package com.coolopool.coolopool.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.coolopool.coolopool.Adapter.OffersAdapter;
import com.coolopool.coolopool.Class.Offer;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class GiftsActivity extends AppCompatActivity {

    ArrayList<Offer> mOffers;
    OffersAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cashback_and_coupons_layout);

        init();
        setUpBackButton();
        setUpOffers();
    }

    private void init(){
        mRecyclerView = (RecyclerView)findViewById(R.id.offers_recyclerView);
    }

    private void setUpBackButton(){
        (findViewById(R.id.backButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

    private void setUpOffers(){
        mOffers = new ArrayList<>();
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 16));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 04));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 13));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 03));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 23));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 56));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 01));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 45));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 01));
        mOffers.add(new Offer(R.drawable.cash_back, "Cashback won", "Flat 20% off*", 06));

        mAdapter = new OffersAdapter(mOffers, GiftsActivity.this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(GiftsActivity.this, 2));
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.setAdapter(mAdapter);

    }
}
