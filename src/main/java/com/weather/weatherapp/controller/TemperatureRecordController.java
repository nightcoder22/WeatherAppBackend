package com.weather.weatherapp.controller;

import com.weather.weatherapp.entity.TemperatureRecord;
import com.weather.weatherapp.exceptions.TemperatureRecordNotUpdatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.weather.weatherapp.repository.TemperatureRecordRepository;
import com.weather.weatherapp.service.TemperatureService;

import java.util.Objects;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@RestController
@RequestMapping("/temperature")
public class TemperatureRecordController {

	@Autowired
	TemperatureRecordRepository temperatureRecordRepository;

	@Autowired
	TemperatureService temperatureService;

	/*
	* We will manually trigger this api to insert records in temp record table
	* */
	@PostMapping("/add")
	private ResponseEntity<Object> addTemperatureRecord() {
		//handel exception to return proper error message
		TemperatureRecord temperatureRecord = temperatureService.recordTemperature();
		if (Objects.nonNull(temperatureRecord)){
			return ResponseEntity.ok(temperatureRecord);
		} else{
			throw new TemperatureRecordNotUpdatedException();
		}
	}

	/*
	 * This will return latest temperature record.
	 * */
	@GetMapping("/latest")
	private ResponseEntity<Object> getLatestTemperature(){
		return ResponseEntity.ok(temperatureRecordRepository.findFirstByOrderByTempIdDesc());
	}

}
