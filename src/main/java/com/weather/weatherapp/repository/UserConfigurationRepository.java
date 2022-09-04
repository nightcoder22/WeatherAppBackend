package com.weather.weatherapp.repository;

import com.weather.weatherapp.entity.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project:- eQube-TM
 * Created by @author Akshay
 * on 02-09-2022
 */

@Repository
public interface UserConfigurationRepository extends JpaRepository<UserConfiguration, Long> {
	UserConfiguration findUserConfigurationByUser_UserId(Long userId);
}
