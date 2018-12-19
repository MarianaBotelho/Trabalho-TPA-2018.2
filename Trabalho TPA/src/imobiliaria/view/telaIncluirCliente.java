package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlClientes;

public class telaIncluirCliente {
    public static void telaIncluirCliente(){
        JFrame janelaCadastrarCliente = new JFrame("Cadastrar Cliente");
        janelaCadastrarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCadastrarCliente = new JPanel();

        JButton botaoSalvaCliente = new JButton("Salvar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelCadastrarCliente = new JPanel(); //cria painel ao final da janela
        bottomPanelCadastrarCliente.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelCadastrarCliente.add(botaoSalvaCliente); //add botao salvar
        bottomPanelCadastrarCliente.add(botaoCancelar); //add botao cancelar
        janelaCadastrarCliente.add(bottomPanelCadastrarCliente, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastrarCliente.setVisible(false);
            }
        });

        janelaCadastrarCliente.setLocation(270, 90); //lugar onde a janela abre
        janelaCadastrarCliente.setSize(800,600);
        janelaCadastrarCliente.add(painelCadastrarCliente);
        janelaCadastrarCliente.setVisible(true);
        painelCadastrarCliente.setLayout(new BoxLayout(painelCadastrarCliente, BoxLayout.PAGE_AXIS));

        JLabel textoCpfC = new JLabel("Insira CPF:",JLabel. TRAILING); //cria texto
        JTextField jtfCpfC = new JTextField(20); //cria campo CpfC
        textoCpfC.setLabelFor(jtfCpfC);

        JLabel textoEmailC = new JLabel("Insira email:",JLabel. TRAILING); //cria texto
        JTextField jtfEmailC = new JTextField(20); //cria campo EmailC
        textoEmailC.setLabelFor(jtfEmailC);

        JLabel textoNomeC = new JLabel("Insira nome:",JLabel. TRAILING); //cria texto
        JTextField jtfNomeC = new JTextField(20); //cria campo NomeC
        textoNomeC.setLabelFor(jtfNomeC);

        JLabel textoEnderC = new JLabel("Insira endereco:",JLabel. TRAILING); //cria texto
        JTextField jtfEnderC = new JTextField(20); //cria campo EnderC
        textoEnderC.setLabelFor(jtfEnderC);

        JLabel textoTelC = new JLabel("Insira telefone:",JLabel. TRAILING); //cria texto
        JTextField jtfTelC = new JTextField(20); //cria campo TelC
        textoTelC.setLabelFor(jtfTelC);

        JLabel textoTipoC = new JLabel("Selecione o tipo de cliente:");
        String[] tipoC = {"Comprador", "Vendedor"};
        JComboBox tipoCliente = new JComboBox(tipoC);

        painelCadastrarCliente.add(textoCpfC);
        painelCadastrarCliente.add(jtfCpfC);
        painelCadastrarCliente.add(textoEmailC);
        painelCadastrarCliente.add(jtfEmailC);
        painelCadastrarCliente.add(textoNomeC);
        painelCadastrarCliente.add(jtfNomeC);
        painelCadastrarCliente.add(textoEnderC);
        painelCadastrarCliente.add(jtfEnderC);
        painelCadastrarCliente.add(textoTelC);
        painelCadastrarCliente.add(jtfTelC);
        painelCadastrarCliente.add(textoTipoC);
        painelCadastrarCliente.add(tipoCliente);

        botaoSalvaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfC = jtfCpfC.getText();
                String emailC = jtfEmailC.getText();
                String nomeC = jtfNomeC.getText();
                String enderecoC = jtfEnderC.getText();
                String telefoneC = jtfTelC.getText();
                int tipoC = tipoCliente.getSelectedIndex();

                controlClientes.cadastrarCliente(cpfC, emailC, nomeC, enderecoC, telefoneC, tipoC);

                /*ArrayList<Comprador> ListaC = controle.getClienteComprador();
                for(Cliente cli : ListaC)
                    System.out.println(cli.getTipo());*/

                confirmaCadastroCliente(janelaCadastrarCliente);
            }
        });
    }

    private static void confirmaCadastroCliente(JFrame janelaCadastrarCliente){
        JFrame janelaConfirmaCadastroCliente = new JFrame("Cliente Cadastrado");
        janelaConfirmaCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaCadastroCliente = new JPanel();
        janelaConfirmaCadastroCliente.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaCadastroCliente.setSize(300,100);
        janelaConfirmaCadastroCliente.add(painelConfirmaCadastroCliente);
        janelaConfirmaCadastroCliente.setVisible(true);

        JLabel textoConfirmaCadastroCliente = new JLabel("Cliente Cadastrado com Sucesso!",JLabel. TRAILING);
        painelConfirmaCadastroCliente.add(textoConfirmaCadastroCliente);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaCadastroCliente.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaCadastroCliente.setVisible(false);
                janelaCadastrarCliente.setVisible(false);
            }
        });
    }
}
