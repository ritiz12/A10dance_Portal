package com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "logInTime", nullable = false, updatable = false)
    private Date logInTime;

    @Column(name = "logOutTime", nullable = true, updatable = true)
    private Date logOutTime;

    @Column(name = "workingTime" , nullable = false , updatable = true)
    private BigDecimal workingTime ;

    public Attendance() {
        // Default constructor
    }

    public Attendance(Date logInTime, Integer id, Date logOutTime , BigDecimal workingTime) {
        this.logInTime = logInTime;
        this.id = id;
        this.logOutTime = logOutTime;
        this.workingTime = workingTime;
    }

    public Integer getId() {
        return id;
    }

    public Date getLogInTime() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(BigDecimal workingTime) {
        this.workingTime = workingTime;
    }

    @PrePersist
    void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
