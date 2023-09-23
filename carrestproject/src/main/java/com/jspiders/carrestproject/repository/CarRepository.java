package com.jspiders.carrestproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.carrestproject.pojo.CarPojo;

@Repository
public class CarRepository {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("carrest");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	
	
	public CarPojo addCar(CarPojo pojo) {
		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		
		return pojo;
	}


	public CarPojo removeCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, id);
		if (car != null) {
			manager.remove(car);
			transaction.commit();
			closeConnection();
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}


	public CarPojo updateCar(CarPojo pojo) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, pojo.getId());
		
		if (car!= null) {
			car.setCarName(pojo.getCarName());
			car.setBrandName(pojo.getBrandName());
			car.setFuelType(pojo.getFuelType());
			car.setPrice(pojo.getPrice());
			
			manager.persist(car);
			
			transaction.commit();
			closeConnection();
			
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}


	public CarPojo searchCar(int id) {
		openConnection();
		transaction.begin();
		
		CarPojo car = manager.find(CarPojo.class, id);
		
		if (car != null) {
			transaction.commit();
			closeConnection();
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}


	public List<CarPojo> searchAllCars() {
		openConnection();
		transaction.begin();
		
		String jpql = "from CarPojo";
		query = manager.createQuery(jpql);
		
		List<CarPojo> cars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		
		return cars;
		
	}
	
}
