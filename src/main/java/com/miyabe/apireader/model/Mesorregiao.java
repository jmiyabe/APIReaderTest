package com.miyabe.apireader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesorregiao {
    private Long id;
    private String nome;

    @JsonProperty("UF")
    private Estado UF;

    public Mesorregiao(Long id, String nome, Estado UF) {
        this.id = id;
        this.nome = nome;
        this.UF = UF;
    }

    public Mesorregiao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getUF() {
        return UF;
    }

    public void setUF(Estado UF) {
        this.UF = UF;
    }
}
