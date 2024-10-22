package com.mycompany.main;

import java.util.Date;

public class Produto {
    
    private String nome;
    private double preco;
    private Date dataFabricacao;
    private Date dataValidade;

    // Construtor
    public Produto(String nome, double preco, Date dataFabricacao, Date dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    // Método toString para exibir informações do produto
    @Override
    public String toString() {
        return "Produto [Nome=" + nome + ", Preço=" + preco + 
               ", Data de Fabricação=" + dataFabricacao + 
               ", Data de Validade=" + dataValidade + "]";
    }
}
