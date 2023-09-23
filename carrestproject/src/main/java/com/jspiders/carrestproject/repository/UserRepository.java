package com.jspiders.carrestproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.carrestproject.pojo.UserPojo;

@Repository
public class UserRepository {
	
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

	public UserPojo createAccount(UserPojo user) {
		openConnection();
		transaction.begin();
		
		manager.persist(user);
		
		transaction.commit();
		closeConnection();
		
		return user;
	}

	public UserPojo login(UserPojo user) {
		openConnection();
		transaction.begin();
		
		UserPojo pojo = manager.find(UserPojo.class, user.getUsername());
		if (pojo != null && pojo.getPassword().equals(user.getPassword())) {
			
				transaction.commit();
				closeConnection();
				return pojo;
			
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

}
