package com.example.A10dance_Tracker_2ndreview.attendanceTracker.core;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInRequest;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInResponse;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository ;
    public PostLogInResponse saveLogInTime(PostLogInRequest request) {

        Date currentTime = request.getCurrentDateTime();
        Attendance attendance = new Attendance();
        attendance.setLogInTime(currentTime);
        attendance = attendanceRepository.save(attendance);
        final  var response = new PostLogInResponse();
        response.setCurrentDateTime(attendance.getLogInTime());
        response.setStatus(("Login Successfully"));
        return response ;
    }
}
