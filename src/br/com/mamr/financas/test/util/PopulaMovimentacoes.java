package br.com.mamr.financas.test.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.mamr.financas.model.Categoria;
import br.com.mamr.financas.model.Conta;
import br.com.mamr.financas.model.Movimentacao;
import br.com.mamr.financas.model.TipoMovimentacao;
import br.com.mamr.financas.model.dao.EntityManagerSingleton;

public class PopulaMovimentacoes {

	public static void main(String[] args) {

		EntityManager em = new EntityManagerSingleton().getInstance();
		em.getTransaction().begin();

		Categoria viagem = em.createQuery("from Categoria c where c.nome like :pNome", Categoria.class)
				.setParameter("pNome", "Viagem")
				.getSingleResult();

		Categoria negocios = em.createQuery("from Categoria c where c.nome like :pNome", Categoria.class)
				.setParameter("pNome", "Negocios")
				.getSingleResult();

		Conta conta = new Conta();
		conta.setId(2);

		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Uber");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal(100.0));
		movimentacao1.setCategorias(Arrays.asList(viagem, negocios));

		movimentacao1.setConta(conta);

		Categoria alimentacao = em.createQuery("from Categoria c where c.nome like :pNome", Categoria.class)
				.setParameter("pNome", "Alimentacao")
				.getSingleResult();

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("IFood");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal(300.0));
		movimentacao2.setCategorias(Arrays.asList(alimentacao));

		movimentacao2.setConta(conta);

		Categoria eletronicos = em.createQuery("from Categoria c where c.nome like :pNome", Categoria.class)
				.setParameter("pNome", "Eletronicos")
				.getSingleResult();

		Movimentacao movimentacao3 = new Movimentacao();
		movimentacao3.setData(Calendar.getInstance());
		movimentacao3.setDescricao("Apple TV");
		movimentacao3.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao3.setValor(new BigDecimal(300.0));
		movimentacao3.setCategorias(Arrays.asList(eletronicos));

		movimentacao3.setConta(conta);

		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.persist(movimentacao3);

		em.getTransaction().commit();
		em.close();

	}

}
