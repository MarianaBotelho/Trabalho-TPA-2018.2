package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlRelatorio;

public class telaExibeRelatorio {
    public static void telaExibirRelatorio(int indiceRelatorio){
        JFrame janelaExibirRelatorio = new JFrame("Visualizar");
        janelaExibirRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelExibirRelatorio = new JPanel();

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBounds(5, 5, 200, 200);
        JScrollPane scrollPane = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(3,3,780,500);
        janelaExibirRelatorio.add(scrollPane, BorderLayout.CENTER);

        areaTexto.append(" Data Inicial: " + controlRelatorio.getDataInicial(indiceRelatorio)
                        + " Data Final: " + controlRelatorio.getDataFinal(indiceRelatorio)
                        + " Total Arrecadado: " + controlRelatorio.getTotalArrecadado(indiceRelatorio)
                        + " Gastos: " + controlRelatorio.getGastosAnteriores(indiceRelatorio)
                        + " Gastos previstos: " + controlRelatorio.getGastosFuturos(indiceRelatorio) + " \n");


        //cria e coloca um botao Voltar no final da tela
        JButton botaoVoltar = new JButton("Voltar"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoVoltar); //add botao
        janelaExibirRelatorio.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaExibirRelatorio.setVisible(false);
            }
        });

        janelaExibirRelatorio.add(painelExibirRelatorio);
        janelaExibirRelatorio.setLocation(270, 90); //lugar onde a janela abre
        janelaExibirRelatorio.setSize(800,600); //tamanho da janela
        janelaExibirRelatorio.setVisible(true); //mostra janela

    }
}
