package com.mycompany.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GerenciarEstoque {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean sair = false;
        while (!sair) {
            System.out.println("\n1. Adicionar Produto");
            System.out.println("2. Adicionar Fornecedor");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Listar Fornecedores");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();  // Consumir nova linha

                    try {
                        System.out.print("Data de Fabricação (dd/MM/yyyy): ");
                        String dataFabStr = scanner.nextLine();
                        System.out.print("Data de Validade (dd/MM/yyyy): ");
                        String dataValStr = scanner.nextLine();

                        Produto produto = new Produto(nomeProduto, preco, sdf.parse(dataFabStr), sdf.parse(dataValStr));
                        estoque.adicionarProduto(produto);
                        System.out.println("Produto adicionado com sucesso!");
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Tente novamente.");
                    }
                    break;

                case 2:
                    System.out.print("Nome do Fornecedor: ");
                    String nomeFornecedor = scanner.nextLine();
                    System.out.print("Telefone do Fornecedor: ");
                    String telefone = scanner.nextLine();
                    Fornecedor fornecedor = new Fornecedor(nomeFornecedor, telefone);
                    estoque.adicionarFornecedor(fornecedor);
                    System.out.println("Fornecedor adicionado com sucesso!");
                    break;

                case 3:
                    estoque.listarProdutos();
                    break;

                case 4:
                    estoque.listarFornecedores();
                    break;

                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
