package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;
import java.util.Date;
public class PostLogInRequest {
    private Date currentDateTime ;

    public PostLogInRequest() {
        // Default constructor
    }
    public PostLogInRequest(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}
