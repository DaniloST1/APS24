package com.mycompany.main;

import java.util.ArrayList;

// Classe Estoque
public class Estoque {
    private ArrayList<ProdutoDAO> produtos; // Mantido para armazenar objetos do tipo ProdutoDAO
    private ArrayList<FornecedorDAO> fornecedores; // Mantido para armazenar objetos do tipo FornecedorDAO

    // Construtor
    public Estoque() {
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    // Adicionar Produto ao Estoque
    public void adicionarProduto(ProdutoDAO produto) {
        produtos.add(produto);
    }

    // Adicionar Fornecedor
    public void adicionarFornecedor(FornecedorDAO fornecedor) {
        fornecedores.add(fornecedor);
    }

    // Listar Produtos
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (ProdutoDAO produto : produtos) {
                System.out.println(produto); // Imprime detalhes do produto
            }
        }
    }

    // Listar Fornecedores
    public void listarFornecedores() {
        if (fornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
        } else {
            for (FornecedorDAO fornecedor : fornecedores) {
                System.out.println(fornecedor); // Imprime detalhes do fornecedor
            }
        }
    }
}
