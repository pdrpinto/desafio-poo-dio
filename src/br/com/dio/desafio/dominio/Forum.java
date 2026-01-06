package br.com.dio.desafio.dominio;

import java.util.LinkedList;
import java.util.List;

public class Forum {
    private List<Comentario> comentarios = new LinkedList<>();

    public void adicionarComentario(Comentario c) {
        comentarios.add(c);
    }

    public List<Comentario> getComentarios() {
        return new LinkedList<>(comentarios);
    }
}
