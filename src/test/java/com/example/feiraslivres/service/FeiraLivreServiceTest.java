package com.example.feiraslivres.service;

import com.example.feiraslivres.converter.FeiraLivreDTORequestConverter;
import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.exception.EmptyObjectException;
import com.example.feiraslivres.repository.FeiraLivreRepository;
import com.example.feiraslivres.specification.FeiraLivreSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/*
 * In order to allow simplicity in the POC, we are limiting our test clauses to fulfil a good code coverage threshold.
 * However, this does not reflect how to correct test all functionalities.
 * For example, here in the service we should test at least the following scenarios (and perform the following improvements):
 *
 *  - Create tests to check if the method responds correctly if wrong input is received
 *  - Create tests to assert if inner operations inside service are correct
 *  - Create tests to assert if correct exceptions are being thrown
 *  - Remove redundancy and improve objects of test
 *  - Improve and define pattern for tests naming convention
 *
 * and so on..
 */

@ExtendWith(SpringExtension.class)
class FeiraLivreServiceTest {

    @InjectMocks
    private FeiraLivreService feiraLivreService;

    @Mock
    private FeiraLivreRepository feiraLivreRepository;

    @Mock
    private FeiraLivreSpecification feiraLivreSpecification;

    @Mock
    private FeiraLivreDTORequestConverter feiraLivreDTORequestConverter;

    @Test
    void returns_validFeiraLivre_when_createFeiraLivreIsCalled() {
        final FeiraLivre mockFeiraLivre = getValidFeiraLivre();
        when(feiraLivreDTORequestConverter.convert(any())).thenReturn(mockFeiraLivre);
        when(feiraLivreRepository.save(mockFeiraLivre)).thenReturn(mockFeiraLivre);

        final FeiraLivre feiraLivre = feiraLivreService.createFeiraLivre(getValidFeiraLivreRequest());

        assertThat(feiraLivre).isNotNull().isEqualTo(mockFeiraLivre);
    }

    @Test
    void returns_emptyObjectException_when_invalidFeiraLivreIsReceivedOnCreation() {
        final FeiraLivre mockFeiraLivre = getValidFeiraLivre();
        when(feiraLivreDTORequestConverter.convert(any())).thenReturn(null);
        when(feiraLivreRepository.save(mockFeiraLivre)).thenReturn(mockFeiraLivre);

        assertThrows(EmptyObjectException.class, () ->
                feiraLivreService.createFeiraLivre(getValidFeiraLivreRequest()));
    }

    @Test
    void returns_successfully_when_deleteFeiraLivreIsCalled() {
        doNothing().when(feiraLivreRepository).deleteById(1L);
        feiraLivreService.deleteFeiraLivre(1L);
        verify(feiraLivreRepository, times(1)).deleteById(1L);
    }

    @Test
    void returns_updatedFeiraLivre_when_updateFeiraLivreIsCalled() {
        final FeiraLivre mockFeiraLivre = getValidFeiraLivre();
        when(feiraLivreDTORequestConverter.convert(eq(1L), any())).thenReturn(mockFeiraLivre);
        when(feiraLivreRepository.save(mockFeiraLivre)).thenReturn(mockFeiraLivre);

        final FeiraLivre feiraLivre = feiraLivreService.updateFeiraLivre(1L, getValidFeiraLivreRequest());

        assertThat(feiraLivre).isNotNull().isEqualTo(mockFeiraLivre);
    }

    @Test
    void returns_emptyObjectException_when_invalidFeiraLivreIsReceivedOnUpdate() {
        final FeiraLivre mockFeiraLivre = getValidFeiraLivre();
        when(feiraLivreDTORequestConverter.convert(eq(1L), any())).thenReturn(null);
        when(feiraLivreRepository.save(mockFeiraLivre)).thenReturn(mockFeiraLivre);

        assertThrows(EmptyObjectException.class, () ->
                feiraLivreService.updateFeiraLivre(1L, getValidFeiraLivreRequest()));
    }

    @Test
    void returns_filteredFeiraLivre_when_getFeiraLivreIsCalled() {
        final String regiao5 = "Oeste",  bairro = "BRAS";

        final List<FeiraLivre> validFeiraLivre = List.of(getValidFeiraLivre());

        when(feiraLivreRepository.findAll(feiraLivreSpecification.getFeirasLivres(any()))).thenReturn(validFeiraLivre);

        final List<FeiraLivre> feirasLivres = feiraLivreService.findFeiraLivre(null, regiao5, null, bairro);

        assertThat(feirasLivres).isNotNull().isEqualTo(validFeiraLivre).hasSize(1);
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