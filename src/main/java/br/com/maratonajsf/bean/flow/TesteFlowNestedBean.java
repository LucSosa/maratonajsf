package br.com.maratonajsf.bean.flow;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "pendencies")
public class TesteFlowNestedBean implements Serializable {
    private String userName;
    private String userSurname;

    public String validarUser() {
        System.out.println("Fazendo Consulta no SERASA");
        System.out.println("Fazendo Consulta no SPC");
        System.out.println("Pedindo a permissáo de Deus");
        System.out.println("Sacrificando um bode");
        if (true) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Usuario nao passaou nas pendencias",
                            "Algum detalhe util"));
            return null;
        }
        return "proceedToRegistration3";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
