package org.example.models;

public class Cliente {
    private Integer cnpj;
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
