package SistemaPIB;

import java.io.IOException;

public class PibMain {

	public static void main(String[] args) {
		AplicativoPIB app = new AplicativoPIB();
		try {
			app.carregarEstados("C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\pib.txt");
			app.carregarRegioes("C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\regioes.txt");

			System.out.println("Percentual de PIB por estado:");
			app.imprimirPIBPorEstado();

			app.gerarArquivoSaida("C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\\\New.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}