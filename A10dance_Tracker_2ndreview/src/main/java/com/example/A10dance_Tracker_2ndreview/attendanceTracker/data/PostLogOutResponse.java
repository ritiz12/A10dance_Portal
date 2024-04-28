package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;
import java.math.BigDecimal;
import java.util.Date;
public class PostLogOutResponse {
    private  Date currentLogOutTime ;

    private String status ;

    private BigDecimal workingTime ;

    public PostLogOutResponse()
    {

    }
    public PostLogOutResponse(Date currentLogOutTime, String status , BigDecimal workingTime) {
        this.currentLogOutTime = currentLogOutTime;
        this.status = status;
        this.workingTime = workingTime ;
    }

    public Date getCurrentLogOutTime() {
        return currentLogOutTime;
    }

    public void setCurrentLogOutTime(Date currentLogOutTime) {
        this.currentLogOutTime = currentLogOutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  BigDecimal getWorkingTime()
    {
        return workingTime ;
    }

    public  void setWorkingTime(BigDecimal workingTime)
    {
        this.workingTime = workingTime ;
    }
}
