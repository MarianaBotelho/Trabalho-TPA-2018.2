package imobiliaria.control;

import imobiliaria.model.Funcionario;
import java.util.ArrayList;

public class controlCorretor {
    private static ArrayList<Funcionario> corretor = new ArrayList();

    public static ArrayList<Funcionario> getCorretor() {
        return corretor;
    }

    private static void adicionarCorretor(Funcionario f){
        corretor.add(f);
    }

    public static void cadastrarFuncionario(String matricula, String nome, String endereco, String telefone, float comissao){
        Funcionario f = new Funcionario(matricula,nome, endereco, telefone, comissao);
        adicionarCorretor(f);
    }

    public static boolean removerFuncionario(String matricula){
        for(Funcionario f : corretor){
            if(f.getMatricula().equals(matricula)) {
                corretor.remove(f);
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

    public static boolean alterarFuncionario(String matricula, String nome, String endereco, String telefone, float comissao) {
        for (Funcionario f : corretor) {
            if (f.getMatricula().equals(matricula)) {
                f.setEndereco(endereco);
                f.setTelefone(telefone);
                f.setComissao(comissao);
                return true;
            }
        }
        return false;
    }
}
