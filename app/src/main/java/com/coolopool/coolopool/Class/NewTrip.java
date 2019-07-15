package com.coolopool.coolopool.Class;

import java.util.List;
import java.util.Map;

public class NewTrip {

    private String tripTitle;

    private String tripDescription;

    private String tripDate;

    private List<Map<String, List<String>>> days;

    public NewTrip(String tripTitle, String tripDescription, String tripDate, List<Map<String, List<String>>> days) {
        this.tripTitle = tripTitle;
        this.tripDescription = tripDescription;
        this.tripDate = tripDate;
        this.days = days;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public String getTripDate() {
        return tripDate;
    }

    public List<Map<String, List<String>>> getDays() {
        return days;
    }
}
