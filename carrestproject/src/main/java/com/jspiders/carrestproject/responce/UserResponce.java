package com.jspiders.carrestproject.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.carrestproject.pojo.UserPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponce {
	private String msg;
	private UserPojo user;
}
