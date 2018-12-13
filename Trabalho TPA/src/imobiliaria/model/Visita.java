package imobiliaria.model;

import java.util.ArrayList;

public class Visita
{
    private ArrayList<Imovel> imovel;
    private ArrayList<Funcionario> corretor;
    private Comprador cliente;
    private float gasto;
    private String data;

    public ArrayList<Imovel> getImovel() {
        return imovel;
    }

    public void setImovel(ArrayList<Imovel> imovel) {
        this.imovel = imovel;
    }

    public ArrayList<Funcionario> getCorretor() {
        return corretor;
    }

    public void setCorretor(ArrayList<Funcionario> corretor) {
        this.corretor = corretor;
    }

    public Comprador getCliente() {
        return cliente;
    }

    public void setCliente(Comprador cliente) {
        this.cliente = cliente;
    }

    public float getGasto() {
        return gasto;
    }

    public void setGasto(float gasto) {
        this.gasto = gasto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Visita(ArrayList<Imovel> imovel, ArrayList<Funcionario> corretor, Comprador cliente, float gasto, String data) {
        this.imovel = imovel;
        this.corretor = corretor;
        this.cliente = cliente;
        this.gasto = gasto;
        this.data = data;
    }
}
