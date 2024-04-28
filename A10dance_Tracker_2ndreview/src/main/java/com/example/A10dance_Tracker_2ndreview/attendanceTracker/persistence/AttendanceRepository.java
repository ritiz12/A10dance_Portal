package com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.MonthlyWorkingTime;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , String> {

    Attendance findByLogInTime(Date currentLogInTime);

    Attendance findById(int currentId);

    List<Attendance> findByLogInTimeAfter(Date fiveDaysAgo);

   /* @Query(value =
            "SELECT new com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.MonthlyWorkingTime(extract(month from a.logInTime), SUM(a.workingTime)), extract(year from a.logInTime" +
                    "FROM Attendance a WHERE a.logInTime >= :startDate AND a.logInTime <= :endDate " +
                    "GROUP BY extract(month from a.logInTime) ")

    */
@Query(value = "SELECT new com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.MonthlyWorkingTime(extract(month from a.logInTime), SUM(a.workingTime)) FROM Attendance a WHERE a.logInTime >= :startDate AND a.logInTime <= :endDate GROUP BY extract(month from a.logInTime)")

    List<MonthlyWorkingTime> fetchMonthlyData(Date startDate , Date endDate);










}

