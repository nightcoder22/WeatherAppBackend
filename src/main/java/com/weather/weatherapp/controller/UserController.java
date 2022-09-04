package com.weather.weatherapp.controller;

import com.weather.weatherapp.entity.User;
import com.weather.weatherapp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.weather.weatherapp.repository.UserRepository;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 03-09-2022
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	/**
	 * @param id
	 * 		User Id
	 * 		Returns user by user id
	 *
	 * @return User object
	 */
	@GetMapping("/{id}")
	ResponseEntity<Optional<User>> getUser( @PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) throw new UserNotFoundException();
		return ResponseEntity.ok(user);
	}

	/**
	 * @param userName
	 * 		username
	 * 		Returns user by user name
	 *
	 * @return User object
	 */
	@GetMapping("/name/{userName}")
	ResponseEntity<User> getUserbyUserName( @PathVariable String userName){
		User user = userRepository.findUserByUserName(userName);
		if (Objects.isNull(user)) throw new UserNotFoundException();
		return ResponseEntity.ok(user);
	}

	/**
	 * @param user User object
	 * Save new User
	 * @return User object
	 */
	@PostMapping
	ResponseEntity<User> saveUser (@Valid @RequestBody User user){
		return ResponseEntity.ok(userRepository.save(user));
	}

}
