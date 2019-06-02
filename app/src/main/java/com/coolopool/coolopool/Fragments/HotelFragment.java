package com.coolopool.coolopool.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_hotel, container, false);

        TextView location = (TextView)v.findViewById(R.id.hotel_fragment_location);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuilder dB = new DialogBuilder(getActivity(), R.layout.city_area_hote_chooser);
                dB.build();


            }
        });


        return v;
    }

}
