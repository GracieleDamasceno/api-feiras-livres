package com.example.feiraslivres.controller;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.service.FeiraLivreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * In order to allow simplicity of the POC, we are limiting our test clauses to fulfil a good code coverage threshold.
 * However, this does not reflect how to correct test all functionalities.
 * For example, here in the controller we should test at least the following scenarios (and perform the following improvements):
 *
 *  - Create tests to check if the endpoint responds correctly when user sends invalid output
 *  - Create tests to assert if correct exceptions are being thrown
 *  - Remove redundancy and improve objects of test
 *  - Improve and define pattern for tests naming convention
 *
 * and so on..
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FeiraLivreController.class)
@AutoConfigureWebClient(registerRestTemplate = true)
class FeiraLivreControllerTest {

    @MockBean
    private FeiraLivreService feiraLivreService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    private static final String FEIRA_LIVRE_ENDPOINT = "/feira-livre/";

    @Test
    void returns_httpStatus200_when_successfulSave() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        when(feiraLivreService.createFeiraLivre(getValidFeiraLivreRequest())).thenReturn(getValidFeiraLivre());

        mockMvc.perform(post(FEIRA_LIVRE_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getValidFeiraLivreRequest())))
                        .andExpect(status().isOk());
    }

    @Test
    void returns_httpStatus200_when_successfulDeletion() throws Exception {
        mockMvc.perform(delete(FEIRA_LIVRE_ENDPOINT+"1"))
                .andExpect(status().isOk());
    }

    @Test
    void returns_updatedFeiraLivre_when_successfulUpdate() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        when(feiraLivreService.updateFeiraLivre(1L, getValidFeiraLivreRequest())).thenReturn(getValidFeiraLivre());

        mockMvc.perform(put(FEIRA_LIVRE_ENDPOINT+"1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getValidFeiraLivreRequest())))
                .andExpect(status().isOk());
    }

    @Test
    void returns_filteredFeirasLivres_when_successfulFind() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        when(feiraLivreService.findFeiraLivre(null, "Oeste", null, "BRAS"))
                .thenReturn(List.of(getValidFeiraLivre()));

        mockMvc.perform(get("/feira-livre?regiao5=Oeste&distrito=BRAS")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getValidFeiraLivreRequest())))
                .andExpect(status().isOk());
    }


    private FeiraLivreDTORequest getValidFeiraLivreRequest(){
        return FeiraLivreDTORequest.builder()
                .longitude("-46444519")
                .latitude("-23519118")
                .setorCensitario("355030837000160")
                .areaPonderacao("3550308005200")
                .codigoDistrito("36")
                .distrito("BRAS")
                .codigoSubprefeitura("01")
                .subprefeitura("DISTRITO")
                .regiao5("Oeste")
                .regiao8("Oeste 2")
                .nomeFeira("SUPER FEIRA")
                .registro("7717-6")
                .logradouro("RUA DO DISTRITO")
                .numero("S/N")
                .bairro("AURORA")
                .referencia("EM MEIO DA QUADRA 07")
                .build();
    }

    private FeiraLivre getValidFeiraLivre(){
        return FeiraLivre.builder()
                .id(1L)
                .longitude("-46444519")
                .latitude("-23519118")
                .setorCensitario("355030837000160")
                .areaPonderacao("3550308005200")
                .codigoDistrito("36")
                .distrito("BRAS")
                .codigoSubprefeitura("01")
                .subprefeitura("DISTRITO")
                .regiao5("Oeste")
                .regiao8("Oeste 2")
                .nomeFeira("SUPER FEIRA")
                .registro("7717-6")
                .logradouro("RUA DO DISTRITO")
                .numero("S/N")
                .bairro("AURORA")
                .referencia("EM MEIO DA QUADRA 07")
                .build();
    }
}

