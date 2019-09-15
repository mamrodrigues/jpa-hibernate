package br.com.mamr.financas.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	public List<Categoria> getListaCategoriaPorNomeCriteria(String nomeCategoria){
        EntityManager em = new EntityManagerSingleton().getInstance();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteriaQuery = criteriaBuilder.createQuery(Categoria.class);
		Root<Categoria> root = criteriaQuery.from(Categoria.class);
		Path<String> pNome = root.get("nome");
		
		if(nomeCategoria != null && !nomeCategoria.isEmpty()) {
			Predicate predicateNome = criteriaBuilder.like(pNome, "%" + nomeCategoria + "%");
			criteriaQuery.where(predicateNome);
		}
		
		TypedQuery<Categoria> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}
}
