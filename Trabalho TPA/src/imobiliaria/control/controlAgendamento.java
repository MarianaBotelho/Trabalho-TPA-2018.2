package imobiliaria.control;

import imobiliaria.model.Comprador;
import imobiliaria.model.Funcionario;
import imobiliaria.model.Imovel;
import imobiliaria.model.Visita;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class controlAgendamento {
    private static ArrayList<Visita> visita = new ArrayList();

    public static void adicionarVisita_Dia(Visita s){
        visita.add(s);
        salvarArquivo();
    }

    public static void agendarVisita(Imovel imovelVisitado, Funcionario corretorResponsavel, Comprador cliente, float gasto, LocalDate data){
        Visita s = new Visita(imovelVisitado, corretorResponsavel, cliente, gasto, data, visita.size()+1);
        adicionarVisita_Dia(s);
        }

    public static ArrayList<Visita> getVisita() {
        return visita;
    }

    public static Visita getVisitaFromImovelAndCliente(String codigoImovel, String cpfCliente){
        for(Visita v : visita){
            if((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente))) {
                return v;
            }
        }
        return null;
    }

    public static boolean alterarVisita(String codigoImovel, String cpfCliente, float gasto, LocalDate dataVisita){
        for (Visita v : visita) {
            if ((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente))) {
                v.setData(dataVisita);
                v.setGasto(gasto);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public static String getCodigoImovelFromCodigoVisita(int codigoVisita){
        for(Visita v : visita){
            if(v.getCodigoVisita() == codigoVisita)
                return v.getImovel().getCodigo();
        }
        return null;
    }

    public static String getCpfClienteFromCodigoVisita(int codigoVisita){
        for(Visita v : visita){
            if(v.getCodigoVisita() == codigoVisita){
                return v.getCliente().getCpf();
            }
        }
        return null;
    }

    public static String getMatriculaCorretorFromCodigoVisita(int codigoVisita){
        for(Visita v : visita){
            if(v.getCodigoVisita() == codigoVisita)
                return v.getCorretor().getMatricula();
        }
        return null;
    }

    public static String getNomeFuncionario(String codigoImovel, String cpfCliente){
        return getVisitaFromImovelAndCliente(codigoImovel, cpfCliente).getCorretor().getNome();
    }

    public static float getGastoVisita(String codigoImovel, String cpfCliente){
        return getVisitaFromImovelAndCliente(codigoImovel, cpfCliente).getGasto();
    }

    public static float getGastoVisitaFromCodigoVisita(int codigoVisita){
        for(Visita v : visita){
            if(v.getCodigoVisita() == codigoVisita)
                return v.getGasto();
        }
        return 0;
    }

    public static LocalDate getDataFromCodigoVisita(int codigoVisita){
        for(Visita v : visita){
            if(v.getCodigoVisita() == codigoVisita)
                return v.getData();
        }
        return null;
    }

    public static LocalDate getDataVisita(String codigoImove, String cpfCliente){
        return getVisitaFromImovelAndCliente(codigoImove, cpfCliente).getData();
    }

    public static int getCodigoVisitaTotal(){
        return visita.size();
    }

    public static boolean removerVisita(String codigoImovel, String cpfCliente){
        for(Visita v : visita){
            if((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente))) {
                visita.remove(v);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public static boolean agendamentoExiste(String codigoImovel, String cpfCliente){
        for (Visita v : visita) {
            if ((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente)))
                return true;
        }
        return false;
    }

    private static void salvarArquivo(){
        try {
            FileOutputStream file = new FileOutputStream("Visitas.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(file);
            objeto.writeObject(visita);
            objeto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarArquivo(){
        try {
            FileInputStream file = new FileInputStream("Visitas.bin");
            ObjectInputStream objeto = new ObjectInputStream(file);
            visita = (ArrayList<Visita>) objeto.readObject();
            objeto.close();
        } catch (Exception e) {
            visita.clear();
        }
    }
}
