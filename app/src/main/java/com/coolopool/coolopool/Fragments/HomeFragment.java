package com.coolopool.coolopool.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coolopool.coolopool.Activity.HomeActivity;
import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Class.HomePageBlog;
import com.coolopool.coolopool.Interface.TripClient;
import com.coolopool.coolopool.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    String[] images;
    String[] titles;
    String[] descriptions;
    int[] heartCounts;
    RecyclerView.LayoutManager layoutManager;
    PostAdapter postAdapter;
    FloatingActionButton addPost;
    View view;

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

        view = inflater.inflate(R.layout.fragment_home, container, false);

        addPost = view.findViewById(R.id.fab);

        getBlogs();

        return view;
    }

    private void getBlogs() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/samyak-uttam/demo/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TripClient client = retrofit.create(TripClient.class);

        Call<List<HomePageBlog>> call = client.getBlogs();

        call.enqueue(new Callback<List<HomePageBlog>>() {
            @Override
            public void onResponse(Call<List<HomePageBlog>> call, Response<List<HomePageBlog>> response) {

                List<HomePageBlog> blogs = response.body();

                int size = blogs.size();
                titles = new String[size];
                descriptions = new String[size];
                heartCounts = new int[size];
                images = new String[size];

                for(int i = 0; i < blogs.size(); i++){
                    titles[i] = blogs.get(i).getTitle();
                    descriptions[i] = blogs.get(i).getDescription();
                    heartCounts[i] = blogs.get(i).getHeartCount();
                    images[i] = blogs.get(i).getImageUrl();
                }

                recyclerView = view.findViewById(R.id.recycler_view);
                layoutManager = new GridLayoutManager(MyApplication.getAppContext(),2);
                recyclerView.setHasFixedSize(false);
                recyclerView.setLayoutManager(layoutManager);

                postAdapter = new PostAdapter(images,titles,descriptions, getActivity());
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<HomePageBlog>> call, Throwable t) {
                Toast.makeText(getActivity(), "Can't fetch data.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
