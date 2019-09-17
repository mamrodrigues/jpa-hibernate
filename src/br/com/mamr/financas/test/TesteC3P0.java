package br.com.mamr.financas.test;

import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TesteC3P0 {
	
	public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        for(int i = 0; i < 10; i ++) {
            dataSource.getConnection();

            System.out.println(i + " - Conex�es existentes: " + dataSource.getNumConnections());
            System.out.println(i + " - Conex�es ocupadas: " + dataSource.getNumBusyConnections());
            System.out.println(i + " - Conex�es ociosas: " + dataSource.getNumIdleConnections());

            System.out.println("");
        }
    }

}
