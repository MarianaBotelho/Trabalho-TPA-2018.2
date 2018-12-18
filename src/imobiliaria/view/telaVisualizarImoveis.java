package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import imobiliaria.control.controlImoveis;
import imobiliaria.model.Imovel;

public class telaVisualizarImoveis {
    public static void telaVisualizarImoveis(){
        JFrame janelaVisualizar = new JFrame("Visualizar");
        janelaVisualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setBounds(5, 5, 100, 200);
        JScrollPane scrollPane = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(3,3,400,400);
        janelaVisualizar.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Imovel> listaImoveis = controlImoveis.getImovel();

        for(Imovel i : listaImoveis){
            String tipo;
            String status;
            if(i.getTipo() == 0)
                tipo = "Casa";
            else if(i.getTipo() == 1)
                tipo = "Apartamento";
            else
                tipo = "Loja";

            if(i.getStatus() == true) {
                status = "Vendido";
                areaTexto.append(" Codigo: " + i.getCodigo() + " Nome Proprietario: " + i.getProprietario().getNome() + " Endereco: " + i.getEndereco() +
                        " Tipo: " + tipo + " Quantidade de Quartos: " + i.getQtdQuarto() + " Preco Inicial: R$" + i.getPrecoInicial() + " Preco Final: R$" +
                        i.getPrecoFinal() + " Status: " + status + " Data de Venda: " + i.getDataVenda() + " \n");
            } else {
                status = "Disponivel";
                areaTexto.append(" Codigo: " + i.getCodigo() + " Nome Proprietario: " + i.getProprietario().getNome() + " Endereco: " + i.getEndereco() +
                        " Tipo: " + tipo + " Quantidade de Quartos: " + i.getQtdQuarto() + " Preco Inicial: R$" + i.getPrecoInicial() + " Preco Final: R$" + i.getPrecoFinal() + " Status: " + status + " \n");
            }

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
