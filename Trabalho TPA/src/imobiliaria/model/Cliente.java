package imobiliaria.model;

import java.io.Serializable;

public abstract class Cliente extends Registro implements Serializable {
    private String email;
    private final String cpf;
    private final int tipo; // 0 - Comprador | 1 - Vendedor
    
    public String getEmail(){
        return email;
    }

    public String getCpf(){ return this.cpf; }

    public int getTipo(){
        return this.tipo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Cliente(String cpf, String email, String nome, String endereco, String telefone, int tipo){
        super(nome, endereco, telefone);
        this.email = email;
        this.tipo = tipo;
        this.cpf = cpf;
    }  
}
