package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlImoveis;

public class telaRemoverImovel {
    public static void telaRemoverImovel(){
        JFrame janelaRemoverImovel = new JFrame("Remover Imovel");
        janelaRemoverImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRemoverImovel = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelRemoverImovel = new JPanel(); //cria painel ao final da janela
        bottomPanelRemoverImovel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelRemoverImovel.add(botaoSalvar); //add botao salvar
        bottomPanelRemoverImovel.add(botaoCancelar); //add botao cancelar
        janelaRemoverImovel.add(bottomPanelRemoverImovel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRemoverImovel.setVisible(false);
            }
        });

        janelaRemoverImovel.setLocation(270, 90); //lugar onde a janela abre
        janelaRemoverImovel.setSize(800,600);
        janelaRemoverImovel.add(painelRemoverImovel);
        janelaRemoverImovel.setVisible(true);
        painelRemoverImovel.setLayout(new BoxLayout(painelRemoverImovel, BoxLayout.PAGE_AXIS));

        JLabel textoCodigo = new JLabel("Insira Codigo:",JLabel. TRAILING); //cria texto
        JTextField jtfCodigo = new JTextField(20); //cria campo CpfC
        textoCodigo.setLabelFor(jtfCodigo);

        painelRemoverImovel.add(textoCodigo);
        painelRemoverImovel.add(jtfCodigo);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoI = jtfCodigo.getText();

                if(controlImoveis.removerImovel(codigoI) == true)
                    confirmaRemocaoImovel(janelaRemoverImovel);
                else
                    unsuccessfulRemocaoImovel();
            }
        });

    }

    private static void confirmaRemocaoImovel(JFrame janelaRemoverImovel){
        JFrame janelaConfirmaRemocaoImovel = new JFrame("Cliente Removido");
        janelaConfirmaRemocaoImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaRemocaoImovel = new JPanel();
        janelaConfirmaRemocaoImovel.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaRemocaoImovel.setSize(300,100);
        janelaConfirmaRemocaoImovel.add(painelConfirmaRemocaoImovel);
        janelaConfirmaRemocaoImovel.setVisible(true);

        JLabel textoConfirmaRemocaoImovel = new JLabel("Imovel Removido com Sucesso!",JLabel. TRAILING);
        painelConfirmaRemocaoImovel.add(textoConfirmaRemocaoImovel);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaRemocaoImovel.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaRemocaoImovel.setVisible(false);
                janelaRemoverImovel.setVisible(false);
            }
        });
    }

    private static void unsuccessfulRemocaoImovel(){
        JFrame janelaUnsuccessfulRemocaoImovel = new JFrame("Imovel Não Removido");
        janelaUnsuccessfulRemocaoImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelUnsuccessfulRemocaoImovel = new JPanel();
        janelaUnsuccessfulRemocaoImovel.setLocation(300, 100); //lugar onde a janela abre
        janelaUnsuccessfulRemocaoImovel.setSize(250,130);
        janelaUnsuccessfulRemocaoImovel.add(painelUnsuccessfulRemocaoImovel);
        janelaUnsuccessfulRemocaoImovel.setVisible(true);

        JLabel textoUnsuccessfulRemocaoImovel1 = new JLabel("Imove Não Encotnrado!",JLabel. TRAILING);
        JLabel textoUnsuccessfulRemocaoImovel2 = new JLabel("Verifique o Codigo digitado!",JLabel. TRAILING);
        painelUnsuccessfulRemocaoImovel.add(textoUnsuccessfulRemocaoImovel1);
        painelUnsuccessfulRemocaoImovel.add(textoUnsuccessfulRemocaoImovel2);

        JButton botaoConfirma = new JButton("Confirma");
        painelUnsuccessfulRemocaoImovel.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaUnsuccessfulRemocaoImovel.setVisible(false);
            }
        });
    }
}
