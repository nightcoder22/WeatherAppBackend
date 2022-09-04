package com.weather.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 02-09-2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class User {

	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq_in_db")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "user_seq")
	private Long userId;

	@NotBlank(message = "Username is mandatory")
	@Column(name = "USER_NAME")
	private String userName;

	@NotBlank(message = "Mobile is mandatory")
	@Column(name = "MOBILE")
	private String mobile;

	@NotBlank(message = "Email is mandatory")
	@Email
	@Column(name = "EMAIL")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONFIGURATION_ID")
	@JsonProperty(value = "userConfiguration")
	private UserConfiguration userConfiguration;

	@PrePersist
	void preInsert() {
		if (this.userConfiguration == null)
			this.userConfiguration = new UserConfiguration();
	}
}
