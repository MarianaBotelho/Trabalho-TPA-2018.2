package imobiliaria.view;

import imobiliaria.control.controlAgendamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaRemoverAgendamento {
    public static void telaRemoverAgendamento(){
        JFrame janelaRemoverAgendamento = new JFrame("Remover Agendamento");
        janelaRemoverAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRemoverAgendamento = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoSalvar); //add botao salvar
        bottomPanel.add(botaoCancelar); //add botao cancelar
        janelaRemoverAgendamento.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRemoverAgendamento.setVisible(false);
            }
        });


        JLabel textoImovelRemover = new JLabel("Digite o codigo do imovel:");
        JTextField campoImovelRemover = new JTextField(20);
        textoImovelRemover.setLabelFor(campoImovelRemover);

        JLabel textoClienteRemover = new JLabel("Digite o cpf do cliente:");
        JTextField campoClienteRemover = new JTextField(20);
        textoClienteRemover.setLabelFor(campoClienteRemover);

        painelRemoverAgendamento.add(textoImovelRemover);
        painelRemoverAgendamento.add(campoImovelRemover);
        painelRemoverAgendamento.add(textoClienteRemover);
        painelRemoverAgendamento.add(campoClienteRemover);

        janelaRemoverAgendamento.add(painelRemoverAgendamento);
        janelaRemoverAgendamento.setLocation(270, 90); //lugar onde a janela abre
        janelaRemoverAgendamento.setSize(800,600); //tamanho da janela
        janelaRemoverAgendamento.setVisible(true); //mostra janela

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfCliente = campoClienteRemover.getText().toString();
                String codigoImovel = campoImovelRemover.getText().toString();

                if (controlAgendamento.removerVisita(codigoImovel, cpfCliente) == true)
                    confirmaRemocaoVisita(janelaRemoverAgendamento);
                else
                    unsuccessfulRemocaoVisita();
            }
        });
    }

    private static void confirmaRemocaoVisita(JFrame janelaRemoverVisita){
        JFrame janelaConfirmaRemocaoVisita = new JFrame("Visita Removida");
        janelaConfirmaRemocaoVisita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaRemocaoVisita = new JPanel();
        janelaConfirmaRemocaoVisita.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaRemocaoVisita.setSize(300,100);
        janelaConfirmaRemocaoVisita.add(painelConfirmaRemocaoVisita);
        janelaConfirmaRemocaoVisita.setVisible(true);

        JLabel textoConfirmaRemocaoVisita = new JLabel("Visita Removida com Sucesso!",JLabel. TRAILING);
        painelConfirmaRemocaoVisita.add(textoConfirmaRemocaoVisita);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaRemocaoVisita.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaRemocaoVisita.setVisible(false);
                janelaRemoverVisita.setVisible(false);
            }
        });
    }

    private static void unsuccessfulRemocaoVisita(){
        JFrame janelaUnsuccessfulRemocaoVisita = new JFrame("Visita Não Removida");
        janelaUnsuccessfulRemocaoVisita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelUnsuccessfulRemocaoVisita = new JPanel();
        janelaUnsuccessfulRemocaoVisita.setLocation(300, 100); //lugar onde a janela abre
        janelaUnsuccessfulRemocaoVisita.setSize(300,130);
        janelaUnsuccessfulRemocaoVisita.add(painelUnsuccessfulRemocaoVisita);
        janelaUnsuccessfulRemocaoVisita.setVisible(true);

        JLabel textoUnsuccessfulRemocaoVisita1 = new JLabel("Visita Não Encotnrada!",JLabel. TRAILING);
        JLabel textoUnsuccessfulRemocaoVisita2 = new JLabel("Verifique o Código e/ou CPF digitado!",JLabel. TRAILING);
        painelUnsuccessfulRemocaoVisita.add(textoUnsuccessfulRemocaoVisita1);
        painelUnsuccessfulRemocaoVisita.add(textoUnsuccessfulRemocaoVisita2);

        JButton botaoConfirma = new JButton("Confirma");
        painelUnsuccessfulRemocaoVisita.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaUnsuccessfulRemocaoVisita.setVisible(false);
            }
        });
    }
}
