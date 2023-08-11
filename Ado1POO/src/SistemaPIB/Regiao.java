package SistemaPIB;

import java.util.ArrayList;
import java.util.List;

public class Regiao {

    String nome;
    List<Estado> estados;

    public Regiao(String nome) {
        this.nome = nome;
        this.estados = new ArrayList<>();
    }

    public void adicionarEstado(Estado estado) {
        estados.add(estado);
    }
}
