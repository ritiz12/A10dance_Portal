package com.example.A10dance_Tracker_2ndreview;

import com.example.A10dance_Tracker_2ndreview.attendanceTracker.core.AttendanceService;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInRequest;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogInResponse;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogOutRequest;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.data.PostLogOutResponse;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.domain.Attendance;
import com.example.A10dance_Tracker_2ndreview.attendanceTracker.persistence.AttendanceRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class A10danceTracker2ndreviewApplicationTests {

	//@InjectMocks
	@Autowired
	private AttendanceService attendanceService;


	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testSaveLogInTimeForSuccessfulLogin() {
		Date currentLogInTime = new Date();
		PostLogInRequest request = new PostLogInRequest(currentLogInTime);
		PostLogInResponse response = attendanceService.saveLogInTime(request);
		assertEquals("Login Successfully", response.getStatus());
	}

	@Test
	public void testSaveLogOutTimeForSuccessfullLogOut()
	{
		Date currentLogOutTime = new Date();
		Date currentLogInTime = new Date();
		PostLogInRequest logInRequest = new PostLogInRequest(currentLogInTime);
		PostLogInResponse logInResponse = attendanceService.saveLogInTime(logInRequest);
		PostLogOutRequest logOutRequest = new
				PostLogOutRequest(currentLogOutTime);
		PostLogOutResponse logOutResponse = attendanceService.saveLogOutTime(logOutRequest);
		assertEquals("Logout Successfully" , logOutResponse.getStatus());
	}

	@Test
	public void testForCorrectWorkingTime()
	{
		LocalDateTime loginDateTime = LocalDateTime.of(2024, 4, 26, 10, 1, 0);
		LocalDateTime logoutDateTime = LocalDateTime.of(2024, 4, 26, 18, 0, 0);
		Date currentLogInTime = Date.from(loginDateTime.atZone(ZoneId.systemDefault()).toInstant());
		Date currentLogOutTime = Date.from(logoutDateTime.atZone(ZoneId.systemDefault()).toInstant());
		PostLogInRequest logInRequest = new PostLogInRequest(currentLogInTime);
		PostLogOutRequest logOutRequest = new PostLogOutRequest(currentLogOutTime);
		PostLogInResponse logInResponse = attendanceService.saveLogInTime(logInRequest);
		PostLogOutResponse logOutResponse = attendanceService.saveLogOutTime(logOutRequest);
		String expectedWorkingTime = logOutResponse.getWorkingTime().toString();
		assertEquals("7.98", expectedWorkingTime);

	}







}
