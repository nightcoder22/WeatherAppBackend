package com.weather.weatherapp.repository;

import com.weather.weatherapp.entity.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project:- eQube-TM
 * Created by @author Akshay
 * on 03-09-2022
 */

@Repository
public interface TemperatureRecordRepository extends JpaRepository<TemperatureRecord, Long> {

	TemperatureRecord findFirstByOrderByTempIdDesc();

}
