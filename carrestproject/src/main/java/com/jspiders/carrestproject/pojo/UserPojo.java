package com.jspiders.carrestproject.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserPojo {
	@Id
	private String username;
	private String password;
}
