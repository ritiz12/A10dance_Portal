package com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain;
import java.time.Instant;
import java.util.TimeZone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "attendance")
public class Attendance extends Model {



    @Column(name = "logInTime", nullable = false, updatable = false)
    private Date logInTime;

    @Column(name = "logOutTime", nullable = true, updatable = true)
    private Date logOutTime;

    Instant date=Instant.now();
    public Attendance() {
        super();
    }


    public Attendance(Date logInTime, Date logOutTime) {
       TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date date=new Date();
        date=logInTime;
        this.logInTime = date;

        this.logOutTime = logOutTime;
    }


    public Date getLogInTime() {
        System.out.println(this.logInTime.getTimezoneOffset());
        return logInTime;
    }

    public void setLogInTime(Date logInTime) {
        this.logInTime = logInTime;
    }

    public Date getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(Date logOutTime) {
        this.logOutTime = logOutTime;
    }
}
