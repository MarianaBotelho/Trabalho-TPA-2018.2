package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDate;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import imobiliaria.model.*;
import imobiliaria.control.*;

public class telaIncluirImovel {
    public static void telaIncluirImovel(){
        JFrame janelaCadastrarImovel = new JFrame("Cadastrar Novo Imovel");
        janelaCadastrarImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCadastrarImovel = new JPanel(); //cria painel Cadastro Imovel

        JButton botaoSalvar = new JButton("Salvar"); //cria botão Salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelCadastrarImovel = new JPanel(); //cria painel ao final da janela
        bottomPanelCadastrarImovel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelCadastrarImovel.add(botaoSalvar); //add botao salvar
        bottomPanelCadastrarImovel.add(botaoCancelar); //add botao cancelar
        janelaCadastrarImovel.add(bottomPanelCadastrarImovel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastrarImovel.setVisible(false);
            }
        });
        
        janelaCadastrarImovel.setLocation(270, 90); //lugar onde a janela abre
        janelaCadastrarImovel.setSize(800,600); //tamanho da janela
        janelaCadastrarImovel.add(painelCadastrarImovel);
        janelaCadastrarImovel.setVisible(true); //mostra janela
        painelCadastrarImovel.setLayout(new BoxLayout(painelCadastrarImovel, BoxLayout.PAGE_AXIS));

        
        JLabel textoCodigoI = new JLabel("Insira codigo:",JLabel. TRAILING);
        JTextField jtfCodigoI = new JTextField(20);
        textoCodigoI.setLabelFor(jtfCodigoI);

        JLabel textoProprietarioI = new JLabel("Selecione o proprietario do imovel:");
        ArrayList<Vendedor> listaV = controlClientes.getClienteVendedor();
        ArrayList<String> vendedores = new ArrayList<String>();
        for(Cliente cli : listaV)
            vendedores.add(cli.getNome());
        String[] propI = vendedores.toArray(new String[0]);
        System.out.println(propI);
        JComboBox proprietarioImovel = new JComboBox(propI);

        JLabel textoEnderI = new JLabel("Insira endereco:",JLabel. TRAILING);
        JTextField jtfEnderI = new JTextField(20);
        textoEnderI.setLabelFor(jtfEnderI);

        JLabel textoTipoI = new JLabel("Selecione o tipo de imovel:");
        String[] tipoI = {"Casa", "Apartamento", "Loja"};
        JComboBox tipoImovel = new JComboBox(tipoI);

        JLabel textoQntQuaI = new JLabel("Insira quantidade de quartos:",JLabel. TRAILING);
        JTextField jtfQntQuaI = new JTextField(20);
        textoQntQuaI.setLabelFor(jtfQntQuaI);

        JLabel textoVendaI = new JLabel("Insira preco:",JLabel. TRAILING);
        JTextField jtfVendaI = new JTextField(20);
        textoVendaI.setLabelFor(jtfVendaI);

        painelCadastrarImovel.add(textoCodigoI);
        painelCadastrarImovel.add(jtfCodigoI);
        painelCadastrarImovel.add(textoProprietarioI);
        painelCadastrarImovel.add(proprietarioImovel);
        painelCadastrarImovel.add(textoEnderI);
        painelCadastrarImovel.add(jtfEnderI);
        painelCadastrarImovel.add(textoTipoI);
        painelCadastrarImovel.add(tipoImovel);
        painelCadastrarImovel.add(textoQntQuaI);
        painelCadastrarImovel.add(jtfQntQuaI);
        painelCadastrarImovel.add(textoVendaI);
        painelCadastrarImovel.add(jtfVendaI);


        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoI = jtfCodigoI.getText();
                String proprietarioI = proprietarioImovel.getSelectedItem().toString();
                String enderecoI = jtfEnderI.getText();
                int tipoI = tipoImovel.getSelectedIndex();
                int quantQuaI = parseInt(jtfQntQuaI.getText());
                float precoInicial = parseFloat(jtfVendaI.getText());

                Vendedor vend = null;
                ArrayList<Vendedor> listaVend = controlClientes.getClienteVendedor();
                for(Vendedor v : listaVend){
                    if(v.getNome().equals(proprietarioI))
                        vend = v;
                    break;
                }

                try {
                    controlImoveis.cadastrarImovel(codigoI, vend, enderecoI, tipoI, quantQuaI, precoInicial, 0, false, LocalDate.MIN);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

                /*ArrayList<Imovel> ListaI = controlImoveis.getImovel();
                for(Imovel imv : ListaI)
                    System.out.println(imv.getCodigo());*/

                confirmaCadastroImovel(janelaCadastrarImovel);
            }
        });
    }
    private static void confirmaCadastroImovel(JFrame janelaCadastrarImovel){
        JFrame janelaConfirmaCadastroImovel = new JFrame("Imovel Cadastrado");
        janelaConfirmaCadastroImovel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaCadastroImovel = new JPanel();
        janelaConfirmaCadastroImovel.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaCadastroImovel.setSize(300,100);
        janelaConfirmaCadastroImovel.add(painelConfirmaCadastroImovel);
        janelaConfirmaCadastroImovel.setVisible(true);

        JLabel textoConfirmaCadastroImovel = new JLabel("Imovel Cadastrado com Sucesso!",JLabel. TRAILING);
        painelConfirmaCadastroImovel.add(textoConfirmaCadastroImovel);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaCadastroImovel.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaCadastroImovel.setVisible(false);
                janelaCadastrarImovel.setVisible(false);
            }
        });
    }

}
