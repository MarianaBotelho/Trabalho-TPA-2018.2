public class controlRelatorio{
    ArrayList<Relatorio> static relatorios = new ArrayList<Relatorio>();

    public void static getRelatorioBetween(LocalDate dataDeInicio, LocalDate dataFinal){
        ArrayList<Imovel> imovel = getListaDeImoveis(); // pegar todas os imoveis
        totalArrecadado = 0;
        for(Imovel im : imovel){
            if(im.getStatus() == true && im.getData().isAfter(dataDeInicio) && im.getData().isBefore(dataFinal)){
                totalArrecadado += im.getPrecoFinal(); // como funciona o valor total arrecadado?
            }
        }
        ArrayList<Visita> visita = getListaDeVisitas();
        for(Visita vis : visita){
            if(vis.getData().compa&& vis.getData().isAfter(dataDeInicio) && vis.getData.isBefore(dataFinal)){
                /* gastos */
            }
            if(vis.getData().isAfter(dataFinal)){
                /* gastos futuros */
            }
        }
        relatorios.add(totalArrecadado,gastos,gastosFuturos, dataDeInicio, dataFinal);
    }

}