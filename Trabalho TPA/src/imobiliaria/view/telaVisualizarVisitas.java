package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlAgendamento;
import imobiliaria.control.controlClientes;
import imobiliaria.control.controlCorretor;

public class telaVisualizarVisitas {
    public static void telaVisualizarVisitas() {
        JFrame janelaVisualizar = new JFrame("Visualizar");
        janelaVisualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBounds(5, 5, 100, 200);
        JScrollPane scrollPane = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(3, 3, 400, 400);
        janelaVisualizar.add(scrollPane, BorderLayout.CENTER);


        for(int i=1; i<=controlAgendamento.getCodigoVisitaTotal(); i++){
            areaTexto.append(" Codigo visita: " + i + " Codigo do Imovel: " + controlAgendamento.getCodigoImovelFromCodigoVisita(i)
                    + " Nome do Cliente: " + controlClientes.getClienteFromCPF(controlAgendamento.getCpfClienteFromCodigoVisita(i), 0).getNome()
                    + " Nome do Corretor Responsavel: " + controlCorretor.getNomeFuncionarioFromMatricula(controlAgendamento.getMatriculaCorretorFromCodigoVisita(i))
                    + " Gasto da visita: " + controlAgendamento.getGastoVisitaFromCodigoVisita(i)
                    + " Data Visita: " + controlAgendamento.getDataFromCodigoVisita(i).toString() + " \n");
        }


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

        janelaVisualizar.setLocation(270, 90); //lugar onde a janela abre
        janelaVisualizar.setSize(800,600); //tamanho da janela
        janelaVisualizar.setVisible(true); //mostra janela
    }
}
