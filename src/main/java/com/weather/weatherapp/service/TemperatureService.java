package com.weather.weatherapp.service;

import com.weather.weatherapp.entity.TemperatureRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weather.weatherapp.repository.TemperatureRecordRepository;

import java.util.Date;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@Service
public class TemperatureService {

	@Autowired
	TemperatureRecordRepository temperatureRecordRepository;

	@Autowired
	NotificationService notificationService;

	/*
	* Generates Random number between two numbers
	* */
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	/*
	* This function will be triggered every min by cron job.
	* */
	public TemperatureRecord recordTemperature() {
		int avgTemp =
				( getTemperatureFromServiceA() + getTemperatureFromServiceB() + getTemperatureFromServiceC() ) / 3;
		TemperatureRecord temperatureRecord = temperatureRecordRepository.findFirstByOrderByTempIdDesc();
		if (temperatureRecord == null || temperatureRecord.getTemperature() != avgTemp){
			//save new temperature record
			TemperatureRecord newTemperatureRecord = temperatureRecordRepository.save(new TemperatureRecord(new Date(),
					avgTemp));
			// Call notify service to send notification to all users
			notificationService.getUserAndNotify();
			return newTemperatureRecord;
		}
		return null;
	}

	/*
	*This function will make API call to weather service A and get the temperature
	* may use restTemplate.exchange() to call other service to get temperature
	* */
	private int getTemperatureFromServiceA(){
		return getRandomNumber(26, 32);
	}

	/*
	 *This function will make API call to weather service A and get the temperature
	 * may use restTemplate.exchange() to call other service to get temperature
	 * */
	private int getTemperatureFromServiceB(){
		return getRandomNumber(26, 32);
	}

	/*
	 *This function will make API call to weather service A and get the temperature
	 * may use restTemplate.exchange() to call other service to get temperature
	 * */
	private int getTemperatureFromServiceC(){
		return getRandomNumber(26, 32);
	}

}
