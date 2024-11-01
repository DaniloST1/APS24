package com.mycompany.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

public class MainApp extends JFrame {

    public MainApp() {
        setTitle("Menu");
        setSize(500, 400); // Aumentando o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Diminuindo o tamanho dos botões
        JButton addProductButton = new JButton("Adicionar Produto");
        addProductButton.setPreferredSize(new Dimension(120, 50));

        JButton listProductButton = new JButton("Listar Produtos");
        listProductButton.setPreferredSize(new Dimension(120, 50));

        JButton addSupplierButton = new JButton("Adicionar Fornecedor");
        addSupplierButton.setPreferredSize(new Dimension(120, 50));

        JButton listSupplierButton = new JButton("Listar Fornecedores");
        listSupplierButton.setPreferredSize(new Dimension(120, 50));

        menuPanel.add(addProductButton);
        menuPanel.add(listProductButton);
        menuPanel.add(addSupplierButton);
        menuPanel.add(listSupplierButton);

        addProductButton.addActionListener(e -> openAddProductWindow());
        listProductButton.addActionListener(e -> openListProductsWindow());
        addSupplierButton.addActionListener(e -> openAddSupplierWindow());
        listSupplierButton.addActionListener(e -> openListSuppliersWindow());

        add(menuPanel, BorderLayout.CENTER);
    }

    private void openAddProductWindow() {
        JFrame addProductFrame = new JFrame("Adicionar Produto");
        addProductFrame.setSize(400, 300);
        addProductFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Campos de entrada para adicionar um produto
        panel.add(new JLabel("Nome do produto:"));
        JTextField productNameField = new JTextField();
        panel.add(productNameField);

        panel.add(new JLabel("Preço:"));
        JTextField priceField = new JTextField();
        panel.add(priceField);

        // Campo de Data de Fabricação
        panel.add(new JLabel("Data de fabricação:"));
        JFormattedTextField manufactureDateField = createDateField();
        panel.add(manufactureDateField);

        // Campo de Data de Validade
        panel.add(new JLabel("Data de validade:"));
        JFormattedTextField expiryDateField = createDateField();
        panel.add(expiryDateField);

        JButton saveButton = new JButton("Salvar");
        JButton backButton = new JButton("Voltar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);

        backButton.addActionListener(e -> addProductFrame.dispose());

        saveButton.addActionListener(e -> {
            try {
                String nome = productNameField.getText();
                double preco = Double.parseDouble(priceField.getText());
                String dataFabricacao = manufactureDateField.getText();
                String dataValidade = expiryDateField.getText();

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.salvarProduto(nome, preco, dataFabricacao, dataValidade);
                JOptionPane.showMessageDialog(addProductFrame, "Produto salvo com sucesso!");
                addProductFrame.dispose(); // Fechar a janela após salvar
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(addProductFrame, "Erro ao salvar o produto: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addProductFrame, "Erro: Preço inválido.");
            }
        });

        addProductFrame.add(panel, BorderLayout.CENTER);
        addProductFrame.add(buttonPanel, BorderLayout.SOUTH);
        addProductFrame.setVisible(true);
    }

    private JFormattedTextField createDateField() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            return new JFormattedTextField(dateMask);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void openListProductsWindow() {
        JFrame listProductsFrame = new JFrame("Produtos");
        listProductsFrame.setSize(400, 300);
        listProductsFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel productsLabel = new JLabel("Lista de produtos (exemplo)");
        panel.add(productsLabel);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> listProductsFrame.dispose());

        listProductsFrame.add(panel, BorderLayout.CENTER);
        listProductsFrame.add(backButton, BorderLayout.SOUTH);
        listProductsFrame.setVisible(true);
    }

    private void openAddSupplierWindow() {
        JFrame addSupplierFrame = new JFrame("Adicionar Fornecedor");
        addSupplierFrame.setSize(400, 300);
        addSupplierFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Nome do Fornecedor:"));
        JTextField supplierNameField = new JTextField();
        panel.add(supplierNameField);

        panel.add(new JLabel("Contato:"));
        JTextField contactField = new JTextField();
        panel.add(contactField);

        JButton saveButton = new JButton("Salvar");
        JButton backButton = new JButton("Voltar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);

        backButton.addActionListener(e -> addSupplierFrame.dispose());
        saveButton.addActionListener(e -> {
            // Lógica para salvar o fornecedor
            JOptionPane.showMessageDialog(addSupplierFrame, "Fornecedor salvo com sucesso!");
        });

        addSupplierFrame.add(panel, BorderLayout.CENTER);
        addSupplierFrame.add(buttonPanel, BorderLayout.SOUTH);
        addSupplierFrame.setVisible(true);
    }

    private void openListSuppliersWindow() {
        JFrame listSuppliersFrame = new JFrame("Fornecedores");
        listSuppliersFrame.setSize(400, 300);
        listSuppliersFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel suppliersLabel = new JLabel("Lista de fornecedores (exemplo)");
        panel.add(suppliersLabel);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> listSuppliersFrame.dispose());

        listSuppliersFrame.add(panel, BorderLayout.CENTER);
        listSuppliersFrame.add(backButton, BorderLayout.SOUTH);
        listSuppliersFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
