package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

public class GetPreviousRecordSummary {
    private final String loginDate;
    private final String loginTime;

    private final String logOutTime;

    private final String workingTime ;




    public GetPreviousRecordSummary(String loginDate, String loginTime, String  logOutTime , String workingTime) {
        this.loginDate = loginDate;
        this.loginTime = loginTime;
        this.logOutTime = logOutTime ;
        this.workingTime = workingTime;


    }

    public String getLoginDate() {
        return loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }


    public String getLogOutTime() {
        return logOutTime;
    }

    public String getWorkingTime() {
        return workingTime;
    }
}
