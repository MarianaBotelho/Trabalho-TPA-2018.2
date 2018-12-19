package imobiliaria;

import imobiliaria.view.telaInicial;
import imobiliaria.control.*;

public class Imobiliaria {
    public static void main(String[] args) {
        controlAgendamento.carregarArquivo();
        controlClientes.carregarArquivoComprador();
        controlClientes.carregarArquivoVendedor();
        controlCorretor.carregarArquivo();
        controlImoveis.carregarArquivo();
        telaInicial.telaInicial(); //desenha tela inicial
    }
}


//setIconImage(Image image)
















