package imobiliaria.model;

public class Funcionario extends Registro{
    
    private final String matricula;
       
    public String getMatricula(){
        return matricula;
    }
    
    public Funcionario(String matricula, String nome, String endereco, String telefone){
        super(nome, endereco, telefone);
        this.matricula = matricula;     
    }
}
