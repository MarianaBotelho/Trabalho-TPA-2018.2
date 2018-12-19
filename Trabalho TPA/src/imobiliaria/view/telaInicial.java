package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaInicial {
    public static void telaInicial (){
        JFrame janelaInicial = new JFrame("Imobiliaria");
        janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painelBemVindo = new JPanel(); //cria painel Bem vindo
        painelBemVindo.add(new JLabel("Bem Vindo!")); //add ao painel
        janelaInicial.add(painelBemVindo);

        //cria e coloca um botao OK no final da tela
        JButton botaoSair = new JButton("Sair"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoSair); //add botao
        janelaInicial.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); //chama botao

        //botao Cadastrar
        JButton botaoCadastrar = new JButton("Cadastros"); //cria botao
        painelBemVindo.add(botaoCadastrar);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastros.telaCadastros();
            }
        });

        //botao Agendar
        JButton botaoAgendar = new JButton("Agendamentos"); //cria botao
        painelBemVindo.add(botaoAgendar);
        botaoAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAgendamentos.telaAgendamentos();
            }
        });

        //botao Registrar Venda
        JButton botaoRegistrarVenda = new JButton("Registrar Venda");
        painelBemVindo.add(botaoRegistrarVenda);
        botaoRegistrarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRegistrarVenda.telaInserirCodigo();
            }
        });

        //botao Relatorios
        JButton botaoRelatorios = new JButton("Relatorios"); //cria botao
        painelBemVindo.add(botaoRelatorios);
        botaoRelatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRelatorios.exibirRelatorios();
            }
        });

        //botao Visualizar
        JButton botaoVisualizarCadastros = new JButton("Visualizar Cadastros");
        painelBemVindo.add(botaoVisualizarCadastros);
        botaoVisualizarCadastros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizar.telaVisualizar();
            }
        });


        //Painel Inicial
        janelaInicial.setLocation(270, 90); //lugar onde a janela abre
        janelaInicial.setSize(800,600); //tamanho da janela
        janelaInicial.setVisible(true); //mostra janela
    }
}
