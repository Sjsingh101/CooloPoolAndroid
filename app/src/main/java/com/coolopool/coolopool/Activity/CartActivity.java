package com.coolopool.coolopool.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.coolopool.coolopool.Adapter.CartListAdapter;
import com.coolopool.coolopool.Class.CartItem;
import com.coolopool.coolopool.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView mCartItem;
    CartListAdapter adapter;
    ArrayList<CartItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        (findViewById(R.id.cart_activity_checkout_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, PaymentActivity.class));
            }
        });

        items = new ArrayList<>();

        CartItem.counter = 1;
        items.add(new CartItem("Hotel", "Delux room", 4500));
        items.add(new CartItem("Cab", "AC Sedan", 6000));
        items.add(new CartItem("Hotel", "Single room", 4500));
        items.add(new CartItem("Hudson cafe", "Chicken", 780));

        mCartItem = (RecyclerView)findViewById(R.id.cart_activity_cart_item_recyclerView);
        mCartItem.setLayoutManager(new LinearLayoutManager(this));
        mCartItem.setHasFixedSize(false);

        adapter = new CartListAdapter(items, this);

        mCartItem.setAdapter(adapter);

        mCartItem.addItemDecoration(new DividerItemDecoration(this, 1));




    }
}
