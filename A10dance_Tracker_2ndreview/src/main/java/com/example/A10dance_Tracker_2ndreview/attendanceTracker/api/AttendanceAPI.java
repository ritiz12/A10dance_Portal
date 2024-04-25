package com.example.A10dance_Tracker_2ndreview.attendanceTracker.api;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.core.AttendanceService;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.*;
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

    @PostMapping("/logout")
    public  ResponseEntity<PostLogOutResponse> saveLogOutTime(@RequestBody PostLogOutRequest request)
    {
        final var response = attendanceService.saveLogOutTime(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/previousRecord")
    public ResponseEntity<GetPreviousRecordResponse> getPreviousRecord(GetPreviousRecordRequest request)
    {
        final var response = attendanceService.getPreviousRecord(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/monthlyRecord")
    public ResponseEntity<GetMonthlyRecordResponse> getMonthlyRecord(GetMonthlyRecordRequest request)
    {
        final var response = attendanceService.getMonthlyRecord(request);
        return ResponseEntity.ok(response);
    }

}
