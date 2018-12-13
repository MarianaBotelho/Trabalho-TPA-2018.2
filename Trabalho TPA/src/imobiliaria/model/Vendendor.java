package imobiliaria.model;

import java.util.ArrayList;

public class Vendendor extends Cliente
{
    private ArrayList<Imovel> imovel;
       
    public Vendendor(String email, String nome, String endereco, String telefone){
        super(email, nome, endereco, telefone,1);
    }
}
