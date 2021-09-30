package com.example.feiraslivres.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeiraLivreQueryRequest {

    private String distrito;

    private String regiao5;

    private String nomeFeira;

    private String bairro;
}
