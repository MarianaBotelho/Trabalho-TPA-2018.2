package imobiliaria.model;

import java.io.Serializable;

public class Comprador extends Cliente implements Serializable {
    public Comprador(String cpf, String email, String nome, String endereco, String telefone){
        super(cpf, email, nome, endereco, telefone,0);
        
    }
}
