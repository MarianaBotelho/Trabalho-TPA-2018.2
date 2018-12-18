package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import imobiliaria.control.controlClientes;
import imobiliaria.model.Vendedor;
import imobiliaria.model.Comprador;

public class telaVisualizarClientes {
    public static void telaVisualizarClientes(){
        JFrame janelaVisualizar = new JFrame("Visualizar");
        janelaVisualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelVisualizar = new JPanel();

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        painelVisualizar.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Vendedor> listaVendedor = controlClientes.getClienteVendedor();
        ArrayList<Comprador> listaComprador = controlClientes.getClienteComprador();

        for(Vendedor v : listaVendedor){
            areaTexto.append("CPF: " + v.getCpf() + " Nome: " + v.getNome() + " Endereco: " + v.getEndereco() + " Telefone: " + v.getTelefone() + " Tipo: Vendedor\n");
        }
        for(Comprador c : listaComprador){
            areaTexto.append("CPF: " + c.getCpf() + " Nome: " + c.getNome() + " Endereco: " + c.getEndereco() + " Telefone: " + c.getTelefone() + " Tipo: Comprador\n");
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

        janelaVisualizar.add(painelVisualizar);
        janelaVisualizar.setLocation(270, 90); //lugar onde a janela abre
        janelaVisualizar.setSize(800,600); //tamanho da janela
        janelaVisualizar.setVisible(true); //mostra janela
    }
}
