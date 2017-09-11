package br.com.fiap.natura.naturaapp.bean;

/**
 * Created by daniel on 09/09/17.
 */

public class Parceiro {

    private long id;
    private String nome;
    private String logo;

    public Parceiro() {}

    public Parceiro(long id, String nome, String logo) {
        this.id = id;
        this.nome = nome;
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
