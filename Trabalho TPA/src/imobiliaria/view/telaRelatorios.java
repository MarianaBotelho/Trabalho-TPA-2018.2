package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import imobiliaria.control.controlRelatorio;

public class telaRelatorios{
    private static String[] meses = {"Janeiro", "Fevereiro","Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro","Outubro", "Novembro", "Dezembro", "Anual"};
    private static String[] anos = {"2017","2018","2019"};
    private static int indiceRelatorio = -1;
    
    public static void exibirRelatorios(){
        JFrame janelaRelatorios = new JFrame("Visualizar");
        janelaRelatorios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRelatorios = new JPanel();

        JComboBox selecionarAno = new JComboBox(anos);
        JLabel labelAno = new JLabel("Escolha o ano do Relatorio ");
        labelAno.setLabelFor(selecionarAno);

        JComboBox selecionarMes = new JComboBox(meses);
        JLabel labelData = new JLabel("Escolha o periodo do Relatorio ");
        labelData.setLabelFor(selecionarMes); 

        JButton botaoGerar = new JButton("Gerar");

        painelRelatorios.add(labelAno);
        painelRelatorios.add(selecionarAno);
        painelRelatorios.add(labelData);
        painelRelatorios.add(selecionarMes);

        botaoGerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(selecionarMes.getSelectedIndex()){
                    case 0:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),1,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),1,31));
                        break;
                    case 1:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),2,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),2,28));
                        break;
                    case 2:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),3,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),3,31));
                        break;
                    case 3:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),4,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),4,30));
                        break;
                    case 4:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),5,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),5,31));
                        break;
                    case 5:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),6,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),6,30));
                        break;
                    case 6:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),7,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),7,31));
                        break;
                    case 7:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),8,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),8,31));
                        break;
                    case 8:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),9,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),9,30));
                        break;
                    case 9:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),10,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),10,31));
                        break;
                    case 10:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),11,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),11,30));
                        break;
                    case 11:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),12,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),12,31));
                        break;
                    case 12:
                        controlRelatorio.setRelatorioBetween(LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),1,1), LocalDate.of(Integer.parseInt(selecionarAno.getSelectedItem().toString()),12,31));
                        break;
                }
                indiceRelatorio++;
                telaExibeRelatorio.telaExibirRelatorio(indiceRelatorio);
            }
        });

        //cria e coloca um botao Voltar no final da tela
        JButton botaoVoltar = new JButton("Voltar"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoVoltar); //add botao
        bottomPanel.add(botaoGerar);
        janelaRelatorios.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRelatorios.setVisible(false);
            }
        });

        janelaRelatorios.add(painelRelatorios);
        janelaRelatorios.setLocation(270, 90); //lugar onde a janela abre
        janelaRelatorios.setSize(800,600); //tamanho da janela
        janelaRelatorios.setVisible(true); //mostra janela
    }
}