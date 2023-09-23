package com.jspiders.carrestproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.carrestproject.pojo.UserPojo;
import com.jspiders.carrestproject.responce.UserResponce;
import com.jspiders.carrestproject.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping(path = "/createAccount", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponce> createAccount(@RequestBody UserPojo user){
		UserPojo pojo= service.createAccount(user);
		if (user != null) {
			return new ResponseEntity<UserResponce>(new UserResponce("Account Created Successfully...", pojo),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<UserResponce>(new UserResponce("Account Not Created...", null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponce> login(@RequestBody UserPojo user){
		UserPojo pojo = service.login(user);
		if (pojo!= null) {
			return new ResponseEntity<UserResponce>(new UserResponce("Login Successfully...", pojo),HttpStatus.OK);
		}
		return new ResponseEntity<UserResponce>(new UserResponce("Login Failed!!!", null), HttpStatus.NOT_FOUND);
	}
}
