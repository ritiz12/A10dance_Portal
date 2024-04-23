package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.Date;

public class PostLogInSummary {
    final private Date currentDateTime ;

    public PostLogInSummary(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public Date getCurrentDateTime() {

        return currentDateTime;
    }

}
