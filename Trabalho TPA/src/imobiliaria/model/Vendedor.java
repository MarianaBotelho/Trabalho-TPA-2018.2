package imobiliaria.model;

import java.io.Serializable;

public class Vendedor extends Cliente implements Serializable {
    public Vendedor(String cpf, String email, String nome, String endereco, String telefone){
        super(cpf, email, nome, endereco, telefone,1);
    }
}
