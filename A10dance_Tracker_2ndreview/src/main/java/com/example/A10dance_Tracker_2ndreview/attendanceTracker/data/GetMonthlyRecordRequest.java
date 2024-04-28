package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.math.BigDecimal;
import java.util.Date;

public class GetMonthlyRecordRequest {

    final private Date logInTime ;
    final private Date logOutTime ;

    final private BigDecimal workingTime ;

    public GetMonthlyRecordRequest(Date logInTime, Date logOutTime, BigDecimal workingTime) {
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.workingTime = workingTime;
    }

    public Date getLogInTime() {
        return logInTime;
    }

    public Date getLogOutTime() {
        return logOutTime;
    }

    public BigDecimal getWorkingTime() {
        return workingTime;
    }
}
