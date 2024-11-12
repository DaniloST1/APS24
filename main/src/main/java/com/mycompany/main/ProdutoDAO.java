package com.mycompany.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    // Método para listar todos os produtos
    public List<String> listarProdutos() throws SQLException {
        List<String> produtos = new ArrayList<>();
        String sql = "SELECT name_product, price_product, fabrication, validity FROM produtos";
        
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = rs.getString("name_product");
                double preco = rs.getDouble("price_product");
                String dataFabricacao = rs.getString("fabrication");
                String dataValidade = rs.getString("validity");
                
                // Alterando o formato para o desejado: "produto | preço | data | data"
                String produtoInfo = nome + " | R$ " + String.format("%.2f", preco) + " | " + dataFabricacao + " | " + dataValidade;
                produtos.add(produtoInfo);
            }
        }
        return produtos;
    }
}