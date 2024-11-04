package com.mycompany.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProdutoDAO {
    private static final String URL = "jdbc:mysql://localhost/gerenciador_estoque";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void salvarProduto(String nome, double preco, String dataFabricacao, String dataValidade) throws SQLException {
        String sql = "INSERT INTO produtos (name_product, price_product, fabrication, validity, id_sup) VALUES (?, ?, ?, ?, 8)";
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setString(3, dataFabricacao);
            stmt.setString(4, dataValidade);
            stmt.executeUpdate();
        }
    }
}