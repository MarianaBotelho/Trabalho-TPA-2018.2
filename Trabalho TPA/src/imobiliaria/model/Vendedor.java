package imobiliaria.model;

import java.util.ArrayList;

public class Vendedor extends Cliente
{
    private ArrayList<Imovel> imovel;
       
    public Vendedor(String cpf, String email, String nome, String endereco, String telefone){
        super(cpf, email, nome, endereco, telefone,1);
    }
}
