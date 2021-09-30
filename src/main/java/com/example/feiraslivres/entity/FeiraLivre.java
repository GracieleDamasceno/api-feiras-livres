package com.example.feiraslivres.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class FeiraLivre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String longitude;

    private String latitude;

    private String setorCensitario;

    private String areaPonderacao;

    private String codigoDistrito;

    private String distrito;

    private String codigoSubprefeitura;

    private String subprefeitura;

    private String regiao5;

    private String regiao8;

    private String nomeFeira;

    private String registro;

    private String logradouro;

    private String numero;

    private String bairro;

    private String referencia;
}
