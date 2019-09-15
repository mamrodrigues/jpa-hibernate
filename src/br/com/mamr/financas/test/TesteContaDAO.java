package br.com.mamr.financas.test;

import java.util.List;

import br.com.mamr.financas.model.Conta;
import br.com.mamr.financas.model.dao.ContaDAO;

public class TesteContaDAO {
	
	public static void main(String[] args) {
		
		ContaDAO contaDAO = new ContaDAO();
		List<Conta> contasComMovimentacao = contaDAO.getListaContaComESemMovimentacao();
		for (Conta conta : contasComMovimentacao) {
            System.out.println("Titular: " + conta.getTitular() + " Movimentacoes: " + conta.getMovimentacoes().size());
        }
		
		List<Conta> contas = contaDAO.getList();
		for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular() + " Movimentacoes: " + conta.getMovimentacoes().size());
        }
    }

}
