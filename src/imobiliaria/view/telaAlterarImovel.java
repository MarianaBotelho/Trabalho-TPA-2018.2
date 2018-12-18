package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Float.parseFloat;

import imobiliaria.control.controlImoveis;
import imobiliaria.model.Imovel;

public class telaAlterarImovel {
    public static void telaInserirCodigo(){
        JFrame janelaInserirCodigo = new JFrame("Alterar Imovel");
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
                } else if(codigoImovel.getStatus() == true){
                    codigoImovelInvalido();
                } else {
                    janelaInserirCodigo.setVisible(false);
                    telaAlterarImovel(codigoImovel);
                }
            }
        });

    }

    private static void telaAlterarImovel(Imovel imovelCodigo){
        JFrame janelaAlterarImovel = new JFrame("Alterar Imovel");
        janelaAlterarImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelAlterarImovel = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoSalvar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlterarImovel.setVisible(false);
            }
        });

        painelAlterarImovel.setLayout(new BoxLayout(painelAlterarImovel, BoxLayout.PAGE_AXIS));
        janelaAlterarImovel.setLocation(270, 90);
        janelaAlterarImovel.setSize(800,600);
        janelaAlterarImovel.add(painelAlterarImovel);
        janelaAlterarImovel.setVisible(true);
        janelaAlterarImovel.add(bottomPanelAlterar, BorderLayout.SOUTH);

        JLabel textoCodigoImovel = new JLabel("Codigo: " + imovelCodigo.getCodigo(), JLabel. TRAILING);

        JLabel textoNomePropImovel = new JLabel("Nome proprietario: " + imovelCodigo.getProprietario().getNome(), JLabel. TRAILING);

        JLabel textoEnderecoImovel = new JLabel("Endereco do Imovel: " + imovelCodigo.getEndereco(), JLabel.TRAILING);


        JLabel textoPrecoInicial = new JLabel("Preco Inicial:",JLabel. TRAILING);
        JTextField jtfPrecoInicial = new JTextField(Float.toString(imovelCodigo.getPrecoInicial()),20);
        textoPrecoInicial.setLabelFor(jtfPrecoInicial);

        painelAlterarImovel.add(textoCodigoImovel);
        painelAlterarImovel.add(textoNomePropImovel);
        painelAlterarImovel.add(textoEnderecoImovel);
        painelAlterarImovel.add(textoPrecoInicial);
        painelAlterarImovel.add(jtfPrecoInicial);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float precoInicialI = parseFloat(jtfPrecoInicial.getText());

                controlImoveis.alterarImovel(imovelCodigo.getCodigo(), precoInicialI);

                confirmaAlteracaoImovel(janelaAlterarImovel);
            }
        });
    }

    private static void confirmaAlteracaoImovel(JFrame janelaAlterarImovel){
        JFrame janelaConfirmaAlteracaoImovel = new JFrame("Funcionario Alterado");
        janelaConfirmaAlteracaoImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaAlteracaoImovel = new JPanel();
        janelaConfirmaAlteracaoImovel.setLocation(300, 100);
        janelaConfirmaAlteracaoImovel.setSize(300,100);
        janelaConfirmaAlteracaoImovel.add(painelConfirmaAlteracaoImovel);
        janelaConfirmaAlteracaoImovel.setVisible(true);

        JLabel textoConfirmaAlteracaoImovel = new JLabel("Imovel Alterado com Sucesso!",JLabel. TRAILING);
        painelConfirmaAlteracaoImovel.add(textoConfirmaAlteracaoImovel);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaAlteracaoImovel.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaAlteracaoImovel.setVisible(false);
                janelaAlterarImovel.setVisible(false);
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

        JLabel textoCodigoImovelInvalido1 = new JLabel("Imovel Não Encotnrado ou Não Disponivel!",JLabel. TRAILING);
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
