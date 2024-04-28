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
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository ;
    private int currentId = 0 ;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    public PostLogInResponse saveLogInTime(PostLogInRequest request) {

        Date currentLogInTime = request.getCurrentLogInTime();
        Attendance attendance = new Attendance();
       Attendance existingRecord = attendanceRepository.findByLogInTime(request.getCurrentLogInTime());

        if(existingRecord != null && existingRecord.getLogInTime() != null) {
            throw new IllegalStateException("User is Already LogIn For Today");

        }

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

        if(attendance == null)
        {
            throw new IllegalStateException("User is Not LogIn ");
        }

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
        Collections.reverse(previousAttendanceRecord);

        for(Attendance record : previousAttendanceRecord)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH);
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
            String loginDate = dateFormat.format(record.getLogInTime());
            String loginTime = timeFormat.format(record.getLogInTime());
            String logoutTime = timeFormat.format(record.getLogOutTime());
            String workingTime = String.valueOf(record.getWorkingTime());
            response.addAttendanceRecord(new GetPreviousRecordSummary(loginDate, loginTime, logoutTime,workingTime ));


        }
        return response ;

    }

    public GetMonthlyRecordResponse getMonthlyRecord(GetMonthlyRecordRequest request) {
        Map<String, BigDecimal> monthlyWiseRecord = new HashMap<>();

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, -2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        System.out.println(startDate);
        Date endDate = currentDate;
        List<MonthlyWorkingTime> monthlyWiseRecordList = attendanceRepository.fetchMonthlyData(startDate , endDate);
        for (var record : monthlyWiseRecordList) {
            String monthName = Month.of(record.getMonth()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

          //  String formattedMonthYear = monthName + " "
            monthlyWiseRecord.put(monthName, record.getTotalworkingTime());

        }

        GetMonthlyRecordResponse response = new GetMonthlyRecordResponse();
        for (Map.Entry<String , BigDecimal> entry : monthlyWiseRecord.entrySet()) {
            response.addMonthlyWorkingHour(new GetMonthlyRecordSummary( entry.getKey(), entry.getValue()));
        }
        return response;
    }

}


