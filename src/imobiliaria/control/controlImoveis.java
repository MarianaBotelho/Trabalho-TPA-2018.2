package imobiliaria.control;

import imobiliaria.model.Imovel;
import imobiliaria.model.Vendedor;

import java.util.ArrayList;
import java.time.LocalDate;

public class controlImoveis {
    private static ArrayList<Imovel> imovel = new ArrayList();

    public static ArrayList<Imovel> getImovel() {
        return imovel;
    }

    private static void adicionarImovel(Imovel i){
        imovel.add(i);
    }

    public static void cadastrarImovel(String codigo, Vendedor proprietario, String endereco, int tipo, int qtdQuarto, float precoInicial, float precoFinal, boolean status, LocalDate dataVenda){
        if(proprietario != null) {
            Imovel i = new Imovel(codigo, proprietario, endereco, tipo, qtdQuarto, precoInicial, 0, status, dataVenda);
            adicionarImovel(i);
        }
    }

    public static boolean removerImovel(String codigo){
        for(Imovel i : imovel){
            if(i.getCodigo().equals(codigo)) {
                imovel.remove(i);
                return true;
            }
        }
        return false;
    }

    public static Imovel getImovelFromCodigo(String codigo){
        for(Imovel i : imovel){
            if(i.getCodigo().equals(codigo)) {
                return i;
            }
        }
        return null;
    }

    public static boolean alterarImovel(String codigo, float precoInicial){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                i.setPrecoInicial(precoInicial);
                return true;
            }
        }
        return false;
    }

    public static boolean finalizarVendaImovel(String codigo, float precoFinal){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                i.setStatus(true);
                i.setPrecoFinal(precoFinal);
                i.setDataVenda(LocalDate.now());
                return true;
            }
        }
        return false;
    }
}
