package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlCorretor;

public class telaRemoverFuncionario {
    public static void telaRemoverFuncionario(){
        JFrame janelaRemoverFuncionario = new JFrame("Remover Funcionario");
        janelaRemoverFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRemoverFuncionario = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelRemoverFuncionario = new JPanel(); //cria painel ao final da janela
        bottomPanelRemoverFuncionario.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelRemoverFuncionario.add(botaoSalvar); //add botao salvar
        bottomPanelRemoverFuncionario.add(botaoCancelar); //add botao cancelar
        janelaRemoverFuncionario.add(bottomPanelRemoverFuncionario, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRemoverFuncionario.setVisible(false);
            }
        });

        janelaRemoverFuncionario.setLocation(270, 90); //lugar onde a janela abre
        janelaRemoverFuncionario.setSize(800,600);
        janelaRemoverFuncionario.add(painelRemoverFuncionario);
        janelaRemoverFuncionario.setVisible(true);
        painelRemoverFuncionario.setLayout(new BoxLayout(painelRemoverFuncionario, BoxLayout.PAGE_AXIS));

        JLabel textoMatricula = new JLabel("Insira Matricula:",JLabel. TRAILING); //cria texto
        JTextField jtfMatricula = new JTextField(20); //cria campo CpfC
        textoMatricula.setLabelFor(jtfMatricula);

        painelRemoverFuncionario.add(textoMatricula);
        painelRemoverFuncionario.add(jtfMatricula);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaF = jtfMatricula.getText();

                if(controlCorretor.removerFuncionario(matriculaF) == true)
                    confirmaRemocaoFuncionario(janelaRemoverFuncionario);
                else
                    unsuccessfulRemocaoFuncionario();
            }
        });

    }

    private static void confirmaRemocaoFuncionario(JFrame janelaRemoverFuncionario){
        JFrame janelaConfirmaRemocaoFuncionario = new JFrame("Cliente Removido");
        janelaConfirmaRemocaoFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaRemocaoFuncionario = new JPanel();
        janelaConfirmaRemocaoFuncionario.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaRemocaoFuncionario.setSize(300,100);
        janelaConfirmaRemocaoFuncionario.add(painelConfirmaRemocaoFuncionario);
        janelaConfirmaRemocaoFuncionario.setVisible(true);

        JLabel textoConfirmaRemocaoFuncionario = new JLabel("Funcionario Removido com Sucesso!",JLabel. TRAILING);
        painelConfirmaRemocaoFuncionario.add(textoConfirmaRemocaoFuncionario);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaRemocaoFuncionario.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaRemocaoFuncionario.setVisible(false);
                janelaRemoverFuncionario.setVisible(false);
            }
        });
    }

    private static void unsuccessfulRemocaoFuncionario(){
        JFrame janelaUnsuccessfulRemocaoFuncionario = new JFrame("Funcionario Não Removido");
        janelaUnsuccessfulRemocaoFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelUnsuccessfulRemocaoFuncionario = new JPanel();
        janelaUnsuccessfulRemocaoFuncionario.setLocation(300, 100); //lugar onde a janela abre
        janelaUnsuccessfulRemocaoFuncionario.setSize(250,130);
        janelaUnsuccessfulRemocaoFuncionario.add(painelUnsuccessfulRemocaoFuncionario);
        janelaUnsuccessfulRemocaoFuncionario.setVisible(true);

        JLabel textoUnsuccessfulRemocaoFuncionario1 = new JLabel("Funcionario Não Encotnrado!",JLabel. TRAILING);
        JLabel textoUnsuccessfulRemocaoFuncionario2 = new JLabel("Verifique a Matricula digitada!",JLabel. TRAILING);
        painelUnsuccessfulRemocaoFuncionario.add(textoUnsuccessfulRemocaoFuncionario1);
        painelUnsuccessfulRemocaoFuncionario.add(textoUnsuccessfulRemocaoFuncionario2);

        JButton botaoConfirma = new JButton("Confirma");
        painelUnsuccessfulRemocaoFuncionario.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaUnsuccessfulRemocaoFuncionario.setVisible(false);
            }
        });
    }
}
