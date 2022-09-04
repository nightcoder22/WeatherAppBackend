package com.weather.weatherapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Project:- WeatherApp
 * Created by @author Akshay
 * on 04-09-2022
 *
 * Controller to handle exceptions for our controller
 */

@ControllerAdvice
public class ExceptionController {

	/**
	 * @param exception UserNotFoundException
	 * Handles User not found exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}

	/**
	 * @param exception TemperatureRecordNotUpdatedException
	 * Handles Temperature record not updated exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = TemperatureRecordNotUpdatedException.class)
	public ResponseEntity<Object> exception(TemperatureRecordNotUpdatedException exception) {
		return new ResponseEntity<>("Temperature record is same as latest, temperature not updated",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<Object> handleConstraintViolationException(MethodArgumentNotValidException exception) {
		final List<String> errors = new ArrayList<String>();
		for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
