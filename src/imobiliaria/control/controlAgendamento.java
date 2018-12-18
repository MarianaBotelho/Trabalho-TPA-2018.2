package imobiliaria.control;

import imobiliaria.model.Comprador;
import imobiliaria.model.Funcionario;
import imobiliaria.model.Imovel;
import imobiliaria.model.Visita;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Michelle
 */
public class controlAgendamento {
    private static ArrayList<Visita> visita = new ArrayList();

    public static void adicionarVisita_Dia(Visita s){
        visita.add(s);
    }

    public static void agendarVisita(Imovel imovelVisitado, Funcionario corretorResponsavel, Comprador cliente, float gasto, LocalDate data){
        Visita s = new Visita(imovelVisitado, corretorResponsavel, cliente, gasto, data);
        adicionarVisita_Dia(s);
    }

    public static ArrayList<Visita> getVisita() {
        return visita;
    }

    //criar metodo getVisitaFromImovelAndCliente
    //criar metodo alterarVisita


}
