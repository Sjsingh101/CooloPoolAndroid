package com.coolopool.coolopool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.coolopool.coolopool.Class.Review;
import com.coolopool.coolopool.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    ArrayList<Review> reviews;
    Context mContext;

    public ReviewAdapter(ArrayList<Review> reviews, Context mContext) {
        this.reviews = reviews;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hotel_review_list_item, viewGroup, false);
        return new ReviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder reviewViewHolder, int i) {
        Review currentReview = reviews.get(i);

        reviewViewHolder.mProfileImage.setImageResource(currentReview.getmIcon());
        reviewViewHolder.mAddress.setText(currentReview.getmUserAddress());
        reviewViewHolder.mTitle.setText(currentReview.getmTitle());
        reviewViewHolder.mDescription.setText(currentReview.getmDescription());
        reviewViewHolder.mDate.setText(currentReview.getmDate());
        reviewViewHolder.mRating.setRating(currentReview.getmRating());

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        ImageView mProfileImage;
        TextView mAddress;
        TextView mTitle;
        TextView mDescription;
        TextView mDate;
        RatingBar mRating;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            mProfileImage = (ImageView)itemView.findViewById(R.id.hotel_review_list_item_profileImage);
            mAddress = (TextView)itemView.findViewById(R.id.hotel_review_list_item_profile_address_textView);
            mTitle = (TextView)itemView.findViewById(R.id.hotel_review_list_item_review_title_textView);
            mDescription = (TextView)itemView.findViewById(R.id.hotel_review_list_item_review_description_textView);
            mDate = (TextView)itemView.findViewById(R.id.hotel_review_list_item_review_date_textView);
            mRating = (RatingBar)itemView.findViewById(R.id.hotel_review_list_item_ratingBar);
        }
    }
}
