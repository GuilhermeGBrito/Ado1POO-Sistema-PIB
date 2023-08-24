package SistemaPIB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private String local = "C:\\Users\\guivi\\eclipse-workspace\\Ado1POO\\src\\SistemaPIB\\\\";

    public BufferedReader lerArquivo(String nomeArquivo) {
        try {
            FileReader arquivo = new FileReader(local + nomeArquivo);
            BufferedReader leitor = new BufferedReader(arquivo);
            return leitor;
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
            return null;
        }
    }

    public void salvarArquivo(String nomeArquivo, String conteudo) {
        try {
            FileWriter arquivo = new FileWriter(local + nomeArquivo);
            BufferedWriter escritor = new BufferedWriter(arquivo);
            escritor.write(conteudo);
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo");
        }
    }
}
