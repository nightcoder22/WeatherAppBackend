package com.weather.weatherapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@Entity
@Table(name = "TEMPERATURE_RECORD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureRecord {
	@Id @Column(name = "TEMP_ID") @GeneratedValue(strategy = GenerationType.AUTO)
	private Long tempId;

	@NotNull
	@Column(name = "TIME")
	private Date date;

	@Max(32)
	@Min(26)
	@NotNull
	@Column(name = "TEMPERATURE")
	private int temperature;

	public TemperatureRecord (Date date, int temperature){
		this.date = date;
		this.temperature = temperature;
	}
}
