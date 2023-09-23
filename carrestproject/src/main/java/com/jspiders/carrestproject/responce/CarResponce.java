package com.jspiders.carrestproject.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.jspiders.carrestproject.pojo.CarPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponce {
	private String msg;
	private CarPojo car;
	private List<CarPojo> cars;
}
