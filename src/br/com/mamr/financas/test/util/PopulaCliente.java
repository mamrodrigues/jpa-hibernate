package br.com.mamr.financas.test.util;

import javax.persistence.EntityManager;

import br.com.mamr.financas.model.Cliente;
import br.com.mamr.financas.model.Conta;
import br.com.mamr.financas.model.dao.EntityManagerSingleton;
import br.com.mamr.financas.test.BaseTest;

public class PopulaCliente {

	public static void main(String[] args) {
    	EntityManager em = new EntityManagerSingleton().getInstance();
    	BaseTest test = new BaseTest();
        
        Cliente cliente = new Cliente();
        cliente.setNome("Marcos");
        cliente.setEndereco("Asa Sul, 512");
        cliente.setProfissao("Engenheiro de Software");

        Conta conta = new Conta();
        conta.setId(2);

        cliente.setConta(conta);

        test.iniciaTransacao(em);
        em.persist(cliente);
        test.finalizaTransacao(em);
    }
}
