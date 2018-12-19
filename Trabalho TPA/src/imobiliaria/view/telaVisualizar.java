package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaVisualizar {
    public static void telaVisualizar(){
        JFrame janelaVisualizar = new JFrame("Visualizar");
        janelaVisualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelVisualizar = new JPanel();

        //Botao Cliente
        JButton botaoVisualizarCliente = new JButton("Visualizar Clientes"); //cria botao
        painelVisualizar.add(botaoVisualizarCliente);
        botaoVisualizarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarClientes.telaVisualizarClientes();
            }
        });

        //Botao Funcionarios
        JButton botaoVisualizarFuncionarios = new JButton("Visualizar Funcionarios"); //cria botao
        painelVisualizar.add(botaoVisualizarFuncionarios);
        botaoVisualizarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarFuncionarios.telaVisualizarFuncionarios();
            }
        });

        //Botao Imoveis
        JButton botaoVisualizarImoveis = new JButton("Visualizar Imoveis"); //cria botao
        painelVisualizar.add(botaoVisualizarImoveis);
        botaoVisualizarImoveis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarImoveis.telaVisualizarImoveis();
            }
        });

        //cria e coloca um botao Voltar no final da tela
        JButton botaoVoltar = new JButton("Voltar"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoVoltar); //add botao
        janelaVisualizar.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaVisualizar.setVisible(false);
            }
        });

        janelaVisualizar.add(painelVisualizar);
        janelaVisualizar.setLocation(270, 90); //lugar onde a janela abre
        janelaVisualizar.setSize(800,600); //tamanho da janela
        janelaVisualizar.setVisible(true); //mostra janela
    }
}
