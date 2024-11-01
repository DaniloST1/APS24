package com.mycompany.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost/gerenciador_estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obter a conexão
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use "com.mysql.cj.jdbc.Driver" para versões mais recentes
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado: " + ex.getMessage());
            throw new SQLException("Driver do banco de dados não encontrado.", ex);
        }
        
        // Estabelecer a conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
