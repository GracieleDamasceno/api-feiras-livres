package com.example.feiraslivres.converter;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.exception.ConverterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/*
 * In this class theres also room for improvement: add assertions to validate exceptions, test method naming conventions,
 * problems in converting the payload and the logic inside the method which accepts an ID.
 */

@ExtendWith(MockitoExtension.class)
class FeiraLivreDTORequestConverterTest {

    @InjectMocks
    private FeiraLivreDTORequestConverter feiraLivreDTORequestConverter;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void returns_convertedFeiraLivre_when_convertFromFeiraLivreDTORequestIsCalled() {
        final FeiraLivre validFeiraLivre = getValidFeiraLivre();

        when(modelMapper.map(any(), eq(FeiraLivre.class))).thenReturn(validFeiraLivre);

        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(getValidFeiraLivreRequest());

        assertThat(feiraLivre).isNotNull().isEqualTo(validFeiraLivre);
    }

    @Test
    void returns_converterException_when_runtimeExceptionIsThrownInConvertFromRequest() {
        when(modelMapper.map(any(), eq(FeiraLivre.class))).thenThrow(RuntimeException.class);

        assertThrows(ConverterException.class, () ->
                feiraLivreDTORequestConverter.convert(getValidFeiraLivreRequest()));
    }

    @Test
    void returns_convertedFeiraLivre_when_convertFromFeiraLivreDTORequestWithIdIsCalled() {
        final FeiraLivre validFeiraLivre = getValidFeiraLivre();

        when(modelMapper.map(any(), eq(FeiraLivre.class))).thenReturn(validFeiraLivre);

        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(1L, getValidFeiraLivreRequest());

        assertThat(feiraLivre).isNotNull().isEqualTo(validFeiraLivre);
    }


    @Test
    void returns_converterException_when_runtimeExceptionIsThrownInConvertFromRequestWithId() {
        when(modelMapper.map(any(), eq(FeiraLivre.class))).thenThrow(RuntimeException.class);

        assertThrows(ConverterException.class, () ->
                feiraLivreDTORequestConverter.convert(1L, getValidFeiraLivreRequest()));
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