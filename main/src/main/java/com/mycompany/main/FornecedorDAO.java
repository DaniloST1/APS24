package com.mycompany.main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class FornecedorDAO {
    
    public void salvarFornecedor(String nome, String contato) throws SQLException {
        String sql = "INSERT INTO fornecedor (name_sup, number) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, contato); // Mudando para String para melhor manipulação do contato
            stmt.executeUpdate();
        }
    }
    public List<String> listarFornecedores() throws SQLException {
        String sql = "SELECT nome FROM fornecedor";
        List<String> fornecedores = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornecedores.add(rs.getString("nome"));
            }
        }
        return fornecedores;
    }
}