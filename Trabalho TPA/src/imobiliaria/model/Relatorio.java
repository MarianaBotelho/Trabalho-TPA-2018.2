package imobiliaria.model;
import java.time.LocalDate;

public class Relatorio {
    private float valorArrecadadoTotal;
    private float gastos; // gastos com visitas e comissoes (passados)
    private float gastosPrevistos; // gastos com visitas (futuro)
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public float getValorArrecadadoTotal() {
        return valorArrecadadoTotal;
    }

    public float getGastos() {
        return gastos;
    }

    public float getGastosPrevistos() {
        return gastosPrevistos;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Relatorio(float lucro, float gastosPassados, float gastosPrevistos, LocalDate dataInicio, LocalDate dataFinal){
        valorArrecadadoTotal = lucro;
        gastos = gastosPassados;
        this.gastosPrevistos = gastosPrevistos;
        this.dataFinal = dataFinal;
        this.dataInicio = dataInicio;
    }
}