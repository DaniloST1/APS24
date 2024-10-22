package com.mycompany.main;

import java.util.ArrayList;

// Classe Estoque
public class Estoque {
    private ArrayList<Produto> produtos;
    private ArrayList<Fornecedor> fornecedores;

    // Construtor
    public Estoque() {
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
    }

    // Adicionar Produto ao Estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Adicionar Fornecedor
    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    // Listar Produtos
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    // Listar Fornecedores
    public void listarFornecedores() {
        if (fornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
        } else {
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println(fornecedor);
            }
        }
    }
}
