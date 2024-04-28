package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GetPreviousRecordResponse {

    private Collection<GetPreviousRecordSummary> attendanceRecord;
    public void addAttendanceRecord(final GetPreviousRecordSummary record)
    {
        if(attendanceRecord == null)
        {
            attendanceRecord = new ArrayList<>();
        }
        attendanceRecord.add(record);


    }

    public Collection<GetPreviousRecordSummary> getAttendanceRecords() {
        return Collections.unmodifiableCollection(attendanceRecord);
    }
}
