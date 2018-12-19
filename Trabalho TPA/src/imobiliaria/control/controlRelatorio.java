package imobiliaria.control;

import imobiliaria.model.Imovel;
import imobiliaria.model.Relatorio;
import imobiliaria.model.Visita;

import java.time.LocalDate;
import java.util.ArrayList;

public class controlRelatorio{
    private static ArrayList <Relatorio> relatorios = new ArrayList();

    public static void setRelatorioBetween(LocalDate dataDeInicio, LocalDate dataFinal){
        ArrayList<Imovel> imovel = controlImoveis.getImovel(); // pegar todas os imoveis

        float totalArrecadado = 0;
        float gastos = 0;
        float gastosFuturos= 0;
        for(Imovel im : imovel){
            if(im.getStatus() == true && im.getDataVenda().isAfter(dataDeInicio) && im.getDataVenda().isBefore(dataFinal)){
                totalArrecadado += im.getPrecoFinal()/10; //10% do valor final do imovel
            }
        }

        ArrayList<Visita> visita = controlAgendamento.getVisita();
        for(Visita vis : visita){
            if(vis.getData().isAfter(dataDeInicio) && vis.getData().isBefore(dataFinal)){
                gastos += vis.getGasto();
            }
            if(vis.getData().isAfter(dataFinal)){
                gastosFuturos += vis.getGasto();
            }
        }

        relatorios.add(new Relatorio(totalArrecadado, gastos, gastosFuturos, dataDeInicio, dataFinal));
    }

    public static float getTotalArrecadado(int i){
        return relatorios.get(i).getValorArrecadadoTotal();
    }

    public static float getGastosFuturos(int i){
        return relatorios.get(i).getGastosPrevistos();
    }

    public static float getGastosAnteriores(int i){
        return relatorios.get(i).getGastos();
    }

    public static LocalDate getDataInicial(int i){
        return relatorios.get(i).getDataInicio();
    }

    public static LocalDate getDataFinal(int i){
        return relatorios.get(i).getDataFinal();
    }
}