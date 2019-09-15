package br.com.mamr.financas.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mamr.financas.model.Conta;

public class ContaDAO extends BaseDAO<Conta> {

	public ContaDAO() {
		super(Conta.class);
	}

	public List<Conta> getListaContaComESemMovimentacao() {
		EntityManager manager = new EntityManagerSingleton().getInstance();
        
		/**
		 * TypedQuery é, como diz o nome, uma query tipada que define o retorno da query informada
		 * Por isso é melhor que o Query
		 * Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes", Conta.class);
		 */
        TypedQuery<Conta> query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes", Conta.class);

        return query.getResultList();
	}

}
