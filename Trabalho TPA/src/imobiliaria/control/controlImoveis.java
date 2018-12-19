package imobiliaria.control;

import imobiliaria.model.Imovel;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class controlImoveis {
    private static ArrayList<Imovel> imovel = new ArrayList();

    public static ArrayList<Imovel> getImovel() {
        return imovel;
    }

    private static void adicionarImovel(Imovel i){
        imovel.add(i);
        salvarArquivo();
    }

    public static void cadastrarImovel(String codigo, String nomeProprietario, String endereco, int tipo, int qtdQuarto, float precoInicial){
            Imovel i = new Imovel(codigo, controlClientes.getVendedorFromNome(nomeProprietario), endereco, tipo, qtdQuarto, precoInicial, 0, false,  LocalDate.MIN);
            adicionarImovel(i);
    }

    public static boolean removerImovel(String codigo){
        for(Imovel i : imovel){
            if(i.getCodigo().equals(codigo)) {
                imovel.remove(i);
                salvarArquivo();
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
                salvarArquivo();
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
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    public static String getProprietarioFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getProprietario().getNome();
            }
        }
        return null;
    }

    public static String getEnderecoFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getEndereco();
            }
        }
        return null;
    }

    public static String getTipoFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                switch (i.getTipo()) {
                    case 0:
                        return "Casa";
                    case 1:
                        return "Apartamento";
                    case 2:
                        return "Loja";
                }
            }
        }
        return null;
    }

    public static int getQntQuartosFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getQtdQuarto();
            }
        }
        return 0;
    }

    public static float getPrecoInicialFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getPrecoInicial();
            }
        }
        return 0;
    }

    public static boolean getStatusFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getStatus();
            }
        }
        return false;
    }

    public static LocalDate getDataVendaFromCodigo(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return i.getDataVenda();
            }
        }
        return null;
    }

    public static boolean imovelExiste(String codigo){
        for (Imovel i : imovel) {
            if (i.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static String getCodigoFromIndice(int i){
        return imovel.get(i).getCodigo();
    }

    public static String getNomeProprietarioFromIndice(int i){
        return imovel.get(i).getProprietario().getNome();
    }

    public static String getEnderecoFromIndice(int i){
        return imovel.get(i).getEndereco();
    }

    public static String getTipoFromIndice(int i){
        switch (imovel.get(i).getTipo()){
            case 0:
                return "Casa";
            case 1:
                return "Apartamento";
            case 2:
                return "Loja";
        }
        return null;
    }

    public static int getQntQuartosFromIndice(int i){
        return imovel.get(i).getQtdQuarto();
    }

    public static String getStatusFromIndice(int i){
        if(imovel.get(i).getStatus())
            return "Vendido";
        else
            return "Disponivel";
    }

    public static float getPrecoInicialFromIndice(int i){
        return imovel.get(i).getPrecoInicial();
    }

    public static float getPrecoFinalFromIndice(int i){
        return imovel.get(i).getPrecoFinal();
    }

    public static String getDataVendaFromIndice(int i){
        if(imovel.get(i).getStatus())
            return imovel.get(i).getDataVenda().toString();
        else
            return "Não vendido";
    }

    private static void salvarArquivo(){
        try {
            FileOutputStream file = new FileOutputStream("Imoveis.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(file);
            objeto.writeObject(imovel);
            objeto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarArquivo(){
        try {
            FileInputStream file = new FileInputStream("Imoveis.bin");
            ObjectInputStream objeto = new ObjectInputStream(file);
            imovel = (ArrayList<Imovel>) objeto.readObject();
            objeto.close();
        } catch (Exception e) {
            imovel.clear();
        }
    }
}
