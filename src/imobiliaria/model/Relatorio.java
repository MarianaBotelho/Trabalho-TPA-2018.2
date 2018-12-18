public class Relatorio{
    private float valorArrecadadoTotal;
    private float gastos; // gastos com visitas e comissoes (passados)
    private float gastosPrevistos; // gastos com visitas (futuro)
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Relatorio(float lucro, float gastosPassados, float gastosPrevistos, LocalDate dataInicio, LocalDate dataFinal){
        valorArrecadadoTotal = lucro;
        gastos = gastosPassados;
        this.gastosPrevistos = gastosPrevistos;
        this.dataFinal = dataFinal;
        this.dataInicio = dataInicio;
    }
}