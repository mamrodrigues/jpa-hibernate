package br.com.mamr.financas.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.mamr.financas.model.Categoria;
import br.com.mamr.financas.model.Conta;
import br.com.mamr.financas.model.Movimentacao;
import br.com.mamr.financas.model.TipoMovimentacao;

public class MovimentacaoDAO extends BaseDAO<Movimentacao> {
	
    public MovimentacaoDAO() {
        super(Movimentacao.class);
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo" +
                " group by m.data";

        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        return query.getResultList();

    }
    
    public List<Double> getNamedMediasPorDiaETipo() {

        EntityManager manager = new EntityManagerSingleton().getInstance();

        Conta conta = new Conta();
        conta.setId(2);

        TypedQuery<Double> query = manager.createNamedQuery("MediasPorDiaETipo", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        return query.getResultList();
    }
    
    public List<Movimentacao> getListaMovimentacaoPorCategoria(Categoria categoria) {

        EntityManager em = new EntityManagerSingleton().getInstance();

        Query query = em
                .createQuery("select m from Movimentacao m join m.categorias c where c = :pCategoria");

        query.setParameter("pCategoria", categoria);

        return query.getResultList();
    }
}
