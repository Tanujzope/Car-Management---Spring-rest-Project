package com.jspiders.carrestproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.carrestproject.pojo.CarPojo;
import com.jspiders.carrestproject.responce.CarResponce;
import com.jspiders.carrestproject.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService service;
	
	@PostMapping (path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponce> addCar(@RequestBody CarPojo pojo){
		CarPojo car = service.addCar(pojo);
		if (car!= null) {
			return new ResponseEntity<CarResponce>(new CarResponce("Car Added Successfully...", car, null), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponce>(new CarResponce("Car Not Added!!!", null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@DeleteMapping(path = "/removeCar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponce> removeCar(@PathVariable int id){
		CarPojo car = service.removeCar(id);
		if (car != null) {
			return new ResponseEntity<CarResponce>(new CarResponce("Car Removed Successfully...", car, null), HttpStatus.OK);
		}
		
		return new ResponseEntity<CarResponce>(new CarResponce("Car Not Removed!!!", null, null), HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(path = "/updateCar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponce> updateCar(@RequestBody CarPojo pojo){
		CarPojo car = service.updateCar(pojo);
		
		if (car!= null) {
			return new ResponseEntity<CarResponce>(new CarResponce("Car Updated Successfully...", car, null), HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<CarResponce>(new CarResponce("Car Not Updated!!!", null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	@GetMapping(path = "/searchCar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponce> searchCar(@PathVariable int id){
		CarPojo car = service.searchCar(id);
		
		if (car != null) {
			return new ResponseEntity<CarResponce>(new CarResponce("Car Fetched Successfully...", car, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponce>(new CarResponce("Car Not Found!!!", null, null), HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(path = "/searchAllCars")
	public ResponseEntity<CarResponce> searchAllCars(){
		List<CarPojo> cars = service.searchAllCars();
		if (!cars.isEmpty()) {
			return new ResponseEntity<CarResponce>(new CarResponce("All Cars Fetched Successfully...", null, cars), HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponce>(new CarResponce("No Cars Found!!!", null, null), HttpStatus.NOT_FOUND);
	}
	
	
}
