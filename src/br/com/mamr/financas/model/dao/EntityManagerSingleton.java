package br.com.mamr.financas.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
	
	private EntityManagerFactory entityManagerFactory;

	public EntityManager getInstance() {
		
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		}
		return entityManagerFactory.createEntityManager();
	}

}
