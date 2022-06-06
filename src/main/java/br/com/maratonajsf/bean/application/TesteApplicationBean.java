package br.com.maratonajsf.bean.application;

import br.com.maratonajsf.bean.dependent.TesteDependentBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;
    private final TesteDependentBean dependentBean;
    private final TesteDependentBean sessionBean;

    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean, TesteDependentBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }


    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = asList("RPG", "SCI-FI", "HORROR");
        dependentBean.getCategoriasList().addAll(asList("ROMANCE", "FICTION"));
        sessionBean.selecionarPersonagem();
    }

    public void mudarLista() {
        categoriaList = asList("RPG", "SCI-FI", "HORROR", "COMEDY");
    }

    public TesteDependentBean getSessionBean() {
        return sessionBean;
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
