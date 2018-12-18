package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlClientes;
import imobiliaria.model.Cliente;

public class telaAlterarCliente {
    public static void telaInserirCPF(){
        JFrame janelaInserirCPF = new JFrame("Alterar Cliente");
        janelaInserirCPF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelInserirCPF = new JPanel();

        JButton botaoBuscar = new JButton("Buscar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoBuscar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar
        janelaInserirCPF.add(bottomPanelAlterar, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInserirCPF.setVisible(false);
            }
        });

        janelaInserirCPF.setLocation(270, 90); //lugar onde a janela abre
        janelaInserirCPF.setSize(800,600);
        janelaInserirCPF.add(painelInserirCPF);
        janelaInserirCPF.setVisible(true);
        //janelaInserirCPF.setLayout(new BoxLayout(janelaInserirCPF, BoxLayout.PAGE_AXIS));

        JLabel textoCpfC = new JLabel("Insira CPF:",JLabel. TRAILING); //cria texto
        JTextField jtfCpfC = new JTextField(20); //cria campo CpfC
        textoCpfC.setLabelFor(jtfCpfC);

        JLabel textoTipoC = new JLabel("Selecione o tipo de cliente:");
        String[] tipoC = {"Comprador", "Vendedor"};
        JComboBox tipoCliente = new JComboBox(tipoC);

        painelInserirCPF.add(textoCpfC);
        painelInserirCPF.add(jtfCpfC);
        painelInserirCPF.add(textoTipoC);
        painelInserirCPF.add(tipoCliente);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfC = jtfCpfC.getText();
                int tipoC = tipoCliente.getSelectedIndex();

                Cliente cliCPF = controlClientes.getClienteFromCPF(cpfC, tipoC);
                if(cliCPF == null){
                    cpfClienteInvalido();
                } else {
                    janelaInserirCPF.setVisible(false);
                    telaAlterarCliente(cliCPF);
                }
            }
        });

    }

    private static void telaAlterarCliente(Cliente cliCPF){
        JFrame janelaAlterarCliente = new JFrame("Alterar Cliente");
        janelaAlterarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelAlterarCliente = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoSalvar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar


        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlterarCliente.setVisible(false);
            }
        });

        painelAlterarCliente.setLayout(new BoxLayout(painelAlterarCliente, BoxLayout.PAGE_AXIS));
        janelaAlterarCliente.setLocation(270, 90);
        janelaAlterarCliente.setSize(800,600);
        janelaAlterarCliente.add(painelAlterarCliente);
        janelaAlterarCliente.setVisible(true);
        janelaAlterarCliente.add(bottomPanelAlterar, BorderLayout.SOUTH);

        JLabel textoCpfC = new JLabel("CPF: " + cliCPF.getCpf(), JLabel. TRAILING);

        JLabel textoNomeC = new JLabel("Nome: " + cliCPF.getNome(), JLabel. TRAILING);

        String conteudoTipoC;
        if(cliCPF.getTipo() == 1)
            conteudoTipoC = "Vendedor";
        else
            conteudoTipoC = "Comprador";
        JLabel textoTipoC = new JLabel("Tipo de cliente: " + conteudoTipoC, JLabel.TRAILING);

        JLabel textoEmailC = new JLabel("Email:",JLabel. TRAILING);
        JTextField jtfEmailC = new JTextField(cliCPF.getEmail(), 20);
        textoEmailC.setLabelFor(jtfEmailC);

        JLabel textoEnderC = new JLabel("Endereco:",JLabel. TRAILING);
        JTextField jtfEnderC = new JTextField(cliCPF.getEndereco(), 20);
        textoEnderC.setLabelFor(jtfEnderC);

        JLabel textoTelC = new JLabel("Telefone:",JLabel. TRAILING);
        JTextField jtfTelC = new JTextField(cliCPF.getTelefone(), 20);
        textoTelC.setLabelFor(jtfTelC);

        painelAlterarCliente.add(textoCpfC);
        painelAlterarCliente.add(textoNomeC);
        painelAlterarCliente.add(textoTipoC);
        painelAlterarCliente.add(textoEmailC);
        painelAlterarCliente.add(jtfEmailC);
        painelAlterarCliente.add(textoEnderC);
        painelAlterarCliente.add(jtfEnderC);
        painelAlterarCliente.add(textoTelC);
        painelAlterarCliente.add(jtfTelC);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailC = jtfEmailC.getText();
                String enderecoC = jtfEnderC.getText();
                String telefoneC = jtfTelC.getText();

                controlClientes.alterarCliente(cliCPF.getCpf(), emailC, enderecoC, telefoneC, cliCPF.getTipo());

                confirmaAlteracaoCliente(janelaAlterarCliente);
            }
        });
    }

    private static void confirmaAlteracaoCliente(JFrame janelaAlterarCliente){
        JFrame janelaConfirmaAlteracaoCliente = new JFrame("Cliente Alterado");
        janelaConfirmaAlteracaoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaAlteracaoCliente = new JPanel();
        janelaConfirmaAlteracaoCliente.setLocation(300, 100);
        janelaConfirmaAlteracaoCliente.setSize(300,100);
        janelaConfirmaAlteracaoCliente.add(painelConfirmaAlteracaoCliente);
        janelaConfirmaAlteracaoCliente.setVisible(true);

        JLabel textoConfirmaAlteracaoCliente = new JLabel("Cliente Alterado com Sucesso!",JLabel. TRAILING);
        painelConfirmaAlteracaoCliente.add(textoConfirmaAlteracaoCliente);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaAlteracaoCliente.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaAlteracaoCliente.setVisible(false);
                janelaAlterarCliente.setVisible(false);
            }
        });
    }

    private static void cpfClienteInvalido(){
        JFrame janelaCpfClienteInvalido = new JFrame("Cliente Não Encontrado");
        janelaCpfClienteInvalido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCpfClienteInvalido = new JPanel();
        janelaCpfClienteInvalido.setLocation(300, 100); //lugar onde a janela abre
        janelaCpfClienteInvalido.setSize(300,130);
        janelaCpfClienteInvalido.add(painelCpfClienteInvalido);
        janelaCpfClienteInvalido.setVisible(true);

        JLabel textoCpfClienteInvalido1 = new JLabel("Cliente Não Encotnrado!",JLabel. TRAILING);
        JLabel textoCpfClienteInvalido2 = new JLabel("Verifique o CPF digitado e/ou Tipo!",JLabel. TRAILING);
        painelCpfClienteInvalido.add(textoCpfClienteInvalido1);
        painelCpfClienteInvalido.add(textoCpfClienteInvalido2);

        JButton botaoConfirma = new JButton("Confirma");
        painelCpfClienteInvalido.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCpfClienteInvalido.setVisible(false);
            }
        });
    }
}
