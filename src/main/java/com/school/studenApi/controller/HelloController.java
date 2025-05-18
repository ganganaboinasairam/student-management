package com.school.studenApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.studenApi.model.HelloResponse;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello")
	public HelloResponse sayHello() {
		return new HelloResponse("This is the response from hello Api");
	}
}
