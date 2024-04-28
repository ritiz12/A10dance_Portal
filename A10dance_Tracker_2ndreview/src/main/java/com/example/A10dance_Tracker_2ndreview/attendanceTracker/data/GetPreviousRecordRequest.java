package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;
import java.util.Date;
public class GetPreviousRecordRequest {
    final private Date logInTime ;
    final private Date logOutTime ;

    public GetPreviousRecordRequest(Date logInTime, Date logOutTime) {
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    }

    public Date getLogInTime() {
        return logInTime;
    }

    public Date getLogOutTime() {
        return logOutTime;
    }
}
