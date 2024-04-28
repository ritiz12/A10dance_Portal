package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class GetMonthlyRecordResponse {

    private Collection<GetMonthlyRecordSummary> monthlyRecord;

    public void addMonthlyWorkingHour(final GetMonthlyRecordSummary data) {
        if (monthlyRecord == null) {
            monthlyRecord = new ArrayList<>();
        }
        monthlyRecord.add(data);
    }


    public Collection<GetMonthlyRecordSummary> getMonthlyRecord() {
        return monthlyRecord;
    }
}
