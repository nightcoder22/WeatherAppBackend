package com.weather.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 02-09-2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_MODE")
public class NotificationMode {
	@Id
	@SequenceGenerator(name = "notify_seq", sequenceName = "notify_seq_in_db")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "notify_seq")
	private Long notificationId;

	@OneToOne(mappedBy = "notificationMode")
	@JsonIgnore
	private UserConfiguration userConfiguration;

	@Column(name = "SMS")
	private boolean sms;

	@Column(name = "EMAIL")
	private boolean email;

	@Column(name = "APPLICATION")
	private boolean application;

	public NotificationMode(Long notificationId, boolean sms, boolean email, boolean application) {
		this.notificationId = notificationId;
		this.sms = sms;
		this.email = email;
		this.application = application;
	}

}
