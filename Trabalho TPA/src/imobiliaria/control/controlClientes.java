package imobiliaria.control;

import imobiliaria.model.Cliente;
import imobiliaria.model.Comprador;
import imobiliaria.model.Vendedor;

import java.io.*;
import java.util.ArrayList;

public class controlClientes {
    private static ArrayList<Vendedor> clienteVendedor = new ArrayList();
    private static ArrayList<Comprador> clienteComprador = new ArrayList();

    public static ArrayList<Vendedor> getClienteVendedor() {
        return clienteVendedor;
    }

    public static ArrayList<Comprador> getClienteComprador() {
        return clienteComprador;
    }

    private static void adicionarClienteV(Vendedor v){
        clienteVendedor.add(v);
        salvarArquivoVendedor();
    }

    private static void adicionarClienteC(Comprador c){
        clienteComprador.add(c);
        salvarArquivoComprador();
    }

    public static void cadastrarCliente(String cpf, String email, String nome, String endereco, String telefone, int tipo){
        if(tipo == 1){
            Vendedor v = new Vendedor(cpf, email,nome, endereco, telefone);
            adicionarClienteV(v);
        }else{
            Comprador c = new Comprador(cpf, email,nome, endereco, telefone);
            adicionarClienteC(c);
        }
    }

    public static boolean removerCliente(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    clienteVendedor.remove(v);
                    salvarArquivoVendedor();
                    return true;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    clienteComprador.remove(c);
                    salvarArquivoComprador();
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean alterarCliente(String cpf, String email, String endereco, String telefone, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    v.setEmail(email);
                    v.setEndereco(endereco);
                    v.setTelefone(telefone);
                    salvarArquivoVendedor();
                    return true;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    c.setEmail(email);
                    c.setEndereco(endereco);
                    c.setTelefone(telefone);
                    salvarArquivoComprador();
                    return true;
                }
            }
        }
        return false;
    }

    public static Cliente getClienteFromCPF(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return v;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return c;
                }
            }
        }
        return null;
    }

    public static String getNomeVendFromPosicao(int i){
        return clienteVendedor.get(i).getNome();
    }

    public static String getCPFVendFromPosicao(int i){
        return clienteVendedor.get(i).getCpf();
    }

    public static String getEnderecoVendFromPosicao(int i){
        return clienteVendedor.get(i).getEndereco();
    }

    public static String getTelefoneVendFromPosicao(int i){
        return clienteVendedor.get(i).getTelefone();
    }

    public static String getNomeCompFromPosicao(int i){
        return clienteComprador.get(i).getNome();
    }

    public static String getCPFCompFromPosicao(int i){
        return clienteComprador.get(i).getCpf();
    }

    public static String getEnderecoCompFromPosicao(int i){
        return clienteComprador.get(i).getEndereco();
    }

    public static String getTelefoneCompFromPosicao(int i){
        return clienteComprador.get(i).getTelefone();
    }

    public static String getNomeFromCpf(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return v.getNome();
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return c.getNome();
                }
            }
        }
        return null;
    }

    public static String getEnderecoFromCpf(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return v.getEndereco();
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return c.getEndereco();
                }
            }
        }
        return null;
    }

    public static String getTelefoneFromCpf(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return v.getTelefone();
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return c.getTelefone();
                }
            }
        }
        return null;
    }

    public static String getEmailFromCpf(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return v.getEmail();
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return c.getEmail();
                }
            }
        }
        return null;
    }

    public static boolean clienteExiste(String cpf, int tipo){
        if(tipo == 1){
            for(Vendedor v : clienteVendedor){
                if(v.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Vendedor getVendedorFromNome(String nome){
        for(Vendedor v : clienteVendedor) {
            if (v.getNome().equals(nome))
                return v;
        }
        return null;
    }

    private static void salvarArquivoComprador(){
        try {
            FileOutputStream file = new FileOutputStream("Comprador.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(file);
            objeto.writeObject(clienteComprador);
            objeto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void salvarArquivoVendedor(){
        try {
            FileOutputStream file = new FileOutputStream("Vendedor.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(file);
            objeto.writeObject(clienteVendedor);
            objeto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarArquivoComprador(){
        try {
            FileInputStream file = new FileInputStream("Comprador.bin");
            ObjectInputStream objeto = new ObjectInputStream(file);
            clienteComprador = (ArrayList<Comprador>) objeto.readObject();
            objeto.close();
        } catch (Exception e) {
            clienteComprador.clear();
        }
    }

    public static void carregarArquivoVendedor(){
        try {
            FileInputStream file = new FileInputStream("Vendedor.bin");
            ObjectInputStream objeto = new ObjectInputStream(file);
            clienteVendedor = (ArrayList<Vendedor>) objeto.readObject();
            objeto.close();
        } catch (Exception e) {
            clienteVendedor.clear();
        }
    }
}
