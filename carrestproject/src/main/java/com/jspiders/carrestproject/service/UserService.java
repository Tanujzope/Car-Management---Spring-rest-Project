package com.jspiders.carrestproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.carrestproject.pojo.UserPojo;
import com.jspiders.carrestproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public UserPojo createAccount(UserPojo user) {
		UserPojo pojo = repository.createAccount(user);
		return pojo;
	}


	public UserPojo login(UserPojo user) {
		UserPojo pojo = repository.login(user);
		return pojo;
	}

}
