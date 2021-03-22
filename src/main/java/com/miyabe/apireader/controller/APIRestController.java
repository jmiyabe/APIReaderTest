package com.miyabe.apireader.controller;

import com.miyabe.apireader.dto.CidateDTO;
import com.miyabe.apireader.model.Estado;
import com.miyabe.apireader.service.apiService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value= "RestAPI")
public class APIRestController {

    @Autowired
    private apiService service;

    public APIRestController(apiService service){
        this.service = service;
    }

    @ApiOperation(value = "Retorna todos os municipios")
    @RequestMapping(method = RequestMethod.GET, value = "/municipios")
    public ResponseEntity<List<CidateDTO>> getMunicipios(){
        return new ResponseEntity<>(service.getMunicipios(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna todos os estados")
    @RequestMapping(method = RequestMethod.GET, value = "/estados")
    public ResponseEntity<List<Estado>> getEstados(){
        return new ResponseEntity<>(service.getEstados(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna todas as cidades utilizando os estados")
    @RequestMapping(method = RequestMethod.GET, value= "/cidades")
    public ResponseEntity<List<List<CidateDTO>>> getCidades(){
        return new ResponseEntity<>(service.getCidades(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna o Id do municipio passado por parâmetro. ex:Porto-Alegre")
    @RequestMapping(method = RequestMethod.GET, value = "municipio/{nomeCidade}")
    @Cacheable("municipio")
    public ResponseEntity<Long> getMunicipioID(@PathVariable("nomeCidade") String nomeCidade){
        return new ResponseEntity<>(service.getMunicipioId(nomeCidade),HttpStatus.OK);
    }

    @ApiOperation(value = "Gera um CSV dos municipios")
    @RequestMapping(method = RequestMethod.GET, value = "/municipios/csv")
    public void getCSV() throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        service.convertToCSV();
    }
}
