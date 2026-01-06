import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descricao curso js");
        curso2.setCargaHoraria(8);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("mentoria java");
        mentoria1.setDescricao("descricao mentoria java");
        mentoria1.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Dev");
        bootcamp.setDescricao("Descricao Bootcamp Java Dev");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev("Pedro");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: "+ dev1.getConteudosInscritos());
        dev1.progredir();
        System.out.println("Conteudos Concluidos: "+ dev1.getConteudosConcluidos());
        System.out.println("Conteudos inscritos: "+ dev1.getConteudosInscritos());
        System.out.println("XP: "+dev1.calcularTotalXp());

        System.out.println("----");

        Dev dev2 = new Dev("Gui");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos: "+ dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        System.out.println("Conteudos Concluidos: "+ dev2.getConteudosConcluidos());
        System.out.println("Conteudos inscritos: "+ dev2.getConteudosInscritos());
        System.out.println("XP: "+dev2.calcularTotalXp());

        System.out.println("----");

        Comentario comentario1 = new Comentario(dev1, "Excelente conteudo!");
        Comentario comentario2 = new Comentario(dev2, "Conteudo bacana!");
        curso1.getForum().adicionarComentario(comentario1);
        curso1.getForum().adicionarComentario(comentario2);

        System.out.println("Comentarios no curso "+ curso1 +" :" +curso1.getForum().getComentarios());
        System.out.println("Comentarios no curso "+ curso2 +" :" +curso2.getForum().getComentarios());

        System.out.println("=== RANKING GLOBAL ===");
        List<Dev> ranking = DevRegistry.getInstance().getRanking();
        for (int i = 0; i < ranking.size(); i++) {
            Dev dev = ranking.get(i);
            System.out.println((i+1) + " - " + dev.getNome() + " - XP: " + dev.calcularTotalXp());
        }
    }
}