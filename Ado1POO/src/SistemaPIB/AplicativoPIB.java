package SistemaPIB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AplicativoPIB {
    private List<Estado> estados;
    private Map<String, Regiao> regioes;
    
    

    public AplicativoPIB() {
        this.estados = new ArrayList<>();
        this.regioes = new HashMap<>();
    }

    public void carregarEstados(String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\pib.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    Estado estado = new Estado(dados[0], Double.parseDouble(dados[1]));
                    estados.add(estado);
                }
            }
        }
    }

    public void carregarRegioes(String arquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\regioes.txt"))) {
            String linha;
            Regiao regiaoAtual = null;
            while ((linha = reader.readLine()) != null) {
                if (!linha.isEmpty()) {
                    if (linha.contains(";")) {
                        String[] dados = linha.split(";");
                        regiaoAtual = new Regiao(dados[0]);
                        regioes.put(dados[0], regiaoAtual);
                    } else if (regiaoAtual != null) {
                        final String tempLinha = linha;
                        Estado estado = estados.stream().filter(e -> e.nome.equals(tempLinha)).findFirst().orElse(null);
                        if (estado != null) {
                            regiaoAtual.adicionarEstado(estado);
                        }
                    }
                }
            }
        }
    }

    public void imprimirPIBPorEstado() {
        double totalPIB = estados.stream().mapToDouble(e -> e.pib).sum();
        for (Estado estado : estados) {
            double percentual = (estado.pib / totalPIB) * 100;
            System.out.printf("%s: %.2f%%%n", estado.nome, percentual);
        }
    }

    public void gerarArquivoSaida(String arquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("saida.txt"))) {
            for (Regiao regiao : regioes.values()) {
                double totalPIBRegiao = regiao.estados.stream().mapToDouble(e -> e.pib).sum();
                writer.printf("%s: %.2f%n", regiao.nome, totalPIBRegiao);
            }
        }
    }
}
