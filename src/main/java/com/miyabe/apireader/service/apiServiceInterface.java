package com.miyabe.apireader.service;

import com.miyabe.apireader.dto.CidateDTO;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public interface apiServiceInterface {
    public List<List<CidateDTO>> getCidades();
    public List<CidateDTO> getMunicipios();
    public Long getMunicipioId(String nomeCidade);
    public void convertToCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

}
