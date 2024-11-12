package com.mycompany.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    
    // Método para salvar um novo fornecedor no banco de dados
    public void salvarFornecedor(String nome, String contato) throws SQLException {
        String sql = "INSERT INTO fornecedor (name_sup, number) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, contato);
            stmt.executeUpdate();
        }
    }

    // Método para listar fornecedores com base na pesquisa pelo nome
    public List<String> listarFornecedores(String pesquisa) throws SQLException {
        String sql = "SELECT name_sup, number FROM fornecedor WHERE name_sup LIKE ?";
        List<String> fornecedores = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Utiliza o "%" para permitir pesquisa parcial (por exemplo, "Fornecedor A%" para encontrar qualquer fornecedor que comece com "Fornecedor A")
            stmt.setString(1, "%" + pesquisa + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("name_sup");
                    String contato = rs.getString("number");
                    fornecedores.add(nome + " | " + contato);  // Formato desejado: nome | contato
                }
            }
        }
        return fornecedores;
    }
}
