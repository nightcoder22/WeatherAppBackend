package com.weather.weatherapp.model;

import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.interfaces.Notifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 02-09-2022
 */

public class SmsAlert implements Notifiable {

	Logger logger = LoggerFactory.getLogger(SmsAlert.class);
	@Override
	public void notify(User user, TemperatureRecord temperatureRecord) {
		Long userId = user.getUserId();
		String userName = user.getUserName();
		String mobile = user.getMobile();
		int temperature = temperatureRecord.getTemperature();

		logger.info("SMSAlert = UserName: "+userName + "; Mobile: "+mobile + "; Temperature: " + temperature);

		// send sms on user mobile with the help of above data
	}

}
