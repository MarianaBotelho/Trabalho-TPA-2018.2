package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlImoveis;
import imobiliaria.model.Imovel;
import static java.lang.Float.parseFloat;

public class telaRegistrarVenda {
    public static void telaInserirCodigo(){
        JFrame janelaInserirCodigo = new JFrame("Registrar Venda");
        janelaInserirCodigo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelInserirCodigo = new JPanel();

        JButton botaoBuscar = new JButton("Buscar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoBuscar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar
        janelaInserirCodigo.add(bottomPanelAlterar, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInserirCodigo.setVisible(false);
            }
        });

        janelaInserirCodigo.setLocation(270, 90);
        janelaInserirCodigo.setSize(800,600);
        janelaInserirCodigo.add(painelInserirCodigo);
        janelaInserirCodigo.setVisible(true);
        //janelaInserirCodigo.setLayout(new BoxLayout(janelaInserirCodigo, BoxLayout.PAGE_AXIS));

        JLabel labelCodigoImovel = new JLabel("Insira Codigo:",JLabel. TRAILING);
        JTextField textoCodigoImovel = new JTextField(20);
        labelCodigoImovel.setLabelFor(textoCodigoImovel);

        painelInserirCodigo.add(labelCodigoImovel);
        painelInserirCodigo.add(textoCodigoImovel);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoI = textoCodigoImovel.getText();

                Imovel codigoImovel = controlImoveis.getImovelFromCodigo(codigoI);
                if(codigoImovel == null){
                    codigoImovelInvalido();
                } else if(codigoImovel.getStatus() == true) {
                    codigoImovelInvalido();
                } else {
                    janelaInserirCodigo.setVisible(false);
                    telaRegistrarVendaImovel(codigoImovel);
                }
            }
        });

    }

    private static void telaRegistrarVendaImovel(Imovel imovelCodigo){
        JFrame janelaRegistrarVendaImovel = new JFrame("Registrar Venda Imovel");
        janelaRegistrarVendaImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelRegistrarVendaImovel = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoSalvar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaRegistrarVendaImovel.setVisible(false);
            }
        });

        painelRegistrarVendaImovel.setLayout(new BoxLayout(painelRegistrarVendaImovel, BoxLayout.PAGE_AXIS));
        janelaRegistrarVendaImovel.setLocation(270, 90);
        janelaRegistrarVendaImovel.setSize(800,600);
        janelaRegistrarVendaImovel.add(painelRegistrarVendaImovel);
        janelaRegistrarVendaImovel.setVisible(true);
        janelaRegistrarVendaImovel.add(bottomPanelAlterar, BorderLayout.SOUTH);

        JLabel textoCodigoImovel = new JLabel("Codigo: " + imovelCodigo.getCodigo(), JLabel. TRAILING);

        JLabel textoNomePropImovel = new JLabel("Nome proprietario: " + imovelCodigo.getProprietario().getNome(), JLabel. TRAILING);

        JLabel textoEnderecoImovel = new JLabel("Endereco do Imovel: " + imovelCodigo.getEndereco(), JLabel.TRAILING);

        JLabel textoPrecoInicial = new JLabel("Preco Inicial:" + imovelCodigo.getPrecoInicial(), JLabel. TRAILING);

        JLabel textoPrecoFinal = new JLabel("Preco Final:", JLabel. TRAILING);
        JTextField jtfPrecoFinal = new JTextField(20);
        textoPrecoFinal.setLabelFor(jtfPrecoFinal);

        painelRegistrarVendaImovel.add(textoCodigoImovel);
        painelRegistrarVendaImovel.add(textoNomePropImovel);
        painelRegistrarVendaImovel.add(textoEnderecoImovel);
        painelRegistrarVendaImovel.add(textoPrecoInicial);
        painelRegistrarVendaImovel.add(textoPrecoFinal);
        painelRegistrarVendaImovel.add(jtfPrecoFinal);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float precoFinalI = parseFloat(jtfPrecoFinal.getText());

                if(controlImoveis.finalizarVendaImovel(imovelCodigo.getCodigo(), precoFinalI) == true)
                    confirmaVendaImovel(janelaRegistrarVendaImovel);
                else
                    System.out.println("Venda não concluida");
            }
        });
    }

    private static void confirmaVendaImovel(JFrame janelaRegistrarVendaImovel){
        JFrame janelaConfirmaVendaImovel = new JFrame("Venda Imovel");
        janelaConfirmaVendaImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaVendaImovel = new JPanel();
        janelaConfirmaVendaImovel.setLocation(300, 100);
        janelaConfirmaVendaImovel.setSize(300,100);
        janelaConfirmaVendaImovel.add(painelConfirmaVendaImovel);
        janelaConfirmaVendaImovel.setVisible(true);

        JLabel textoConfirmaVendaImovel = new JLabel("Imovel Vendido com Sucesso!",JLabel. TRAILING);
        painelConfirmaVendaImovel.add(textoConfirmaVendaImovel);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaVendaImovel.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaVendaImovel.setVisible(false);
                janelaRegistrarVendaImovel.setVisible(false);
            }
        });
    }

    private static void codigoImovelInvalido(){
        JFrame janelaCodigoImovelInvalido = new JFrame("Imovel Não Encontrado");
        janelaCodigoImovelInvalido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCodigoImovelInvalido = new JPanel();
        janelaCodigoImovelInvalido.setLocation(300, 100); //lugar onde a janela abre
        janelaCodigoImovelInvalido.setSize(300,130);
        janelaCodigoImovelInvalido.add(painelCodigoImovelInvalido);
        janelaCodigoImovelInvalido.setVisible(true);

        JLabel textoCodigoImovelInvalido1 = new JLabel("Imovel Não Encotnrado!",JLabel. TRAILING);
        JLabel textoCodigoImovelInvalido2 = new JLabel("Verifique o Codigo digitado!",JLabel. TRAILING);
        painelCodigoImovelInvalido.add(textoCodigoImovelInvalido1);
        painelCodigoImovelInvalido.add(textoCodigoImovelInvalido2);

        JButton botaoConfirma = new JButton("Confirma");
        painelCodigoImovelInvalido.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCodigoImovelInvalido.setVisible(false);
            }
        });
    }
}
