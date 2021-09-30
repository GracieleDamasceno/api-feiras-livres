package com.example.feiraslivres.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeiraLivre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

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
