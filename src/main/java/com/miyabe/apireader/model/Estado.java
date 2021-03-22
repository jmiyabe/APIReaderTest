package com.miyabe.apireader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estado {

    private Long id;
    private String sigla;

    @JsonProperty("regiao")
    private Regiao regiao;

    public Estado(Long id, String sigla, Regiao regiao) {
        this.id = id;
        this.sigla = sigla;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}
