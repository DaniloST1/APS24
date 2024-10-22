package com.mycompany.main;

public class Fornecedor {
    
    private String nome;
    private String telefone;

    // Construtor
    public Fornecedor(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método toString para exibir informações do fornecedor
    @Override
    public String toString() {
        return "Fornecedor [Nome=" + nome + ", Telefone=" + telefone + "]";
    }
}
