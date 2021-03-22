package com.miyabe.apireader.service;

import com.miyabe.apireader.Constants;
import com.miyabe.apireader.dto.CidateDTO;
import com.miyabe.apireader.model.Estado;
import com.miyabe.apireader.model.Municipio;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Service
public class apiService implements apiServiceInterface{

    @Autowired
    WebClient webClient;
    public List<List<CidateDTO>> getCidades(){
        List<Estado> estadoList = getEstados();
        List<List<CidateDTO>> cidadesList = new ArrayList<>();
        for (Estado estado: estadoList) {
            cidadesList.add(getCidadesDTOList(webClient
                    .method(HttpMethod.GET)
                    .uri(Constants.ESTADOS + "/" + estado.getSigla()+ "/" + Constants.MUNICIPIOS)
                    .retrieve()
                    .bodyToFlux(Municipio.class)
                    .collectList()
                    .block()));
        }
        return cidadesList;
    }


    @Override
    public List<CidateDTO> getMunicipios(){
        List<Municipio> municipiosList = webClient
                .method(HttpMethod.GET)
                .uri("/" + Constants.MUNICIPIOS)
                .retrieve()
                .bodyToFlux(Municipio.class)
                .collectList()
                .block();

        return getCidadesDTOList(municipiosList);
    }

    private List<CidateDTO> getCidadesDTOList(List<Municipio> municipioList){
        List<CidateDTO> cidateDTOList = new ArrayList<>();
        if (municipioList.size() > 0){
            for (Municipio municipio: municipioList) {
                CidateDTO cidateDTO = new CidateDTO(municipio);
                cidateDTOList.add(cidateDTO);
            }
        }
        return cidateDTOList;
    }

    public List<Estado> getEstados(){
         return webClient
                 .method(HttpMethod.GET)
                 .uri(Constants.ESTADOS)
                 .retrieve()
                 .bodyToFlux(Estado.class)
                 .collectList()
                 .block();

    }

    public Long getMunicipioId(String nomeCidade){
        return webClient
                .method(HttpMethod.GET)
                .uri(Constants.MUNICIPIOS + "/" + nomeCidade)
                .retrieve()
                .bodyToMono(Municipio.class)
                .block().getId();
    }

    public void convertToCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter("cidades.csv");
        StatefulBeanToCsv csvBean = new StatefulBeanToCsvBuilder(writer).build();
        List<CidateDTO> list = getMunicipios();
        for(CidateDTO cidateDTO: list){
            csvBean.write(cidateDTO);
        }
        writer.close();
    }

}
