package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlImoveis;

public class telaVisualizarImoveis {
    public static void telaVisualizarImoveis(){
        JFrame janelaVisualizar = new JFrame("Visualizar");
        janelaVisualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBounds(5, 5, 100, 200);
        JScrollPane scrollPane = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(3,3,780,500);
        janelaVisualizar.add(scrollPane, BorderLayout.CENTER);

        for(int i=0; i<controlImoveis.getImovel().size(); i++) {
            areaTexto.append(" Codigo: " + controlImoveis.getCodigoFromIndice(i)
                    + " Nome Proprietario: " + controlImoveis.getNomeProprietarioFromIndice(i)
                    + " Endereco: " + controlImoveis.getEnderecoFromIndice(i)
                    + " Tipo: " + controlImoveis.getTipoFromIndice(i)
                    + " Quantidade de Quartos: " + controlImoveis.getQntQuartosFromIndice(i)
                    + " Preco Inicial: R$" + controlImoveis.getPrecoInicialFromIndice(i)
                    + " Preco Final: R$" + controlImoveis.getPrecoFinalFromIndice(i)
                    + " Status: " + controlImoveis.getStatusFromIndice(i)
                    + " Data de Venda: " + controlImoveis.getDataVendaFromIndice(i)
                    + " \n");
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
