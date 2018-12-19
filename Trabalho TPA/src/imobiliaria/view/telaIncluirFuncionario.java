package imobiliaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imobiliaria.control.controlCorretor;

public class telaIncluirFuncionario {
    public static void telaIncluirFuncionario(){
        JFrame janelaCadastrarFuncionario = new JFrame("Cadastrar Funcionario");
        janelaCadastrarFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelCadastrarFuncionario = new JPanel(); //cria painel Cadastro Funcionario

        JButton botaoSalvar = new JButton("Salvar"); //cria botão salvar
        JButton botaoCancelar = new JButton("Cancelar"); //cria botao cancelar
        JPanel bottomPanelCadastrarFuncionario = new JPanel(); //cria painel ao final da janela
        bottomPanelCadastrarFuncionario.setLayout(new FlowLayout(FlowLayout.CENTER)); //centraliza o que for ficar no painel no final
        bottomPanelCadastrarFuncionario.add(botaoSalvar); //add botao salvar
        bottomPanelCadastrarFuncionario.add(botaoCancelar); //add botao cancelar
        janelaCadastrarFuncionario.add(bottomPanelCadastrarFuncionario, BorderLayout.SOUTH); //determina que o botao vai ficar no final do painel
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCadastrarFuncionario.setVisible(false);
            }
        });

        janelaCadastrarFuncionario.setLocation(270, 90); //lugar onde a janela abre
        janelaCadastrarFuncionario.setSize(800,600); //tamanho da janela
        janelaCadastrarFuncionario.add(painelCadastrarFuncionario);
        janelaCadastrarFuncionario.setVisible(true); //não mostra janela
        painelCadastrarFuncionario.setLayout(new BoxLayout(painelCadastrarFuncionario, BoxLayout.PAGE_AXIS));

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

        JLabel textoComissaoF = new JLabel("Insira comissao:",JLabel. TRAILING); //cria texto
        JTextField jtfComissaoF = new JTextField(20); //cria campo ComissaoF
        textoComissaoF.setLabelFor(jtfComissaoF);

        painelCadastrarFuncionario.add(textoMatrF);
        painelCadastrarFuncionario.add(jtfMatrF);
        painelCadastrarFuncionario.add(textoNomeF);
        painelCadastrarFuncionario.add(jtfNomeF);
        painelCadastrarFuncionario.add(textoEnderF);
        painelCadastrarFuncionario.add(jtfEnderF);
        painelCadastrarFuncionario.add(textoTelF);
        painelCadastrarFuncionario.add(jtfTelF);
        painelCadastrarFuncionario.add(textoComissaoF);
        painelCadastrarFuncionario.add(jtfComissaoF);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matriculaF = jtfMatrF.getText();
                String nomeF = jtfNomeF.getText();
                String enderecoF = jtfEnderF.getText();
                String telefoneF = jtfTelF.getText();
                float comissaoF = Float.valueOf(jtfComissaoF.getText());

                controlCorretor.cadastrarFuncionario(matriculaF,nomeF,enderecoF,telefoneF, comissaoF);

                /*ArrayList<Funcionario> ListaF = controle.getCorretor();
                for(Funcionario func : ListaF)
                    System.out.println(func.getMatricula());*/

                confirmaCadastroFuncionario(janelaCadastrarFuncionario);
            }
        });
    }

    private static void confirmaCadastroFuncionario(JFrame janelaCadastrarFuncionario){
        JFrame janelaConfirmaCadastroFuncionario = new JFrame("Funcionario Cadastrado");
        janelaConfirmaCadastroFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel painelConfirmaCadastroFuncionario = new JPanel();
        janelaConfirmaCadastroFuncionario.setLocation(300, 100); //lugar onde a janela abre
        janelaConfirmaCadastroFuncionario.setSize(300,100);
        janelaConfirmaCadastroFuncionario.add(painelConfirmaCadastroFuncionario);
        janelaConfirmaCadastroFuncionario.setVisible(true);

        JLabel textoConfirmaCadastroFuncionario = new JLabel("Funcionario Cadastrado com Sucesso!",JLabel. TRAILING);
        painelConfirmaCadastroFuncionario.add(textoConfirmaCadastroFuncionario);

        JButton botaoConfirma = new JButton("Confirma");
        painelConfirmaCadastroFuncionario.add(botaoConfirma);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaConfirmaCadastroFuncionario.setVisible(false);
                janelaCadastrarFuncionario.setVisible(false);
            }
        });
    }
}
