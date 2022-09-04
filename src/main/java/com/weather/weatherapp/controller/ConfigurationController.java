package com.weather.weatherapp.controller;

import com.weather.weatherapp.entity.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.weather.weatherapp.repository.UserConfigurationRepository;

import javax.validation.Valid;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

	@Autowired
	UserConfigurationRepository userConfigurationRepository;

	/**
	 * @param userConfiguration
	 *  Save / Update user configuration
	 * @return UserConfiguration object
	 */
	@PostMapping()
	public ResponseEntity<UserConfiguration> saveConfiguration(@Valid @RequestBody UserConfiguration userConfiguration){
		return ResponseEntity.ok(userConfigurationRepository.save(userConfiguration));
	}

	/**
	 * @param userId Long
	 * This method will return user configurations
	 * @return User Configuration object
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<UserConfiguration> getConfiguration(@PathVariable Long userId){
		return ResponseEntity.ok(userConfigurationRepository.findUserConfigurationByUser_UserId(userId));
	}

}
