package imobiliaria.model;

import java.util.ArrayList;

public class Comprador extends Cliente
{
    private ArrayList <Imovel> caracteristicas;
    
    public Comprador(String email, String nome, String endereco, String telefone){
        super(email, nome, endereco, telefone,0);
        
    }
}
