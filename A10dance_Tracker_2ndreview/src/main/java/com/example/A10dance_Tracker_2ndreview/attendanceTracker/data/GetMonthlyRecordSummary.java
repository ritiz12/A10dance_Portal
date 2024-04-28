package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.math.BigDecimal;

public class GetMonthlyRecordSummary {

  final   private String month;
   final  private BigDecimal totalMonthlyWorkingTime;

    public GetMonthlyRecordSummary(String month, BigDecimal totalMonthlyWorkingTime) {
        this.month = month;
        this.totalMonthlyWorkingTime = totalMonthlyWorkingTime;
    }

    public String getMonth() {
        return month;
    }

    public BigDecimal getTotalMonthlyWorkingTime() {
        return totalMonthlyWorkingTime;
    }
}
