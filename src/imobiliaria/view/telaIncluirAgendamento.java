package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import imobiliaria.model.Cliente;
import imobiliaria.model.Funcionario;
import imobiliaria.model.Imovel;
import imobiliaria.model.Comprador;
import imobiliaria.control.controlClientes;
import imobiliaria.control.controlImoveis;
import imobiliaria.control.controlCorretor;
import imobiliaria.control.controlAgendamento;

public class telaIncluirAgendamento {
    public static void telaIncluirAgendamento(){
        JFrame janelaIncluirAgendamento = new JFrame("Incluir Agendamento");
        janelaIncluirAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelIncluirAgendamento = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoSalvar); //add botao salvar
        bottomPanel.add(botaoCancelar); //add botao cancelar
        janelaIncluirAgendamento.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaIncluirAgendamento.setVisible(false);
            }
        });


        //lista de imoveis cadastrados
        JLabel textoImovelAgendar = new JLabel("Selecione o imovel:");
        ArrayList<Imovel> listaIm = controlImoveis.getImovel();
        ArrayList<String> imoveis = new ArrayList<String>();
        for(Imovel im : listaIm)
            imoveis.add(im.getCodigo());
        String[] Imov = imoveis.toArray(new String[0]);
        //System.out.println(Imov);
        JComboBox Imovel = new JComboBox(Imov);

        //lista de funcionarios
        JLabel textoCorretorResp = new JLabel("Selecione o corretor responsavel:");
        ArrayList<Funcionario> listaF = controlCorretor.getCorretor();
        ArrayList<String> corretores = new ArrayList<String>();
        for(Funcionario func : listaF)
            corretores.add(func.getNome());
        String[] corretorResp = corretores.toArray(new String[0]);
        //System.out.println(corretorResp);
        JComboBox corretorResponsavel = new JComboBox(corretorResp);

        //lista de clientes
        JLabel textoClienteInt = new JLabel("Selecione o cliente interessado:");
        ArrayList<Comprador> listaC = controlClientes.getClienteComprador();
        ArrayList<String> compradores = new ArrayList<String>();
        for(Comprador comp : listaC)
            compradores.add(comp.getNome());
        String[] clienteInter = corretores.toArray(new String[0]);
        //System.out.println(clienteInter);
        JComboBox clienteInteressado = new JComboBox(clienteInter);

        JLabel textoGasto = new JLabel("Insira gastos:",JLabel. TRAILING); //cria texto
        JTextField jtfGasto = new JTextField(20); //cria campo Gastos
        textoGasto.setLabelFor(jtfGasto);

        JLabel textoData = new JLabel("Insira data (YYYY-MM-DD):", JLabel.TRAILING);
        JTextField jtfData = new JTextField(20);
        textoData.setLabelFor(jtfData);

        painelIncluirAgendamento.add(textoImovelAgendar);
        painelIncluirAgendamento.add(Imovel);
        painelIncluirAgendamento.add(textoCorretorResp);
        painelIncluirAgendamento.add(corretorResponsavel);
        painelIncluirAgendamento.add(textoClienteInt);
        painelIncluirAgendamento.add(clienteInteressado);
        painelIncluirAgendamento.add(textoGasto);
        painelIncluirAgendamento.add(jtfGasto);
        painelIncluirAgendamento.add(textoData);
        painelIncluirAgendamento.add(jtfData);

        janelaIncluirAgendamento.add(painelIncluirAgendamento);
        janelaIncluirAgendamento.setLocation(270, 90); //lugar onde a janela abre
        janelaIncluirAgendamento.setSize(800,600); //tamanho da janela
        janelaIncluirAgendamento.setVisible(true); //mostra janela

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float gastoV = Float.parseFloat(jtfGasto.getText());
                String dataV = jtfData.getText();
                String clienteC = clienteInteressado.getSelectedItem().toString();
                String imovelI = Imovel.getSelectedItem().toString();
                String corretorR = corretorResponsavel.getSelectedItem().toString();

                LocalDate dataVisita = LocalDate.parse(dataV);

                Imovel im = null;
                for (Imovel i : controlImoveis.getImovel()) {
                    if (i.getCodigo().equals(imovelI)) {
                        im = i;
                        break;
                    }
                }

                Comprador com = null;
                for (Comprador c : controlClientes.getClienteComprador()) {
                    if (c.getNome().equals(clienteC)) {
                        com = c;
                        break;
                    }
                }

                Funcionario fun = null;
                for (Funcionario f : controlCorretor.getCorretor()) {
                    if (f.getNome().equals(corretorR)) {
                        fun = f;
                        break;
                    }
                }

                controlAgendamento.agendarVisita(im, fun, com, gastoV, dataVisita);
            }
        });
    }
}
