package com.weather.weatherapp.service;

import com.weather.weatherapp.entity.NotificationMode;
import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.interfaces.Notifiable;
import com.weather.weatherapp.model.ApplicationAlert;
import com.weather.weatherapp.model.EmailAlert;
import com.weather.weatherapp.model.SmsAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weather.weatherapp.repository.TemperatureRecordRepository;
import com.weather.weatherapp.repository.UserRepository;

import java.util.List;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@Service
public class NotificationService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TemperatureRecordRepository temperatureRecordRepository;

	/*
	 * This method will be triggered whenever new record is inserted in TemperatureRecord table
	 * */
	public void getUserAndNotify() {
		List<User> userList = userRepository.findAll();
		userList.forEach(this::sendNotification);
	}

	/**
	 * @param user Object
	 * This method will send notification to user based on his preference
	 */
	public void sendNotification(User user) {
		Long userId = user.getUserId();
		TemperatureRecord temperatureRecord = temperatureRecordRepository.findFirstByOrderByTempIdDesc();
		NotificationMode notificationMode = user.getUserConfiguration().getNotificationMode();
		Notifiable notifiable;
		if (notificationMode.isSms()) {
			notifiable = new SmsAlert();
			notifiable.notify(user, temperatureRecord);
		}
		if (notificationMode.isEmail()) {
			notifiable = new EmailAlert();
			notifiable.notify(user, temperatureRecord);
		}
		if (notificationMode.isApplication()) {
			notifiable = new ApplicationAlert();
			notifiable.notify(user, temperatureRecord);
		}
	}

}
