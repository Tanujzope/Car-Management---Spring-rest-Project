package com.jspiders.carrestproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.carrestproject.pojo.CarPojo;
import com.jspiders.carrestproject.repository.CarRepository;

@Service
public class CarService {

	
	@Autowired
	private CarRepository repository;
	
	
	public CarPojo addCar(CarPojo pojo) {
		CarPojo car = repository.addCar(pojo);
		return car;
	}


	public CarPojo removeCar(int id) {
		CarPojo car = repository.removeCar(id);
		return car;
	}


	public CarPojo updateCar(CarPojo pojo) {
		CarPojo car = repository.updateCar(pojo);
		return car;
	}


	public CarPojo searchCar(int id) {
		CarPojo car = repository.searchCar(id);
		return car;
	}


	public List<CarPojo> searchAllCars() {
		List<CarPojo> cars = repository.searchAllCars();
		return cars;
	}

}
