package org.example.models;

import java.time.LocalDate;

public class VendasCliente {
    private Integer codigo;
    private Integer cnpj;
    private LocalDate dataVenda;
    public Float toneladas;
    public Float valor;

    public VendasCliente() {
    }

    public VendasCliente(Integer codigo, Integer cnpj, LocalDate dataVenda, Float toneladas, Float valor) {
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.dataVenda = dataVenda;
        this.toneladas = toneladas;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Float getToneladas() {
        return toneladas;
    }

    public void setToneladas(Float toneladas) {
        this.toneladas = toneladas;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
