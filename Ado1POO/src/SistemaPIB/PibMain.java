package SistemaPIB;

import java.io.IOException;

public class PibMain {

    public static void main(String[] args) {
        AplicativoPIB app = new AplicativoPIB();
        try {
            app.carregarEstados("pib.txt");
            app.carregarRegioes("regioes.txt");

            System.out.println("Percentual de PIB por estado:");
            app.imprimirPIBPorEstado();

            app.gerarArquivoSaida("teste.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
