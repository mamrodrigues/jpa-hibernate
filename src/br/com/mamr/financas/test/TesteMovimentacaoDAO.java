package br.com.mamr.financas.test;

import java.util.List;

import br.com.mamr.financas.model.Categoria;
import br.com.mamr.financas.model.Movimentacao;
import br.com.mamr.financas.model.dao.CategoriaDAO;
import br.com.mamr.financas.model.dao.MovimentacaoDAO;

public class TesteMovimentacaoDAO {
	
    public static void main(String[] args) {
    	
    	MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
    	List<Double> medias = movimentacaoDAO.getNamedMediasPorDiaETipo();
    	for (Double media : medias) {
            System.out.println("Media: " + media);
        }

    	
    	CategoriaDAO categoriaDAO = new CategoriaDAO();
    	Categoria categoria = categoriaDAO.getList().get(3);
    	
    	List<Movimentacao> movimentacoes = movimentacaoDAO.getListaMovimentacaoPorCategoria(categoria);
        for (Movimentacao m : movimentacoes) {
            System.out.println("\nDescricao ..: " + m.getDescricao());
            System.out.println("Valor ......: R$ " + m.getValor());
        }
    }

}
