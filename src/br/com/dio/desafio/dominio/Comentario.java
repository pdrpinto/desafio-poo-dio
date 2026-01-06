package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Comentario {
    private Dev dev;
    private LocalDate horario;
    private String mensagem;

    public Comentario(Dev dev, String mensagem) {
        this.dev = dev;
        this.horario = LocalDate.now();
        this.mensagem = mensagem;
    }

    public Dev getDev() {
        return dev;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "dev=" + dev +
                ", horario=" + horario +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
