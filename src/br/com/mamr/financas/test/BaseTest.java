package br.com.mamr.financas.test;

import javax.persistence.EntityManager;

public class BaseTest {
		
	public void iniciaTransacao(EntityManager entityManager) {
		entityManager.getTransaction().begin();
	}
	
	public void finalizaTransacao(EntityManager entityManager) {
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
