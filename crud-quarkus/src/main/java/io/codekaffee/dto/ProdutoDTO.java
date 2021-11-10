package io.codekaffee.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String nome;
    private BigDecimal valor;

    public ProdutoDTO(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public ProdutoDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
