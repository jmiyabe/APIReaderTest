package com.miyabe.apireader.dto;

import com.miyabe.apireader.model.Estado;
import com.miyabe.apireader.model.Municipio;
import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class CidateDTO implements Serializable {

    @CsvBindByName(column = "1_idEstado")
    private Long idEstado;

    @CsvBindByName(column = "2_siglaEstado")
    private String siglaEstado;

    @CsvBindByName(column = "3_regiaoNome")
    private String regiaoNome;

    @CsvBindByName(column = "4_nomeCidade")
    private String nomeCidade;

    @CsvBindByName(column = "5_nomeMesorregiao")
    private String nomeMesorregiao;

    @CsvBindByName(column = "6_nomeFormatado")
    private String nomeFormatado;       // {cidade/UF}

    public CidateDTO(Municipio municipio){
        Estado UF = municipio.getMicrorregiao().getMesorregiao().getUF();
        setIdEstado(UF.getId());
        setSiglaEstado(UF.getSigla());
        setRegiaoNome(UF.getRegiao().getNome());
        setNomeCidade(municipio.getNome());
        setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
        setNomeFormatado(getNomeCidade()+ "/" + UF.getSigla());
    }

    public CidateDTO(){}

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(String regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public void setNomeMesorregiao(String nomeMesorregiao) {
        this.nomeMesorregiao = nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public void setNomeFormatado(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }
}
