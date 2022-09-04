package com.weather.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 02-09-2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "USER_CONFIGURATION")
public class UserConfiguration {
	@Id
	@SequenceGenerator(name = "config_seq", sequenceName = "config_seq_in_db")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "config_seq")
	private Long configurationId;

	@OneToOne(mappedBy = "userConfiguration")
	@JsonIgnore
	private User user;

	@Max(32)
	@Min(26)
	@Column(name = "MAX_WEATHER")
	private int max_weather = 28;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NOTIFICATION_ID")
	@JsonProperty(value = "notificationMode")
	private NotificationMode notificationMode;

	public UserConfiguration(Long configurationId, int max_weather, NotificationMode notificationMode) {
		this.configurationId = configurationId;
		this.max_weather = max_weather;
		this.notificationMode = notificationMode;
	}

	@PrePersist
	void preInsert() {
		if (this.notificationMode == null)
			this.notificationMode = new NotificationMode();
	}

}
