package imobiliaria.control;

import imobiliaria.model.Cliente;
import imobiliaria.model.Comprador;
import imobiliaria.model.Vendedor;

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
    }

    private static void adicionarClienteC(Comprador c){
        clienteComprador.add(c);
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
                    return true;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    clienteComprador.remove(c);
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
                    return true;
                }
            }
        }else{
            for(Comprador c : clienteComprador){
                if(c.getCpf().equals(cpf)) {
                    c.setEmail(email);
                    c.setEndereco(endereco);
                    c.setTelefone(telefone);
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
}
