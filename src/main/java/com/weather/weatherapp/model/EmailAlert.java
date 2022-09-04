package com.weather.weatherapp.model;

import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.interfaces.Notifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project:- eQube-TM
 * Created by @author Akshay
 * on 03-09-2022
 */

public class EmailAlert implements Notifiable {

	Logger logger = LoggerFactory.getLogger(EmailAlert.class);
	@Override
	public void notify(User user, TemperatureRecord temperatureRecord) {
		Long userId = user.getUserId();
		String userName = user.getUserName();
		String email = user.getEmail();
		int temperature = temperatureRecord.getTemperature();

		logger.info("EmailAlert = UserName: "+userName + "; Email: "+email + "; Temperature: " + temperature);

		// call email server to send email with the help of above data
	}

}
