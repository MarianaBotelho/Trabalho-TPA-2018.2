package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlCorretor;
import imobiliaria.model.Funcionario;

public class telaAlterarFuncionario {
    public static void telaInserirMatricula(){
        JFrame janelaInserirMatricula = new JFrame("Alterar Funcionario");
        janelaInserirMatricula.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelInserirMatricula = new JPanel();

        JButton botaoBuscar = new JButton("Buscar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoBuscar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar
        janelaInserirMatricula.add(bottomPanelAlterar, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInserirMatricula.setVisible(false);
            }
        });

        janelaInserirMatricula.setLocation(270, 90);
        janelaInserirMatricula.setSize(800,600);
        janelaInserirMatricula.add(painelInserirMatricula);
        janelaInserirMatricula.setVisible(true);
        //janelaInserirMatricula.setLayout(new BoxLayout(janelaInserirMatricula, BoxLayout.PAGE_AXIS));

        JLabel labelMatriculaFuncionario = new JLabel("Insira Matricula:",JLabel. TRAILING);
        JTextField textoMatriculaFuncionario = new JTextField(20);
        labelMatriculaFuncionario.setLabelFor(textoMatriculaFuncionario);

        painelInserirMatricula.add(labelMatriculaFuncionario);
        painelInserirMatricula.add(textoMatriculaFuncionario);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaF = textoMatriculaFuncionario.getText();

                Funcionario funcMat = controlCorretor.getFuncionarioFromMatricula(matriculaF);
                if(funcMat == null){
                    matriculaFuncionarioInvalida();
                } else {
                    janelaInserirMatricula.setVisible(false);
                    telaAlterarFuncionario(funcMat);
                }
            }
        });

    }

    private static void telaAlterarFuncionario(Funcionario funcionarioMatricula){
        JFrame janelaAlterarFuncionario = new JFrame("Alterar Cliente");
        janelaAlterarFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelAlterarFuncionario = new JPanel();

        JButton botaoSalvar = new JButton("Salvar"); //cria botão Salva
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelAlterar = new JPanel(); //cria painel ao final da janela
        bottomPanelAlterar.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelAlterar.add(botaoSalvar); //add botao salvar
        bottomPanelAlterar.add(botaoCancelar); //add botao cancelar

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAlterarFuncionario.setVisible(false);
            }
        });

        painelAlterarFuncionario.setLayout(new BoxLayout(painelAlterarFuncionario, BoxLayout.PAGE_AXIS));
        janelaAlterarFuncionario.setLocation(270, 90);
        janelaAlterarFuncionario.setSize(800,600);
        janelaAlterarFuncionario.add(painelAlterarFuncionario);
        janelaAlterarFuncionario.setVisible(true);
        janelaAlterarFuncionario.add(bottomPanelAlterar, BorderLayout.SOUTH);

        JLabel textoMatriculaF = new JLabel("Matricula: " + funcionarioMatricula.getMatricula(), JLabel. TRAILING);

        JLabel textoNomeF = new JLabel("Nome: " + funcionarioMatricula.getNome(), JLabel. TRAILING);

        JLabel textoEndereco = new JLabel("Endereco:",JLabel. TRAILING);
        JTextField jtfEndereco = new JTextField(funcionarioMatricula.getEndereco(), 20);
        textoEndereco.setLabelFor(jtfEndereco);

        JLabel textoTelefone = new JLabel("Telefone:",JLabel. TRAILING);
        JTextField jtfTelefone = new JTextField(funcionarioMatricula.getTelefone(), 20);
        textoTelefone.setLabelFor(jtfTelefone);

        JLabel textoComissao = new JLabel("Comissao:",JLabel. TRAILING);
        JTextField jtfComissao = new JTextField(Float.toString(funcionarioMatricula.getComissao()), 20);
        textoComissao.setLabelFor(jtfComissao);

        painelAlterarFuncionario.add(textoMatriculaF);
        painelAlterarFuncionario.add(textoNomeF);
        painelAlterarFuncionario.add(textoEndereco);
        painelAlterarFuncionario.add(jtfEndereco);
        painelAlterarFuncionario.add(textoTelefone);
        painelAlterarFuncionario.add(jtfTelefone);
        painelAlterarFuncionario.add(textoComissao);
        painelAlterarFuncionario.add(jtfComissao);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enderecoF = jtfEndereco.getText();
                String telefoneF = jtfTelefone.getText();
                float comissaoF = Float.valueOf(jtfComissao.getText());

                controlCorretor.alterarFuncionario(funcionarioMatricula.getMatricula(), funcionarioMatricula.getNome(), enderecoF, telefoneF, comissaoF);

                confirmaAlteracaoFuncionario(janelaAlterarFuncionario);
            }
        });
    }

    private static void confirmaAlteracaoFuncionario(JFrame janelaAlterarFuncionario){
        JFrame janelaConfirmaAlteracaoFuncionario = new JFrame("Funcionario Alterado");
        janelaConfirmaAlteracaoFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaAlteracaoFuncionario = new JPanel();
        janelaConfirmaAlteracaoFuncionario.setLocation(300, 100);
        janelaConfirmaAlteracaoFuncionario.setSize(300,100);
        janelaConfirmaAlteracaoFuncionario.add(painelConfirmaAlteracaoFuncionario);
        janelaConfirmaAlteracaoFuncionario.setVisible(true);

        JLabel textoConfirmaAlteracaoFuncionario = new JLabel("Funcionario Alterado com Sucesso!",JLabel. TRAILING);
        painelConfirmaAlteracaoFuncionario.add(textoConfirmaAlteracaoFuncionario);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaAlteracaoFuncionario.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaAlteracaoFuncionario.setVisible(false);
                janelaAlterarFuncionario.setVisible(false);
            }
        });
    }

    private static void matriculaFuncionarioInvalida(){
        JFrame janelaMatriculaFuncionarioInvalida = new JFrame("Funcionario Não Encontrado");
        janelaMatriculaFuncionarioInvalida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelMatriculaFuncionarioInvalida = new JPanel();
        janelaMatriculaFuncionarioInvalida.setLocation(300, 100); //lugar onde a janela abre
        janelaMatriculaFuncionarioInvalida.setSize(300,130);
        janelaMatriculaFuncionarioInvalida.add(painelMatriculaFuncionarioInvalida);
        janelaMatriculaFuncionarioInvalida.setVisible(true);

        JLabel textoMatriculaFuncionarioInvalida1 = new JLabel("Funcionario Não Encotnrado!",JLabel. TRAILING);
        JLabel textoMatriculaFuncionarioInvalida2 = new JLabel("Verifique a Matricula digitada!",JLabel. TRAILING);
        painelMatriculaFuncionarioInvalida.add(textoMatriculaFuncionarioInvalida1);
        painelMatriculaFuncionarioInvalida.add(textoMatriculaFuncionarioInvalida2);

        JButton botaoConfirma = new JButton("Confirma");
        painelMatriculaFuncionarioInvalida.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaMatriculaFuncionarioInvalida.setVisible(false);
            }
        });
    }
}
