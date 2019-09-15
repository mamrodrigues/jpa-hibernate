package br.com.mamr.financas.test.util;

import javax.persistence.EntityManager;

import br.com.mamr.financas.model.Categoria;
import br.com.mamr.financas.model.dao.EntityManagerSingleton;

public class PopulaCategoria {

    public static void main(String[] args) {
        
        EntityManager em = new EntityManagerSingleton().getInstance();
        em.getTransaction().begin();
    
        em.persist(new Categoria("Viagem"));
        em.persist(new Categoria("Negocios"));
        em.persist(new Categoria("Eletronicos"));
        em.persist(new Categoria("Alimentacao"));
        em.persist(new Categoria("Lazer"));
        em.persist(new Categoria("Supermercado"));
        em.persist(new Categoria("Vestuario"));
        
        em.getTransaction().commit();
        em.close();
    }
}
