package imobiliaria.model;

import java.io.Serializable;

public class Funcionario extends Registro implements Serializable {
    private final String matricula;
    private float comissao;

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }
       
    public String getMatricula(){
        return matricula;
    }
    
    public Funcionario(String matricula, String nome, String endereco, String telefone, float comissao){
        super(nome, endereco, telefone);
        this.matricula = matricula;
        this.comissao = comissao;
    }
}
