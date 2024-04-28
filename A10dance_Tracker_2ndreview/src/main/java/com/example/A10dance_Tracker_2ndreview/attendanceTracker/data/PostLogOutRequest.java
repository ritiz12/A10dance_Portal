package com.example.A10dance_Tracker_2ndreview.attendanceTracker.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostLogOutRequest {
    private final Date currentLogOutTime;

    @JsonCreator
    public PostLogOutRequest(@JsonProperty("currentLogOutTime") Date currentLogOutTime) {
        this.currentLogOutTime = currentLogOutTime;
    }

    public Date getCurrentLogOutTime() {
        return currentLogOutTime;
    }
}
