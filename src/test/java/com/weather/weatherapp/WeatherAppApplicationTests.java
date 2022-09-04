package com.weather.weatherapp;

import com.weather.weatherapp.entity.NotificationMode;
import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.entity.UserConfiguration;
import com.weather.weatherapp.repository.TemperatureRecordRepository;
import com.weather.weatherapp.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WeatherAppApplicationTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private TemperatureRecordRepository temperatureRecordRepository;

	/*
	 * Testing user repository
	 * */
	@Test
	public void findUserByIdTest() {
		User user = new User(1L, "akshayh", "8087507421", "hiwaleakshay@gmail.com",
				new UserConfiguration(1L, 29, new NotificationMode(1L, true, false, true)));
		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		User user1 = userRepository.findById(1L).get();
		assertEquals(1L, user1.getUserId());
	}

	/*
	 * Testing temperature record repository
	 * */
	@Test
	public void getLatestTemperatureTest() {
		TemperatureRecord temperatureRecord = new TemperatureRecord(new Date(), 28);
		when(temperatureRecordRepository.findFirstByOrderByTempIdDesc()).thenReturn(temperatureRecord);
		TemperatureRecord temperatureRecord1 = temperatureRecordRepository.findFirstByOrderByTempIdDesc();
		assertEquals(28, temperatureRecord1.getTemperature());
	}

}
