package imobiliaria.control;

import imobiliaria.model.Comprador;
import imobiliaria.model.Funcionario;
import imobiliaria.model.Imovel;
import imobiliaria.model.Vendendor;
import imobiliaria.model.Visita;
import java.util.ArrayList;
/**
 *
 * @author Michelle
 */
public class Control {
    private ArrayList<Vendendor> clienteVendedor = new ArrayList();
    private ArrayList<Comprador> clienteComprador = new ArrayList();
    private ArrayList<Funcionario> corretor = new ArrayList();
    private ArrayList<Imovel> imovel = new ArrayList();
    private ArrayList<Visita> visita = new ArrayList();
        
    private void adicionarCorretor(Funcionario f){
        corretor.add(f);
    }
    
    public void cadastrarFuncionario(String matricula, String nome, String endereco, String telefone){
        Funcionario f = new Funcionario(matricula,nome, endereco, telefone);
        adicionarCorretor(f);
    }   
    
    private void adicionarClienteV(Vendendor v){
        clienteVendedor.add(v);
    }
    
    private void adicionarClienteC(Comprador c){
        clienteComprador.add(c);
    }
    
    public void cadastrarCliente(String email, String nome, String endereco, String telefone, int tipo){
        if(tipo == 1){
            Vendendor v = new Vendendor(email,nome, endereco, telefone);
            adicionarClienteV(v);
        }else{
            Comprador c = new Comprador(email,nome, endereco, telefone);
            adicionarClienteC(c);
        }
    } 
      
    private void adicionarImovel(Imovel i){
        imovel.add(i);
    }
    
    public void cadastrarImovel(String codigo, Vendendor proprietario, String endereco, int tipo, int qtdQuarto, float venda, boolean status){
        if(proprietario != null) {
            Imovel i = new Imovel(codigo, proprietario, endereco, tipo, qtdQuarto, venda, status);
            adicionarImovel(i);
        }
    }
    
    public void adicionarVisita_Dia(Visita s){
        visita.add(s);
    }

    public void agendarVisita(ArrayList<Imovel> imovel, ArrayList<Funcionario> corretor, Comprador cliente, float gasto, String data){
        Visita s = new Visita(imovel, corretor, cliente, gasto, data);
        adicionarVisita_Dia(s);
    }

    public ArrayList<Vendendor> getClienteVendedor() {
        return clienteVendedor;
    }

    public ArrayList<Comprador> getClienteComprador() {
        return clienteComprador;
    }

    public ArrayList<Funcionario> getCorretor() {
        return corretor;
    }

    public ArrayList<Imovel> getImovel() {
        return imovel;
    }

    public ArrayList<Visita> getVisita() {
        return visita;
    }
}
