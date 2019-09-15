package br.com.mamr.financas.test;

import java.util.List;

import br.com.mamr.financas.model.Categoria;
import br.com.mamr.financas.model.dao.CategoriaDAO;

public class TesteCategoriaDAO {
	
	public static void main(String[] args) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		List<Categoria> categorias = categoriaDAO.getListaCategoriaJPQL();
		
        for (Categoria c : categorias) {
            System.out.println("\nID: " + c.getId() + " Nome: "+c.getNome());
        }
	}

}
