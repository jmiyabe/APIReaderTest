package com.miyabe.apireader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Microrregiao {
    private Long id;
    private String nome;

    @JsonProperty("mesorregiao")
    private Mesorregiao mesorregiao;

    public Microrregiao(Long id, String nome, Mesorregiao mesorregiao) {
        this.id = id;
        this.mesorregiao = mesorregiao;
        this.nome = nome;
    }

    public Microrregiao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesorregiao getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(Mesorregiao mesorregiao) {
        this.mesorregiao = mesorregiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
