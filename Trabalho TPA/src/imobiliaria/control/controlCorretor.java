package imobiliaria.control;

import imobiliaria.model.Funcionario;

import java.io.*;
import java.util.ArrayList;

public class controlCorretor {
    private static ArrayList<Funcionario> corretor = new ArrayList();

    public static ArrayList<Funcionario> getCorretor() {
        return corretor;
    }

    private static void adicionarCorretor(Funcionario f){
        corretor.add(f);
        salvarArquivo();
    }

    public static void cadastrarFuncionario(String matricula, String nome, String endereco, String telefone, float comissao){
        Funcionario f = new Funcionario(matricula,nome, endereco, telefone, comissao);
        adicionarCorretor(f);
    }

    public static boolean removerFuncionario(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                corretor.remove(f);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public static Funcionario getFuncionarioFromMatricula(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return f;
            }
        }
        return null;
    }

    public static String getNomeFuncionarioFromMatricula(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return f.getNome();
            }
        }
        return null;
    }

    public static boolean alterarFuncionario(String matricula, String endereco, String telefone, float comissao) {
        for (Funcionario f : corretor) {
            if (f.getMatricula().equals(matricula)) {
                f.setEndereco(endereco);
                f.setTelefone(telefone);
                f.setComissao(comissao);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public static String getEnderecoFromMatricula(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return f.getEndereco();
            }
        }
        return null;
    }

    public static String getTelefoneFromMatricula(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return f.getTelefone();
            }
        }
        return null;
    }

    public static float getComissaoFromMatricula(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return f.getComissao();
            }
        }
        return 0;
    }

    public static boolean funcionarioExiste(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public static String getMatriculaFromPosiscao(int i){
        return corretor.get(i).getMatricula();
    }

    public static String getEnderecoFromPosicao(int i){
        return corretor.get(i).getEndereco();
    }

    public static String getTelefoneFromPosicao(int i){
        return corretor.get(i).getTelefone();
    }

    public static String getNomeFromPosicao(int i){
        return corretor.get(i).getNome();
    }

    public static float getComissaoFromPosicao(int i){
        return corretor.get(i).getComissao();
    }

    private static void salvarArquivo(){
        try {
            FileOutputStream file = new FileOutputStream("Funcionario.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(file);
            objeto.writeObject(corretor);
            objeto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarArquivo(){
        try {
            FileInputStream file = new FileInputStream("Funcionario.bin");
            ObjectInputStream objeto = new ObjectInputStream(file);
            corretor = (ArrayList<Funcionario>) objeto.readObject();
            objeto.close();
        } catch (Exception e) {
            corretor.clear();
        }
    }
}
