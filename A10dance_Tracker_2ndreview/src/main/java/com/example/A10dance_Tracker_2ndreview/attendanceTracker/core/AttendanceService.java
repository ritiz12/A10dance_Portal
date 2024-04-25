package com.example.A10dance_Tracker_2ndreview.attendanceTracker.core;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.*;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository ;
    private int currentId = 0 ;
    public PostLogInResponse saveLogInTime(PostLogInRequest request) {

        Date currentLogInTime = request.getCurrentLogInTime();
        Attendance attendance = new Attendance();
        attendance.setLogInTime(currentLogInTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentLogInTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        Date logoutTime = calendar.getTime();
        attendance.setLogOutTime(logoutTime);

        long workingTimeMillis = logoutTime.getTime() - currentLogInTime.getTime();
        double workingTimeHours = (double) workingTimeMillis / (1000 * 60 * 60);
        BigDecimal roundedWorkingTime = new BigDecimal(String.format("%.2f",workingTimeHours));
        attendance.setWorkingTime(roundedWorkingTime);
        attendance = attendanceRepository.save(attendance);
        currentId = attendance.getId();
        final var response = new PostLogInResponse();
        response.setCurrentLogInTime(attendance.getLogInTime());
        response.setCurrentLogOutTime(attendance.getLogOutTime());
        response.setWorkingTime(roundedWorkingTime);
        response.setStatus("Login Successfully");
        return response;
    }


    public PostLogOutResponse saveLogOutTime(PostLogOutRequest request) {

        Date currentLogOutTime = request.getCurrentLogOutTime();
        Attendance attendance = new Attendance();
        attendance = attendanceRepository.findById(currentId);
        attendance.setLogOutTime(currentLogOutTime);
       Date currentLogInTime =  attendance.getLogInTime() ;
        long workingTimeMillis = currentLogOutTime.getTime() - currentLogInTime.getTime();
        double workingTimeHours = (double) workingTimeMillis / (1000 * 60 * 60);
        BigDecimal roundedWorkingTime = new BigDecimal(String.format("%.2f",workingTimeHours));
        attendance.setWorkingTime(roundedWorkingTime);
        attendance = attendanceRepository.save(attendance);
        final var response = new PostLogOutResponse();
        response.setCurrentLogOutTime(attendance.getLogOutTime());
        response.setWorkingTime(roundedWorkingTime);
        response.setStatus("Logout Successfully");
        return response;


    }

    public GetPreviousRecordResponse getPreviousRecord(GetPreviousRecordRequest request) {
        final var response = new GetPreviousRecordResponse();
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date fiveDaysAgo = calendar.getTime();
        List<Attendance> previousAttendanceRecord = attendanceRepository.findByLogInTimeAfter(fiveDaysAgo);
        for(Attendance record : previousAttendanceRecord)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String loginDate = dateFormat.format(record.getLogInTime());
            String loginTime = timeFormat.format(record.getLogInTime());
            String logoutTime = timeFormat.format(record.getLogOutTime());
            response.addAttendanceRecord(new GetPreviousRecordSummary(loginDate, loginTime, logoutTime ));


        }
        return response ;

    }

    public GetMonthlyRecordResponse getMonthlyRecord(GetMonthlyRecordRequest request) {
        Map<Integer, Long> monthlyWiseRecord = new HashMap<>();
        List<MonthlyWorkingTime> monthlyWiseRecordList = attendanceRepository.fetchMonthlyData();
        for (MonthlyWorkingTime record : monthlyWiseRecordList) {
            System.out.println("Month: " + record.getMonth() + ", Total Working Minutes: " + record.getTotalworkingTime());
        }
        for (var record : monthlyWiseRecordList) {
           //  monthlyWiseRecord.put(record.getMonth(), record.getMonth());
        }

        GetMonthlyRecordResponse response = new GetMonthlyRecordResponse();
        for (Map.Entry<Integer, Long> entry : monthlyWiseRecord.entrySet()) {
            response.addMonthlyWorkingHour(new GetMonthlyRecordSummary(null, entry.getKey(), entry.getValue()));
        }
        return response;
    }

}


