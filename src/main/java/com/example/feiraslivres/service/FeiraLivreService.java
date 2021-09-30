package com.example.feiraslivres.service;

import com.example.feiraslivres.converter.FeiraLivreDTORequestConverter;
import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.dto.FeiraLivreQueryRequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.exception.EmptyObjectException;
import com.example.feiraslivres.repository.FeiraLivreRepository;
import com.example.feiraslivres.specification.FeiraLivreSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FeiraLivreService {

    private final FeiraLivreRepository feiraLivreRepository;
    private final FeiraLivreSpecification feiraLivreSpecification;
    private final FeiraLivreDTORequestConverter feiraLivreDTORequestConverter;

    public FeiraLivre createFeiraLivre(final FeiraLivreDTORequest feiraLivreDTORequest){
        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(feiraLivreDTORequest);
        if(Objects.isNull(feiraLivre)){
            throw new EmptyObjectException();
        }
        return feiraLivreRepository.save(feiraLivre);
    }

    public void deleteFeiraLivre(final Long id){
        feiraLivreRepository.deleteById(id);
    }

    public FeiraLivre updateFeiraLivre(final Long id, final FeiraLivreDTORequest feiraLivreDTORequest){
        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(id, feiraLivreDTORequest);
        if(Objects.isNull(feiraLivre)){
            throw new EmptyObjectException();
        }
        return feiraLivreRepository.save(feiraLivre);
    }

    public List<FeiraLivre> findFeiraLivre(final String distrito, final String regiao5, final String nomeFeira, final String bairro){
        final FeiraLivreQueryRequest feiraLivreQueryRequest = FeiraLivreQueryRequest.builder()
                .nomeFeira(nomeFeira)
                .bairro(bairro)
                .distrito(distrito)
                .regiao5(regiao5)
                .build();
        return feiraLivreRepository.findAll(feiraLivreSpecification.getFeirasLivres(feiraLivreQueryRequest));
    }
}