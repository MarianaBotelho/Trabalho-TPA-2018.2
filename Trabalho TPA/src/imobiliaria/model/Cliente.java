/*
 * Imobiliaria
 */
package imobiliaria.model;

public abstract class Cliente extends Registro{
    
    private String email;
    private final int tipo;// 0 - Comprador | 1 - Vendendor
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public int getTipo(){
        return this.tipo;
    }

    public Cliente(String email, String nome, String endereco, String telefone, int tipo){
        super(nome, endereco, telefone);
        this.email = email;
        this.tipo = tipo;
    }  
}
