package imobiliaria;

import imobiliaria.control.Control;
import imobiliaria.model.*;
import view.SpringUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import static java.lang.Integer.parseInt;

public class Imobiliaria {
    public static void main(String[] args) {
        Control controle = new Control();
        JFrame janela = new JFrame("Imobiliaria");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //cria e coloca um botao OK no final da tela
        JButton botaoSair = new JButton("Sair"); //cria botao
        JPanel bottomPanel = new JPanel(); //cria painel ao final da janela
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanel.add(botaoSair); //add botao
        janela.add(bottomPanel, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //Painel Bem Vindo
        JPanel jpBemVindo = new JPanel(); //cria painel Bem vindo
        JLabel textoBV = new JLabel("Bem Vindo!"); //cria texto
        jpBemVindo.add(textoBV); //add ao painel


        //Painel Agendar
        JPanel jpAgendar = new JPanel(); //cria painel Agendar
        jpAgendar.setLayout(new BoxLayout(jpAgendar, BoxLayout.PAGE_AXIS));

        JLabel textoGasto = new JLabel("Insira gastos:",JLabel. TRAILING); //cria texto
        JTextField jtfGasto = new JTextField(20); //cria campo Gastos
        textoGasto.setLabelFor(jtfGasto);

        JLabel textoData = new JLabel("Insira data:", JLabel.TRAILING); //cria texto
        JTextField jtfData = new JTextField(20); //cria campo Data
        textoData.setLabelFor(jtfData);

        JLabel textoCliente = new JLabel("Insira cliente:", JLabel.TRAILING); //cria texto
        JTextField jtfCliente = new JTextField(20); //cria campo Cliente
        textoCliente.setLabelFor(jtfData);

        jpAgendar.add(textoGasto); //add texto Gasto
        jpAgendar.add(jtfGasto); //add campo Gastos
        jpAgendar.add(textoData); //add texto Data
        jpAgendar.add(jtfData); //add campo Data
        jpAgendar.add(textoCliente); //add texto Cliente
        jpAgendar.add(jtfCliente); //add campo Cliente

         //add botão
        JButton botaoAgendarOK = new JButton("Salvar"); //cria botão OK
        jpAgendar.add(botaoAgendarOK);

        botaoAgendarOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gastoV = jtfGasto.getText();
                String dataV = jtfData.getText();
                String clienteV = jtfCliente.getText();
                //controle.agendarVisita(imovel, corretor, clienteV, gastoV, dataV);
            }
        });


        //Painel Cadastros
        JPanel jpCadastros = new JPanel(); //cria painel Cadastros
        JButton cadastraFuncionario = new JButton("Novo Funcionario"); //cria botão Novo Funcionario
        jpCadastros.add(cadastraFuncionario); //add botão

        JButton botaoCadastraCliente = new JButton("Novo Cliente"); //cria botão Novo Cliente
        jpCadastros.add(botaoCadastraCliente); //add botão

        JButton botaoCadastraImovel = new JButton("Novo Imovel"); //cria botão Novo Imovel
        jpCadastros.add(botaoCadastraImovel); //add botão

        //Cadastra funcionario
        JFrame janelaCadF = new JFrame("Cadastro Novo Funcionario");
        janelaCadF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jpCadF = new JPanel(); //cria painel Cadastro Funcionario
        janelaCadF.setSize(800,600); //tamanho da janela
        janelaCadF.add(jpCadF);
        janelaCadF.setVisible(false); //não mostra janela

        jpCadF.setLayout(new BoxLayout(jpCadF, BoxLayout.PAGE_AXIS));

        JLabel textoMatrF = new JLabel("Insira matricula:",JLabel. TRAILING); //cria texto
        JTextField jtfMatrF = new JTextField(20); //cria campo MatriculaF
        textoMatrF.setLabelFor(jtfMatrF);

        JLabel textoNomeF = new JLabel("Insira nome:",JLabel. TRAILING); //cria texto
        JTextField jtfNomeF = new JTextField(20); //cria campo NomeF
        textoNomeF.setLabelFor(jtfNomeF);

        JLabel textoEnderF = new JLabel("Insira endereco:",JLabel. TRAILING); //cria texto
        JTextField jtfEnderF = new JTextField(20); //cria campo EnderF
        textoEnderF.setLabelFor(jtfEnderF);

        JLabel textoTelF = new JLabel("Insira telefone:",JLabel. TRAILING); //cria texto
        JTextField jtfTelF = new JTextField(20); //cria campo TelefoneF
        textoTelF.setLabelFor(jtfTelF);

        JButton botaoSalvaFunc = new JButton("Salva"); //cria botão Salva
        JPanel bottomPanelCadF = new JPanel(); //cria painel ao final da janela
        bottomPanelCadF.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelCadF.add(botaoSalvaFunc); //add botao
        janelaCadF.add(bottomPanelCadF, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        jpCadF.add(textoMatrF);
        jpCadF.add(jtfMatrF);
        jpCadF.add(textoNomeF);
        jpCadF.add(jtfNomeF);
        jpCadF.add(textoEnderF);
        jpCadF.add(jtfEnderF);
        jpCadF.add(textoTelF);
        jpCadF.add(jtfTelF);

        botaoSalvaFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaF = jtfMatrF.getText();
                String nomeF = jtfNomeF.getText();
                String enderecoF = jtfEnderF.getText();
                String telefoneF = jtfTelF.getText();
                controle.cadastrarFuncionario(matriculaF,nomeF,enderecoF,telefoneF);

                /*ArrayList<Funcionario> ListaF = controle.getCorretor();
                for(Funcionario func : ListaF)
                    System.out.println(func.getMatricula());*/

                janelaCadF.setVisible(false);
            }
        });

        cadastraFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadF.setVisible(true);
            }
        });

        //Cadastra Cliente
        JFrame janelaCadC = new JFrame("Cadastro Novo Cliente");
        janelaCadF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jpCadC = new JPanel(); //cria painel Cadastro Cliente
        janelaCadC.setSize(800,600); //tamanho da janela
        janelaCadC.add(jpCadC);
        janelaCadC.setVisible(false); //não mostra janela

        jpCadC.setLayout(new BoxLayout(jpCadC, BoxLayout.PAGE_AXIS));

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

        JButton botaoSalvaCliente = new JButton("Salva"); //cria botão Salva
        JPanel bottomPanelCadC = new JPanel(); //cria painel ao final da janela
        bottomPanelCadC.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelCadC.add(botaoSalvaCliente); //add botao
        janelaCadC.add(bottomPanelCadC, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        jpCadC.add(textoEmailC);
        jpCadC.add(jtfEmailC);
        jpCadC.add(textoNomeC);
        jpCadC.add(jtfNomeC);
        jpCadC.add(textoEnderC);
        jpCadC.add(jtfEnderC);
        jpCadC.add(textoTelC);
        jpCadC.add(jtfTelC);
        jpCadC.add(textoTipoC);
        jpCadC.add(tipoCliente);

        botaoSalvaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailC = jtfEmailC.getText();
                String nomeC = jtfNomeC.getText();
                String enderecoC = jtfEnderC.getText();
                String telefoneC = jtfTelC.getText();
                int tipoC = tipoCliente.getSelectedIndex();
                System.out.println(tipoC);
                controle.cadastrarCliente(emailC, nomeC, enderecoC, telefoneC, tipoC);

                ArrayList<Comprador> ListaC = controle.getClienteComprador();
                for(Cliente cli : ListaC)
                    System.out.println(cli.getTipo());

                janelaCadC.setVisible(false);
            }
        });

        botaoCadastraCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadC.setVisible(true);
            }
        });


        //Cadastra Imovel
        JFrame janelaCadI = new JFrame("Cadastro Novo Imoveis");
        janelaCadI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jpCadI = new JPanel(); //cria painel Cadastro Cliente
        janelaCadI.setSize(800,600); //tamanho da janela
        janelaCadI.add(jpCadI);
        janelaCadI.setVisible(false); //não mostra janela
        jpCadI.setLayout(new BoxLayout(jpCadI, BoxLayout.PAGE_AXIS));

        JLabel textoCodigoI = new JLabel("Insira codigo:",JLabel. TRAILING);
        JTextField jtfCodigoI = new JTextField(20);
        textoCodigoI.setLabelFor(jtfCodigoI);

        JLabel textoProprietarioI = new JLabel("Selecione o proprietario do imovel:");
        ArrayList<Vendendor> listaV = controle.getClienteVendedor();
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

        JButton botaoSalvaImovel = new JButton("Salva");
        JPanel bottomPanelCadI = new JPanel();
        bottomPanelCadI.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanelCadI.add(botaoSalvaImovel);
        janelaCadI.add(bottomPanelCadI, BorderLayout.SOUTH);

        jpCadI.add(textoCodigoI);
        jpCadI.add(jtfCodigoI);
        jpCadI.add(textoProprietarioI);
        jpCadI.add(proprietarioImovel);
        jpCadI.add(textoEnderI);
        jpCadI.add(jtfEnderI);
        jpCadI.add(textoTipoI);
        jpCadI.add(tipoImovel);
        jpCadI.add(textoQntQuaI);
        jpCadI.add(jtfQntQuaI);
        jpCadI.add(textoVendaI);
        jpCadI.add(jtfVendaI);


        botaoSalvaImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoI = jtfCodigoI.getText();
                String proprietarioI = proprietarioImovel.getSelectedItem().toString();
                String enderecoI = jtfEnderI.getText();
                int tipoI = tipoImovel.getSelectedIndex();
                int quantQuaI = parseInt(jtfQntQuaI.getText());
                float precoVenda = parseInt(jtfVendaI.getText());

                Vendendor vend = null;
                ArrayList<Vendendor> listaVend = controle.getClienteVendedor();
                for(Vendendor v : listaVend){
                    if(v.getNome().equals(proprietarioI))
                        vend = v;
                        break;
                }

                try {
                    controle.cadastrarImovel(codigoI, vend, enderecoI, tipoI, quantQuaI, precoVenda, false);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

                ArrayList<Imovel> ListaI = controle.getImovel();
                for(Imovel imv : ListaI)
                    System.out.println(imv.getCodigo());

                janelaCadI.setVisible(false);
            }
        });

        botaoCadastraImovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proprietarioImovel.removeAllItems();
                ArrayList<Vendendor> listaV = controle.getClienteVendedor();
                for(Cliente cli : listaV)
                    proprietarioImovel.addItem(cli.getNome());
                janelaCadI.setVisible(true);
            }
        });



        JTabbedPane tpAbas = new JTabbedPane(); //cria tabas
        tpAbas.addTab("Bem vindo", jpBemVindo);
        tpAbas.addTab("Agendar", jpAgendar); //add taba Agendar
        tpAbas.addTab("Cadastros", jpCadastros); //add tava Cadastro
        janela.add(tpAbas); //add tabas a janela
        janela.setLocation(270, 90); //lugar onde ela abre
        janela.setSize(800,600); //tamanho da janela
        janela.setVisible(true); //mostra janela
    }
}


//setIconImage(Image image)