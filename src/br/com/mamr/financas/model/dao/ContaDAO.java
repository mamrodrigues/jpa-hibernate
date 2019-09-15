package br.com.mamr.financas.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mamr.financas.model.Conta;

public class ContaDAO extends BaseDAO<Conta> {

	public ContaDAO() {
		super(Conta.class);
	}

	public List<Conta> getListaContaComESemMovimentacao() {
		EntityManager manager = new EntityManagerSingleton().getInstance();
        Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes", Conta.class);

        return query.getResultList();
	}

}
