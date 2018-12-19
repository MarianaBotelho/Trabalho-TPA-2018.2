package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlClientes;

public class telaRemoverCliente {
    public static void telaRemoverCliente(){
        JFrame janelaRemoverCliente = new JFrame("Remover Cliente");
        janelaRemoverCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRemoverCliente = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelRemoverCliente = new JPanel(); //cria painel ao final da janela
        bottomPanelRemoverCliente.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelRemoverCliente.add(botaoSalvar); //add botao salvar
        bottomPanelRemoverCliente.add(botaoCancelar); //add botao cancelar
        janelaRemoverCliente.add(bottomPanelRemoverCliente, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRemoverCliente.setVisible(false);
            }
        });

        janelaRemoverCliente.setLocation(270, 90); //lugar onde a janela abre
        janelaRemoverCliente.setSize(800,600);
        janelaRemoverCliente.add(painelRemoverCliente);
        janelaRemoverCliente.setVisible(true);
        painelRemoverCliente.setLayout(new BoxLayout(painelRemoverCliente, BoxLayout.PAGE_AXIS));

        JLabel textoCpfC = new JLabel("Insira CPF:",JLabel. TRAILING); //cria texto
        JTextField jtfCpfC = new JTextField(20); //cria campo CpfC
        textoCpfC.setLabelFor(jtfCpfC);

        JLabel textoTipoC = new JLabel("Selecione o tipo de cliente:");
        String[] tipoC = {"Comprador", "Vendedor"};
        JComboBox tipoCliente = new JComboBox(tipoC);

        painelRemoverCliente.add(textoCpfC);
        painelRemoverCliente.add(jtfCpfC);
        painelRemoverCliente.add(textoTipoC);
        painelRemoverCliente.add(tipoCliente);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfC = jtfCpfC.getText();
                int tipoC = tipoCliente.getSelectedIndex();

                if(controlClientes.removerCliente(cpfC, tipoC) == true)
                    confirmaRemocaoCliente(janelaRemoverCliente);
                else
                    unsuccessfulRemocaoCliente();

                /*ArrayList<Comprador> ListaC = controle.getClienteComprador();
                for(Cliente cli : ListaC)
                    System.out.println(cli.getTipo());*/

            }
        });

    }

    private static void confirmaRemocaoCliente(JFrame janelaRemoverCliente){
        JFrame janelaConfirmaRemocaoCliente = new JFrame("Cliente Removido");
        janelaConfirmaRemocaoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaRemocaoCliente = new JPanel();
        janelaConfirmaRemocaoCliente.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaRemocaoCliente.setSize(300,100);
        janelaConfirmaRemocaoCliente.add(painelConfirmaRemocaoCliente);
        janelaConfirmaRemocaoCliente.setVisible(true);

        JLabel textoConfirmaRemocaoCliente = new JLabel("Cliente Removido com Sucesso!",JLabel. TRAILING);
        painelConfirmaRemocaoCliente.add(textoConfirmaRemocaoCliente);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaRemocaoCliente.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaRemocaoCliente.setVisible(false);
                janelaRemoverCliente.setVisible(false);
            }
        });
    }

    private static void unsuccessfulRemocaoCliente(){
        JFrame janelaUnsuccessfulRemocaoCliente = new JFrame("Cliente Não Removido");
        janelaUnsuccessfulRemocaoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelUnsuccessfulRemocaoCliente = new JPanel();
        janelaUnsuccessfulRemocaoCliente.setLocation(300, 100); //lugar onde a janela abre
        janelaUnsuccessfulRemocaoCliente.setSize(300,130);
        janelaUnsuccessfulRemocaoCliente.add(painelUnsuccessfulRemocaoCliente);
        janelaUnsuccessfulRemocaoCliente.setVisible(true);

        JLabel textoUnsuccessfulRemocaoCliente1 = new JLabel("Cliente Não Encotnrado!",JLabel. TRAILING);
        JLabel textoUnsuccessfulRemocaoCliente2 = new JLabel("Verifique o CPF digitado e/ou Tipo!",JLabel. TRAILING);
        painelUnsuccessfulRemocaoCliente.add(textoUnsuccessfulRemocaoCliente1);
        painelUnsuccessfulRemocaoCliente.add(textoUnsuccessfulRemocaoCliente2);

        JButton botaoConfirma = new JButton("Confirma");
        painelUnsuccessfulRemocaoCliente.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaUnsuccessfulRemocaoCliente.setVisible(false);
            }
        });
    }
}
