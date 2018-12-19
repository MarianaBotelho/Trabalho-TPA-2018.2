package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaAgendamentos {
    public static void telaAgendamentos(){
        JFrame janelaAgendamentos = new JFrame("Agendamentos");
        janelaAgendamentos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelAgendamentos = new JPanel();

        JButton botaoAgendarVisita = new JButton("Agendar Visita"); //cria botao
        painelAgendamentos.add(botaoAgendarVisita);
        botaoAgendarVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaIncluirAgendamento.telaIncluirAgendamento();
            }
        });

        JButton botaoAlterarVisita = new JButton("Alterar Visita"); //cria botao
        painelAgendamentos.add(botaoAlterarVisita);
        botaoAlterarVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAlterarAgendamento.telaInserirCPFInserirCodigoImovel();
            }
        });

        JButton botaoCancelarVisita = new JButton("Cancelar Visita"); //cria botao
        painelAgendamentos.add(botaoCancelarVisita);
        botaoCancelarVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRemoverAgendamento.telaRemoverAgendamento();
            }
        });

        JButton botaoVisualizarVisita = new JButton("Visualizar Visita"); //cria botao
        painelAgendamentos.add(botaoVisualizarVisita);
        botaoVisualizarVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaVisualizarVisitas.telaVisualizarVisitas();
            }
        });

        //cria e coloca um botao Voltar no final da tela
        JButton botaoVoltar = new JButton("Voltar"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoVoltar); //add botao
        janelaAgendamentos.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAgendamentos.setVisible(false);
            }
        });


        janelaAgendamentos.add(painelAgendamentos);
        janelaAgendamentos.setLocation(270, 90); //lugar onde a janela abre
        janelaAgendamentos.setSize(800,600); //tamanho da janela
        janelaAgendamentos.setVisible(true); //mostra janela
    }
}
