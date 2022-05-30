package br.com.maratonajsf.bean.estudante;

import br.com.maratonajsf.model.Estudante;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();
    private 

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
