package br.com.maratonajsf.bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;

    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = asList("RPG", "SCI-FI", "HORROR");
    }

    public void mudarLista() {
        categoriaList = asList("RPG", "SCI-FI", "HORROR", "COMEDY");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
