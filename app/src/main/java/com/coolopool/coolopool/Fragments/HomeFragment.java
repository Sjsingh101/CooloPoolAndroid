package com.coolopool.coolopool.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.coolopool.coolopool.Activity.HomeActivity;
import com.coolopool.coolopool.Activity.HotelActivity;
import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    int[] images ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3};
    String[] titles ={"Afgfgf","A","A","A","A","A"};
    String[] descriptions ={"A","A","A","A","A","A"};
    RecyclerView.LayoutManager layoutManager;
    PostAdapter postAdapter;
    FloatingActionButton addPost;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addPost = (FloatingActionButton)view.findViewById(R.id.fab);

        // for search box

        ImageButton mSearchButton = (ImageButton)view.findViewById(R.id.searchButton);
        final EditText mSearchBox = (EditText)view.findViewById(R.id.searchbar);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchBox.setVisibility(View.VISIBLE);
            }
        });


        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(MyApplication.getAppContext(),2);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        postAdapter = new PostAdapter(images,titles,descriptions);
        recyclerView.setAdapter(postAdapter);

        return view;
    }




}
