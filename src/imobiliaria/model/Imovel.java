package imobiliaria.model;

import java.time.LocalDate;

public class Imovel
{
    private final String codigo;
    private final Vendedor proprietario;
    private final String endereco;
    private final int tipo; // 0 - casa | 1 - apro | 2 - loja
    private final int qtdQuarto;
    private float precoInicial;
    private float precoFinal;
    private boolean status;  //false - disponivel | true - vendido
    private LocalDate dataVenda;

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTipo() {
        return tipo;
    }

    public int getQtdQuarto() {
        return qtdQuarto;
    }

    public float getPrecoInicial(){ return precoInicial; }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public Vendedor getProprietario() {
        return proprietario;
    }

    public void setPrecoInicial(float precoInicial) {
        this.precoInicial = precoInicial;
    }

    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
 
    public Imovel(String codigo, Vendedor proprietario, String endereco, int tipo, int qtdQuarto, float precoInicial, float precoFinal, boolean status, LocalDate dataVenda){
        this.codigo = codigo;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.tipo = tipo;
        this.qtdQuarto = qtdQuarto;
        this.precoInicial = precoInicial;
        this.precoFinal = precoFinal;
        this.status = status;
        this.dataVenda = dataVenda;
    } 
}
