package br.com.dio.desafio.dominio;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DevRegistry {

    private static DevRegistry instance;
    private Set<Dev> devs = new LinkedHashSet<>();

    private DevRegistry() {}

    public static DevRegistry getInstance() {
        if (instance == null) {
            instance = new DevRegistry();
        }
        return instance;
    }

    public void registrar(Dev dev){
        devs.add(dev);
    }

    public void remover(Dev dev){
        devs.remove(dev);
    }

    public List<Dev> getRanking() {
        return devs.stream()
                .sorted((d1, d2) -> Double.compare(d2.calcularTotalXp(), d1.calcularTotalXp()))
                .collect(Collectors.toList());
    }

    public int getPosicao(Dev dev){
        List<Dev> ranking = getRanking();
        return ranking.indexOf(dev) + 1;
    }

    public Set<Dev> getTodos() {
        return new LinkedHashSet<>(devs);
    }

}
