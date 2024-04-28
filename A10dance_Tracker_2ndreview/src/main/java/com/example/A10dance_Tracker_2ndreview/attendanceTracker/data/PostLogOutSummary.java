package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.Date;

public class PostLogOutSummary {

     private Date currentLogOutTime ;

    public PostLogOutSummary(Date currentLogOutTime) {
        this.currentLogOutTime = currentLogOutTime;
    }

    public Date getCurrentLogOutTime() {
        return currentLogOutTime;
    }

}
