package com.coolopool.coolopool.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coolopool.coolopool.Class.CartItem;
import com.coolopool.coolopool.R;
import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartItemViewHolder> {

    ArrayList<CartItem> cartItems;
    Context context;

    public CartListAdapter(ArrayList<CartItem> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_list_item, viewGroup, false);
        return new CartItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder cartItemViewHolder, int i) {
        CartItem current = cartItems.get(i);

        cartItemViewHolder.details.setText(current.getDetails());
        cartItemViewHolder.counter.setText(current.getCurrent_count());
        cartItemViewHolder.cost.setText("₹ "+current.getCost());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder{

        TextView counter;
        TextView details;
        TextView cost;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            counter = (TextView)itemView.findViewById(R.id.cart_list_item_counter_textView);
            details = (TextView)itemView.findViewById(R.id.cart_list_item_details_textView);
            cost = (TextView)itemView.findViewById(R.id.cart_list_item_cost_textView);
        }
    }
}
