package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;
import java.util.Date;
public class PostLogInRequest {
    private Date currentLogInTime;

    public PostLogInRequest() {
        // Default constructor
    }
    public PostLogInRequest(Date currentLogInTime) {
        this.currentLogInTime = currentLogInTime;
    }

    public Date getCurrentLogInTime() {
        return currentLogInTime;
    }

    public void setCurrentLogInTime(Date currentLogInTime) {
        this.currentLogInTime = currentLogInTime;
    }
}
