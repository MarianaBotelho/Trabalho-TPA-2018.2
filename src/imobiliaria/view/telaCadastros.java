package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaCadastros {
    public static void telaCadastros(){
        JFrame janelaCadastros = new JFrame("Cadastros");
        janelaCadastros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCadastros = new JPanel();

        //Botoes Cliente
        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente"); //cria botao
        painelCadastros.add(botaoCadastrarCliente);
        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaIncluirCliente.telaIncluirCliente();
            }
        });

        JButton botaoRemoverCliente = new JButton("Remover Cliente"); //cria botao
        painelCadastros.add(botaoRemoverCliente);
        botaoRemoverCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRemoverCliente.telaRemoverCliente();
            }
        });

        JButton botaoAlterarCliente = new JButton("Alterar Cliente"); //cria botao
        painelCadastros.add(botaoAlterarCliente);
        botaoAlterarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAlterarCliente.telaInserirCPF();
            }
        });


        //Botoes Funcionario
        JButton botaoCadastrarFuncionario = new JButton("Cadastrar Funcionario"); //cria botao
        painelCadastros.add(botaoCadastrarFuncionario);
        botaoCadastrarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaIncluirFuncionario.telaIncluirFuncionario();
            }
        });

        JButton botaoRemoverFuncionario = new JButton("Remover Funcionario"); //cria botao
        painelCadastros.add(botaoRemoverFuncionario);
        botaoRemoverFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRemoverFuncionario.telaRemoverFuncionario();
            }
        });

        JButton botaoAlterarFuncionario = new JButton("Alterar Funcionario"); //cria botao
        painelCadastros.add(botaoAlterarFuncionario);
        botaoAlterarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAlterarFuncionario.telaInserirMatricula();
            }
        });

        //Botoes Imoveis
        JButton botaoCadastrarImovel = new JButton("Cadastrar Imovel"); //cria botao
        painelCadastros.add(botaoCadastrarImovel);
        botaoCadastrarImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaIncluirImovel.telaIncluirImovel();
            }
        });

        JButton botaoRemoverImovel = new JButton("Remover Imovel"); //cria botao
        painelCadastros.add(botaoRemoverImovel);
        botaoRemoverImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRemoverImovel.telaRemoverImovel();
            }
        });

        JButton botaoAlterarImovel = new JButton("Alterar Imovel"); //cria botao
        painelCadastros.add(botaoAlterarImovel);
        botaoAlterarImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAlterarImovel.telaInserirCodigo();
            }
        });

        //cria e coloca um botao Voltar no final da tela
        JButton botaoVoltar = new JButton("Voltar"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoVoltar); //add botao
        janelaCadastros.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastros.setVisible(false);
            }
        });


        janelaCadastros.add(painelCadastros);
        janelaCadastros.setLocation(270, 90); //lugar onde a janela abre
        janelaCadastros.setSize(800,600); //tamanho da janela
        janelaCadastros.setVisible(true); //mostra janela
    }
}
