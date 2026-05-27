package com.example.demo.team7;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = "com.example.demo.team7")
@Slf4j
public class Team7Advice {
	@ExceptionHandler(Throwable.class)
	public String handleException() {
		return "team7/Team7Error";
	}

}
