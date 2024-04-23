package com.example.A10dance_Tracker_2ndreview.attendanceTracker.api;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.core.AttendanceService;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInRequest;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/attendance")
@RestController
public class AttendanceAPI {

    @Autowired
    private AttendanceService attendanceService ;



    @PostMapping("/login")
    public ResponseEntity<PostLogInResponse> saveLogInTime(@RequestBody PostLogInRequest request)
    {
        final var response = attendanceService.saveLogInTime(request);
        return ResponseEntity.ok(response);
    }
}
