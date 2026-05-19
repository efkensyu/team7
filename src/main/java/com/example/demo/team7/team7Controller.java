package com.example.demo.team7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class team7Controller {
	@GetMapping("test")
	public String index() {
		return "hello world";
	}

}
