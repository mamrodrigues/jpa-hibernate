package br.com.mamr.financas.test;

import javax.persistence.EntityManager;

import br.com.mamr.financas.model.Conta;
import br.com.mamr.financas.model.dao.EntityManagerSingleton;

public class TesteConta extends BaseTest {
	
	public static void main(String[] args) {
		BaseTest teste = new BaseTest();
		EntityManager em = new EntityManagerSingleton().getInstance();
		
		/** 
		 * Primeiro Teste - Persist
		 */
		Conta conta = new Conta();
		teste.iniciaTransacao(em);
		testPersist(em, conta);
		teste.finalizaTransacao(em);
		
		/** 
		 * Segundo Teste - Persist
		 * Mesmo ap�s o persist, o objeto ser� salvo com o Banco Bradesco
		 * pois o objeto ainda est� no estado Managed
		 * 
		 * O est� mantido at� o momento do commit da transa��o
		 */
//		Conta conta = new Conta();
//		teste.iniciaTransacao(em);
//		testPersist(em, conta);
//		conta.setBanco("Bradesco");
//		teste.finalizaTransacao(em);
		
		/** 
		 * Terceiro Teste - Find
		 * Assim como no segundo teste, mesmo ap�s o persist, o objeto ser� salvo com o Banco Itau
		 * pois o objeto ainda est� no estado Managed at� que a transa��o seja commitada
		 */
//		Conta conta = new Conta();
//		conta.setId(1);
//		teste.iniciaTransacao(em);
//		conta = testFind(em, conta);
//		conta.setBanco("Santander");
//		teste.finalizaTransacao(em);
		
		/** 
		 * Quarto Teste - Find
		 * 
		 * Deixando o Terceiro Teste habilitado junto com este teste
		 * temos a seguinte resposta: java.lang.IllegalStateException: Session/EntityManager is closed
		 * 
		 * Este erro ocorre pois a Transa��o criada anteriormente j� foi fechada
		 * Al�m disso, o objeto pode at� receber o valor mas seu estado para a JPA agora � DETACHED
		 * ent�o n�o surtir� efeito no banco de dados
		 * 
		 */
//		conta.setBanco("Nubank");
//		conta = testFind(em, conta);
		
		/** 
		 * Quinto Teste - Merge
		 * 
		 * Deixe o Terceiro Teste habilitado junto com este teste
		 * Perceba que ap�s o Merge, o novo valor Bradesco3 n�o � atualizado no banco
		 * mesmo ainda n�o tendo finalizado a transa��o com o commit.
		 * 
		 * Logo, o objeto deixa de ser Managed assim que o m�todo merge � acionado
		 * 
		 */
//		EntityManager em2 = new JPAUtil().getEntityManager();
//		teste.iniciaTransacao(em2);
//		conta.setBanco("Bradesco2");
//		testMerge(em2, conta);
//		conta.setBanco("Bradesco3");
//		teste.finalizaTransacao(em2);
		
		/** 
		 * Sexto(e ultimo) Teste - Remove
		 * 
		 */
//		EntityManager em3 = new JPAUtil().getEntityManager();
//		Conta conta6 = new Conta();
//		conta6.setId(1);
//		teste.iniciaTransacao(em3);
//		conta6 = testFind(em3, conta6);
//		conta6.setBanco("Santander");
//		conta6.setBanco("Bradesco2");
//		testRemove(em3, conta6);
//		conta6.setBanco("Bradesco3");
//		teste.finalizaTransacao(em3);
	}

	public static void testPersist(EntityManager em, Conta conta) {
		
		/**
		 * O ID n�o pode ser informado pois considera o estado do objeto como DETACHED 
		 * pois o Hibernate n�o encontra o gerenciamento deste objeto
		 * 
		 * Na verdade o objeto deveria ser considerado Transient, pois ainda n�o foi persistido
		 * Originando o erro: org.hibernate.PersistentObjectException: detached entity passed to persist
		 * 
		 * Este erro ocorre especialmente neste caso pois o a annotation GeneratedValue faz
		 * com que o JPA identifique esse objeto como j� existente
		 * 
		 */
		conta.setTitular("Danilo");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("456");

		em.persist(conta);
	}
	
	public static Conta testFind(EntityManager em, Conta conta) {
		return em.find(Conta.class, conta.getId());
	}
	
	public static Conta testMerge(EntityManager em, Conta conta) {
		return em.merge(conta);
	}
	
	public static void testRemove(EntityManager em, Conta conta) {
		em.remove(conta);
	}

}
