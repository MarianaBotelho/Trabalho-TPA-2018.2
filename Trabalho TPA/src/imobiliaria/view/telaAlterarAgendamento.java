package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import imobiliaria.control.controlAgendamento;

public class telaAlterarAgendamento {
    public static void telaInserirCPFInserirCodigoImovel(){
        JFrame janelaInserirCPFInserirCodigoImovel = new JFrame("Alterar Visita");
        janelaInserirCPFInserirCodigoImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelInserirCPFInserirCodigoImovel = new JPanel();

        JButton botaoBuscar = new JButton("Buscar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoBuscar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar
        janelaInserirCPFInserirCodigoImovel.add(bottomPanelAlterar, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInserirCPFInserirCodigoImovel.setVisible(false);
            }
        });

        janelaInserirCPFInserirCodigoImovel.setLocation(270, 90); //lugar onde a janela abre
        janelaInserirCPFInserirCodigoImovel.setSize(800,600);
        janelaInserirCPFInserirCodigoImovel.add(painelInserirCPFInserirCodigoImovel);
        janelaInserirCPFInserirCodigoImovel.setVisible(true);

        JLabel textoCodigoImovel = new JLabel("Insira Codigo do Imovel:",JLabel. TRAILING);
        JTextField campoCodigoImovel = new JTextField(20);
        textoCodigoImovel.setLabelFor(campoCodigoImovel);

        JLabel textoCpfCliente = new JLabel("Insira CPF:",JLabel. TRAILING);
        JTextField campoCpfCliente = new JTextField(20);
        textoCpfCliente.setLabelFor(campoCpfCliente);

        painelInserirCPFInserirCodigoImovel.add(textoCodigoImovel);
        painelInserirCPFInserirCodigoImovel.add(campoCodigoImovel);
        painelInserirCPFInserirCodigoImovel.add(textoCpfCliente);
        painelInserirCPFInserirCodigoImovel.add(campoCpfCliente);


        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfC = campoCpfCliente.getText();
                String codigoI = campoCodigoImovel.getText();

                if(!controlAgendamento.agendamentoExiste(codigoI, cpfC)){
                    cpfInvalidoCodigoInvalido();
                } else {
                    janelaInserirCPFInserirCodigoImovel.setVisible(false);
                    telaAlterarAgendamento(codigoI, cpfC);
                }
            }
        });

    }

    private static void telaAlterarAgendamento(String codigoImovel, String cpfCliente){
        JFrame janelaAlterarAgendamento = new JFrame("Alterar Agendamento");
        janelaAlterarAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelAlterarAgendamento = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoSalvar); //add botao salvar
        bottomPanel.add(botaoCancelar); //add botao cancelar
        janelaAlterarAgendamento.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlterarAgendamento.setVisible(false);
            }
        });

        JLabel textoCpfCliente = new JLabel("CPF Cliente: " + cpfCliente, JLabel.TRAILING);
        JLabel textoCodigoImovel = new JLabel("Codigo Imovel: " + codigoImovel, JLabel.TRAILING);
        JLabel textoCorretorResponsavel = new JLabel("Corretor Responsavel: " + controlAgendamento.getNomeFuncionario(codigoImovel, cpfCliente), JLabel.TRAILING);

        JLabel textoGasto = new JLabel("Gastos:",JLabel. TRAILING);
        JTextField campoGasto = new JTextField(Float.toString(controlAgendamento.getGastoVisita(codigoImovel, cpfCliente)), 20); //cria campo Gastos
        textoGasto.setLabelFor(campoGasto);

        JLabel textoData = new JLabel("Insira data (YYYY-MM-DD):", JLabel.TRAILING);
        JTextField campoData = new JTextField(controlAgendamento.getDataVisita(codigoImovel, cpfCliente).toString(), 20);
        textoData.setLabelFor(campoData);

        painelAlterarAgendamento.add(textoCpfCliente);
        painelAlterarAgendamento.add(textoCodigoImovel);
        painelAlterarAgendamento.add(textoCorretorResponsavel);
        painelAlterarAgendamento.add(textoGasto);
        painelAlterarAgendamento.add(campoGasto);
        painelAlterarAgendamento.add(textoData);
        painelAlterarAgendamento.add(campoData);

        janelaAlterarAgendamento.add(painelAlterarAgendamento);
        janelaAlterarAgendamento.setLocation(270, 90); //lugar onde a janela abre
        janelaAlterarAgendamento.setSize(800,600); //tamanho da janela
        janelaAlterarAgendamento.setVisible(true); //mostra janela

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float gastoV = Float.parseFloat(campoGasto.getText());
                String dataV = campoData.getText();
                LocalDate dataVisita = LocalDate.parse(dataV);

                controlAgendamento.alterarVisita(codigoImovel, cpfCliente, gastoV, dataVisita);
                confirmaAlterarAgendamento(janelaAlterarAgendamento);
            }
        });
    }

    private static void confirmaAlterarAgendamento(JFrame janelaAlterarAgendamento){
        JFrame janelaConfirmaAlterarAgendamento = new JFrame("Visita Alterada");
        janelaConfirmaAlterarAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaAlterarAgendamento = new JPanel();
        janelaConfirmaAlterarAgendamento.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaAlterarAgendamento.setSize(300,100);
        janelaConfirmaAlterarAgendamento.add(painelConfirmaAlterarAgendamento);
        janelaConfirmaAlterarAgendamento.setVisible(true);

        JLabel textoConfirmaAlterarAgendamento = new JLabel("Visita Alterada com Sucesso!",JLabel. TRAILING);
        painelConfirmaAlterarAgendamento.add(textoConfirmaAlterarAgendamento);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaAlterarAgendamento.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaAlterarAgendamento.setVisible(false);
                janelaAlterarAgendamento.setVisible(false);
            }
        });
    }

    private static void cpfInvalidoCodigoInvalido(){
        JFrame janelaUnsuccessfulAlterarAgendamento = new JFrame("Agendamento Não Encontrado");
        janelaUnsuccessfulAlterarAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelUnsuccessfulAlterarAgendamento = new JPanel();
        janelaUnsuccessfulAlterarAgendamento.setLocation(300, 100); //lugar onde a janela abre
        janelaUnsuccessfulAlterarAgendamento.setSize(300,130);
        janelaUnsuccessfulAlterarAgendamento.add(painelUnsuccessfulAlterarAgendamento);
        janelaUnsuccessfulAlterarAgendamento.setVisible(true);

        JLabel textoUnsuccessfulAlterarAgendamento1 = new JLabel("Visita Não Encontrada!",JLabel. TRAILING);
        JLabel textoUnsuccessfulAlterarAgendamento2 = new JLabel("Verifique os Dados digitados!",JLabel. TRAILING);
        painelUnsuccessfulAlterarAgendamento.add(textoUnsuccessfulAlterarAgendamento1);
        painelUnsuccessfulAlterarAgendamento.add(textoUnsuccessfulAlterarAgendamento2);

        JButton botaoConfirma = new JButton("Confirma");
        painelUnsuccessfulAlterarAgendamento.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaUnsuccessfulAlterarAgendamento.setVisible(false);
            }
        });
    }
}
