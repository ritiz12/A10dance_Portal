package com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance , String> {

}
