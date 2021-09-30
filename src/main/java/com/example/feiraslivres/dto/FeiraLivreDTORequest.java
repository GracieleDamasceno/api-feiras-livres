package com.example.feiraslivres.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeiraLivreDTORequest {

    private String longitude;

    private String latitude;

    @JsonProperty(value = "setor_censitario")
    private String setorCensitario;

    @JsonProperty(value = "area_ponderacao")
    private String areaPonderacao;

    @JsonProperty(value = "codigo_distrito")
    private String codigoDistrito;

    private String distrito;

    @JsonProperty(value = "codigo_subprefeitura")
    private String codigoSubprefeitura;

    private String subprefeitura;

    private String regiao5;

    private String regiao8;

    @JsonProperty(value = "nome_feira")
    private String nomeFeira;

    private String registro;

    private String logradouro;

    private String numero;

    private String bairro;

    private String referencia;
}
