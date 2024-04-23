package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.Date;

public class PostLogInResponse {
    private Date currentDateTime ;
    private String status ;
    public PostLogInResponse()
    {

    }

    public PostLogInResponse(Date currentDateTime , String status) {
        this.currentDateTime = currentDateTime;
        this.status = status ;
    }

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public void setStatus(String status){this.status = status;}

    public String getStatus() {
        return status;
    }
}
