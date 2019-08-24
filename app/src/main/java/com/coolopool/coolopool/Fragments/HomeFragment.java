package com.coolopool.coolopool.Fragments;


import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coolopool.coolopool.Adapter.PostAdapter;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Class.HomePageBlog;
import com.coolopool.coolopool.Interface.TripClient;
import com.coolopool.coolopool.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

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

    private void init(){
        CardStackView cardStackView = view.findViewById(R.id.card_stack_view);
        CardStackListener listener = new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {

            }

            @Override
            public void onCardSwiped(Direction direction) {

            }

            @Override
            public void onCardRewound() {

            }

            @Override
            public void onCardCanceled() {

            }

            @Override
            public void onCardAppeared(View view, int position) {

            }

            @Override
            public void onCardDisappeared(View view, int position) {

            }
        };
        CardStackLayoutManager manager = new CardStackLayoutManager(getActivity(), listener);
        cardStackView.setLayoutManager(manager);
        manager.setStackFrom(StackFrom.Right);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(30f);
        cardStackView.setAdapter(postAdapter);

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

                postAdapter = new PostAdapter(images,titles,descriptions, getActivity());
                init();

            }

            @Override
            public void onFailure(Call<List<HomePageBlog>> call, Throwable t) {
                Toast.makeText(getActivity(), "Can't fetch data.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
