package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.math.BigDecimal;

public class MonthlyWorkingTime {
    final private int Month ;
    final private BigDecimal totalworkingTime ;



    public MonthlyWorkingTime(int  month, BigDecimal totalworkingTime  ) {
        Month = month;
        this.totalworkingTime = totalworkingTime;

    }

    public int getMonth() {
        return Month;
    }

    public BigDecimal getTotalworkingTime() {
        return totalworkingTime;
    }


}
