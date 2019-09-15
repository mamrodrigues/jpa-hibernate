package br.com.mamr.financas.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mamr.financas.model.Categoria;

public class CategoriaDAO extends BaseDAO<Categoria> {
	
	public CategoriaDAO() {
		super(Categoria.class);
	}

	public List<Categoria> getListaCategoriaJPQL() {

        EntityManager em = new EntityManagerSingleton().getInstance();

        String jpql = "from Categoria";        
        return em.createQuery(jpql, Categoria.class).getResultList();

    }
}
