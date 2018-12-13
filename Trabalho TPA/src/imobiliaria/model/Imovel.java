package imobiliaria.model;

public class Imovel
{
    private final String codigo;
    private final Vendendor proprietario;
    private String endereco;
    private int tipo; // 0 - casa | 1 - apro | 2 - loja
    private int qtdQuarto;
    private float venda;
    private boolean status; 

    public String getCodigo(){
        return codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getQtdQuarto() {
        return qtdQuarto;
    }

    public void setQtdQuarto(int qtdQuarto) {
        this.qtdQuarto = qtdQuarto;
    }

    public float getVenda() {
        return venda;
    }

    public void setVenda(float venda) {
        this.venda = venda;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
 
    public Imovel(String codigo, Vendendor proprietario, String endereco, int tipo,
                  int qtdQuarto, float venda, boolean status){
        this.codigo = codigo;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.tipo = tipo;
        this.qtdQuarto = qtdQuarto;
        this.venda = venda;
        this.status = status;
    } 
}
