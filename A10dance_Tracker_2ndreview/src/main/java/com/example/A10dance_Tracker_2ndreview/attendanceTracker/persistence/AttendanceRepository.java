package com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.GetMonthlyRecordRequest;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.GetMonthlyRecordSummary;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.MonthlyWorkingTime;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , String> {

    Attendance findByLogInTime(Date currentLogOutTime);

    Attendance findById(int currentId);

    List<Attendance> findByLogInTimeAfter(Date fiveDaysAgo);




    /*@Query(nativeQuery = true, value =
            "SELECT "+" new  com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.GetMonthlyRecordRequest(extract(logInTime from e.date ) , extract(logOutTime from e.date), "

     */
    @Query( value =
            "SELECT new com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.MonthlyWorkingTime(extract(month from a.logInTime), SUM(a.workingTime)) " +
                    "FROM Attendance a " +
                    "GROUP BY extract(month from a.logInTime)")
    List<MonthlyWorkingTime> fetchMonthlyData();







}

