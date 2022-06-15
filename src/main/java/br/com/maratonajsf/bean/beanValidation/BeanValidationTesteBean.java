package br.com.maratonajsf.bean.beanValidation;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.*;
import java.io.Serializable;

@Named
@ViewScoped
public class BeanValidationTesteBean implements Serializable {
    @Size(min = 3, max = 10, message = "O nome tem que ter entre 3 e 10 caracteres")
    @NotNull(message = "O nome é obrigatório!")
    private String nome;
    @Pattern(regexp = "^([a-zA-z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Digite um e-mail válido")
    private String email;
    @DecimalMax(value = "30.50", message = "O valor decimal não pode ser maior que 30.50")
    @DecimalMin(value = "5.00", message = "O valor decimal não pode ser menor que 5.00")
    private double decimal;
    @Digits(integer = 3, fraction = 2, message = "O valor não pode ser maior que 99 e casa decimal maior que 2 digitos")
    private double numero;

    public void salvar() {
        System.out.println(nome);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
