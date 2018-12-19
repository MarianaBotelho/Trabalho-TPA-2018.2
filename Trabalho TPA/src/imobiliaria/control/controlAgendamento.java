package imobiliaria.control;

import imobiliaria.model.Comprador;
import imobiliaria.model.Funcionario;
import imobiliaria.model.Imovel;
import imobiliaria.model.Visita;

import java.time.LocalDate;
import java.util.ArrayList;

public class controlAgendamento {
    private static ArrayList<Visita> visita = new ArrayList();
    private static int codigoVisita = 1;

    public static void adicionarVisita_Dia(Visita s){
        visita.add(s);
    }

    public static void agendarVisita(Imovel imovelVisitado, Funcionario corretorResponsavel, Comprador cliente, float gasto, LocalDate data){
        Visita s = new Visita(imovelVisitado, corretorResponsavel, cliente, gasto, data, codigoVisita);
        adicionarVisita_Dia(s);
        codigoVisita++;
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
        /*Funcionario fun = null;
        for (Funcionario f : controlCorretor.getCorretor()) {
            if (f.getNome().equals(nomeFuncionario)) {
                fun = f;
                break;
            }
        }*/
        for (Visita v : visita) {
            if ((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente))) {
                v.setData(dataVisita);
                v.setGasto(gasto);
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
            if(v.getCodigoVisita() == codigoVisita)
                return v.getCliente().getCpf();
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
        return codigoVisita;
    }

    public static boolean removerVisita(String codigoImovel, String cpfCliente){
        for(Visita v : visita){
            if((v.getImovel().getCodigo().equals(codigoImovel)) && (v.getCliente().getCpf().equals(cpfCliente))) {
                visita.remove(v);
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
}
