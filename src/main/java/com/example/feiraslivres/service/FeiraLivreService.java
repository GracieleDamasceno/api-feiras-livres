package com.example.feiraslivres.service;

import com.example.feiraslivres.converter.FeiraLivreDTORequestConverter;
import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.dto.FeiraLivreQueryRequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.exception.EmptyObjectException;
import com.example.feiraslivres.repository.FeiraLivreRepository;
import com.example.feiraslivres.specification.FeiraLivreSpecification;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Log4j2
@Service
@AllArgsConstructor
public class FeiraLivreService {

    private final FeiraLivreRepository feiraLivreRepository;
    private final FeiraLivreSpecification feiraLivreSpecification;
    private final FeiraLivreDTORequestConverter feiraLivreDTORequestConverter;

    public FeiraLivre createFeiraLivre(final FeiraLivreDTORequest feiraLivreDTORequest){
        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(feiraLivreDTORequest);

        if(Objects.isNull(feiraLivre)){
            log.info("ERROR - CREATE_FEIRA_LIVRE: Attempt to convert the following request resulted in null object: {}",
                    feiraLivreDTORequest.toString());
            throw new EmptyObjectException();
        }
        log.info("INFO - CREATE_FEIRA_LIVRE: Request converted to following entity: {}",feiraLivre.toString());
        return feiraLivreRepository.save(feiraLivre);
    }

    public void deleteFeiraLivre(final Long id){
        feiraLivreRepository.deleteById(id);
    }

    public FeiraLivre updateFeiraLivre(final Long id, final FeiraLivreDTORequest feiraLivreDTORequest){
        final FeiraLivre feiraLivre = feiraLivreDTORequestConverter.convert(id, feiraLivreDTORequest);

        if(Objects.isNull(feiraLivre)){
            log.info("ERROR - UPDATE_FEIRA_LIVRE: Attempt to convert the following request resulted in null object: {}",
                    feiraLivreDTORequest.toString());
            throw new EmptyObjectException();
        }

        log.info("INFO - UPDATE_FEIRA_LIVRE: Request converted to following entity: {}", feiraLivre.toString());
        return feiraLivreRepository.save(feiraLivre);
    }

    public List<FeiraLivre> findFeiraLivre(final String distrito, final String regiao5, final String nomeFeira, final String bairro){
        final FeiraLivreQueryRequest feiraLivreQueryRequest = FeiraLivreQueryRequest.builder()
                .nomeFeira(nomeFeira)
                .bairro(bairro)
                .distrito(distrito)
                .regiao5(regiao5)
                .build();

        log.info("INFO - FIND_FEIRA_LIVRE: Request of search converted to following entity: {}", feiraLivreQueryRequest.toString());
        return feiraLivreRepository.findAll(feiraLivreSpecification.getFeirasLivres(feiraLivreQueryRequest));
    }
}