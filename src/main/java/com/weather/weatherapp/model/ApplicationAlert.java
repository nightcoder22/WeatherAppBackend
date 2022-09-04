package com.weather.weatherapp.model;

import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.interfaces.Notifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

public class ApplicationAlert implements Notifiable {

	Logger logger = LoggerFactory.getLogger(ApplicationAlert.class);
	@Override
	public void notify(User user, TemperatureRecord temperatureRecord) {
		Long userId = user.getUserId();
		String userName = user.getUserName();
		int temperature = temperatureRecord.getTemperature();

		logger.info("Application Alert = UserName: "+userName + "; Temperature: " + temperature);

		// send application notification to user with the help of above data
	}

}
