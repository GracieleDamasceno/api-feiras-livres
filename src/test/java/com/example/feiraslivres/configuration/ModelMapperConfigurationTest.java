package com.example.feiraslivres.configuration;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.entity.FeiraLivre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModelMapperConfigurationTest {

    private ModelMapperConfiguration modelMapper = new ModelMapperConfiguration();

    @Test
    void testModelMapper() {
        final FeiraLivre feiraLivre = modelMapper.modelMapper().map(getValidFeiraLivreRequest(), FeiraLivre.class);
        Assertions.assertEquals("-46444519", feiraLivre.getLongitude());
        Assertions.assertEquals("-23519118", feiraLivre.getLatitude());
        Assertions.assertEquals("355030837000160", feiraLivre.getSetorCensitario());
        Assertions.assertEquals("3550308005200", feiraLivre.getAreaPonderacao());
        Assertions.assertEquals("36", feiraLivre.getCodigoDistrito());
        Assertions.assertEquals("BRAS", feiraLivre.getDistrito());
        Assertions.assertEquals("01", feiraLivre.getCodigoSubprefeitura());
        Assertions.assertEquals("DISTRITO", feiraLivre.getSubprefeitura());
        Assertions.assertEquals("Oeste", feiraLivre.getRegiao5());
        Assertions.assertEquals("Oeste 2", feiraLivre.getRegiao8());
        Assertions.assertEquals("SUPER FEIRA", feiraLivre.getNomeFeira());
        Assertions.assertEquals("7717-6", feiraLivre.getRegistro());
        Assertions.assertEquals("RUA DO DISTRITO", feiraLivre.getLogradouro());
        Assertions.assertEquals("S/N", feiraLivre.getNumero());
        Assertions.assertEquals("AURORA", feiraLivre.getBairro());
        Assertions.assertEquals("EM MEIO DA QUADRA 07", feiraLivre.getReferencia());
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
}