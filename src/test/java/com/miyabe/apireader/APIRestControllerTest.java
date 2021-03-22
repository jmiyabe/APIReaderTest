package com.miyabe.apireader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class APIRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMunicipios() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/municipios")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].idEstado").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].siglaEstado").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].regiaoNome").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].nomeCidade").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].nomeMesorregiao").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].nomeFormatado").isNotEmpty());
    }

    @Test
    public void testMunicipioPorNome() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/municipio/Ivoti")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("4310801"));
    }

    @Test
    public void testEstados() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/estados")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].sigla").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].regiao.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*]..regiao.nome").isNotEmpty());
    }
}
