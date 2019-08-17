package com.coolopool.coolopool.Fragments;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coolopool.coolopool.Activity.HotelActivity;
import com.coolopool.coolopool.Application.MyApplication;
import com.coolopool.coolopool.Helper.DialogBuilder;
import com.coolopool.coolopool.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {

    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private View v;


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_hotel, container, false);

        (v.findViewById(R.id.hotel_fragment_search_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpTransition();
            }
        });



        TextView location = v.findViewById(R.id.hotel_fragment_location);

        RelativeLayout checkInHolder = v.findViewById(R.id.checkIn_holder);
        RelativeLayout checkOutHolder = v.findViewById(R.id.checkOut_holder);
        RelativeLayout guestsHolder = v.findViewById(R.id.guests_holder);
        RelativeLayout roomsHolder = v.findViewById(R.id.rooms_holder);

        checkInHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogBuilder dB = new DialogBuilder(getActivity(), R.layout.dialog_date_chooser);
                dB.build();
                (dB.getDialog().findViewById(R.id.dialog_back_button)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkInBack(v, dB);
                    }
                });
            }
        });

        checkOutHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogBuilder dB = new DialogBuilder(getActivity(), R.layout.dialog_date_chooser);
                dB.build();
                ((ImageButton)dB.getDialog().findViewById(R.id.dialog_back_button)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkOutBack(v, dB);
                    }
                });
            }
        });


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return v;
    }

    public View getView(){
        return v;
    }

    private void setUpTransition(){
        Intent intent = new Intent(getActivity(), HotelActivity.class);

        intent.putExtra("LOCATION", ((EditText)v.findViewById(R.id.hotel_fragment_location)).getText().toString().trim());

        intent.putExtra("CHECKIN", ((TextView)v.findViewById(R.id.checkIn_value_textView)).getText().toString());
        intent.putExtra("CHECKIN_DAYOFWEEK", ((TextView)v.findViewById(R.id.checkIn_value_day_of_week_textView)).getText().toString());
        intent.putExtra("CHECKIN_MONTH_YEAR", ((TextView)v.findViewById(R.id.checkIn_value_year_month_textView)).getText().toString().substring(0,3));


        intent.putExtra("CHECKOUT", ((TextView)v.findViewById(R.id.checkOut_value_textView)).getText().toString());
        intent.putExtra("CHECKOUT_DAYOFWEEK", ((TextView)v.findViewById(R.id.checkOut_value_day_of_week_textView)).getText().toString());
        intent.putExtra("CHECKOUT_MONTH_YEAR", ((TextView)v.findViewById(R.id.checkOut_value_year_month_textView)).getText().toString().substring(0,3));

        intent.putExtra("GUESTS", ((EditText)v.findViewById(R.id.guests_value_textView)).getText().toString().trim());

        intent.putExtra("ROOMS", ((EditText)v.findViewById(R.id.rooms_value_textView)).getText().toString().trim());


        Pair<View, String> pair_location = Pair.create(v.findViewById(R.id.hotel_fragment_location), "LOCATION");

        Pair<View, String> pair_guests = Pair.create(v.findViewById(R.id.guests_value_textView), "GUESTS");

        Pair<View, String> pair_rooms = Pair.create(v.findViewById(R.id.rooms_value_textView), "ROOMS");

        Pair<View, String> pair_checkIn_day = Pair.create(v.findViewById(R.id.checkIn_value_year_month_textView), "CHECKIN_DAY_YEAR");

        Pair<View, String> pair_checkOut_day = Pair.create(v.findViewById(R.id.checkOut_value_year_month_textView), "CHECKOUT_DAY_YEAR");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pair_location, pair_guests, pair_rooms, pair_checkIn_day, pair_checkOut_day);

        startActivity(intent, activityOptions.toBundle());
    }

    private void checkInBack(View v, DialogBuilder dB){
        DatePicker datePicker = (DatePicker)dB.getDialog().findViewById(R.id.datePicker);

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String dayOfWeek = getDayOfWeek(day, month, year);

        if(day < 10){
            ((TextView)v.findViewById(R.id.checkIn_value_textView)).setText("0"+day);
        }else{
            ((TextView)v.findViewById(R.id.checkIn_value_textView)).setText(""+day);
        }

        ((TextView)v.findViewById(R.id.checkIn_value_day_of_week_textView)).setText(dayOfWeek);
        ((TextView)v.findViewById(R.id.checkIn_value_year_month_textView)).setText(MyApplication.MONTHS[month]+" "+year);

        dB.destroy();

    }

    private void checkOutBack(View v, DialogBuilder dB){
        DatePicker datePicker = (DatePicker)dB.getDialog().findViewById(R.id.datePicker);

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String dayOfWeek = getDayOfWeek(day, month, year);

        if(day < 10){
            ((TextView)v.findViewById(R.id.checkOut_value_textView)).setText("0"+day);
        }else{
            ((TextView)v.findViewById(R.id.checkOut_value_textView)).setText(""+day);
        }

        ((TextView)v.findViewById(R.id.checkOut_value_day_of_week_textView)).setText(dayOfWeek);
        ((TextView)v.findViewById(R.id.checkOut_value_year_month_textView)).setText(MONTHS[month]+" "+year);

        dB.destroy();
    }

    /*private void guestsBack(View v, DialogBuilder dB){
        NumberPicker numberPicker = (NumberPicker)dB.getDialog().findViewById(R.id.numberPicker);
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);


        int number = numberPicker.getValue();

        if(number < 10){
            ((TextView)v.findViewById(R.id.guests_value_textView)).setText("0"+number);
        }else{
            ((TextView)v.findViewById(R.id.guests_value_textView)).setText(""+number);
        }
        dB.destroy();

    }

    private void roomsBack(View v, DialogBuilder dB){
        NumberPicker numberPicker = dB.getDialog().findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

         int number = numberPicker.getValue();

        if(number < 10){
            ((TextView)v.findViewById(R.id.rooms_value_textView)).setText("0"+number);
        }else{

            ((TextView)v.findViewById(R.id.rooms_value_textView)).setText(""+number);
        }

        dB.destroy();

    }*/

    private String getDayOfWeek(int day, int month, int year){
        String date = ""+day+"/"+(month+1)+"/"+year;

        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");

        Date date1 = null;

        try {
            date1 = format1.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dayOfWeek = (String) DateFormat.format("EEEE", date1);

        return dayOfWeek;
    }
}
