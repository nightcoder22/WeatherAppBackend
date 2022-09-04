package com.weather.weatherapp.interfaces;

import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.entity.User;

/**
 * Project:- eQube-TM
 * Created by @author Akshay
 * on 02-09-2022
 */

public interface Notifiable {
	void notify(User user, TemperatureRecord temperatureRecord);
}
