package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.math.BigDecimal;
import java.util.Date;

public class PostLogInResponse {
    private Date currentLogInTime;

    private Date currentLogOutTime ;
    private String status ;

    private BigDecimal workingTime ;

  //  private String
    public PostLogInResponse()
    {

    }

    public PostLogInResponse(Date currentLogInTime,Date currentLogOutTime ,  String status , BigDecimal workingTime) {
        this.currentLogInTime = currentLogInTime;
        this.currentLogOutTime = currentLogOutTime ;
        this.status = status ;
        this.workingTime = workingTime ;
    }

    public Date getCurrentLogInTime() {
        return currentLogInTime;
    }

    public void setCurrentLogInTime(Date currentLogInTime) {
        this.currentLogInTime = currentLogInTime;
    }

    public Date getCurrentLogOutTime() {
        return currentLogOutTime;
    }

    public void setCurrentLogOutTime(Date currentLogOutTime) {
        this.currentLogOutTime = currentLogOutTime;
    }

    public void setStatus(String status){this.status = status;}

    public String getStatus() {
        return status;
    }

    public BigDecimal getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(BigDecimal workingTime) {
        this.workingTime = workingTime;
    }
}
