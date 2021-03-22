package com.miyabe.apireader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Municipio {
    private Long id;
    private String nome;

    @JsonProperty("microrregiao")
    private Microrregiao microrregiao;

    public Municipio(Long id, String nome, Microrregiao microrregiao) {
        this.id = id;
        this.nome = nome;
        this.microrregiao = microrregiao;
    }

    public Municipio() {}

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

    public Microrregiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Microrregiao microrregiao) {
        this.microrregiao = microrregiao;
    }
}
