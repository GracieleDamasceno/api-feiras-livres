package com.example.feiraslivres.converter;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.entity.FeiraLivre;
import com.example.feiraslivres.exception.ConverterException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FeiraLivreDTORequestConverter implements Converter<FeiraLivreDTORequest, FeiraLivre> {

    private final ModelMapper modelMapper;

    @Override
    public FeiraLivre convert(final FeiraLivreDTORequest source) {
        try{
            return modelMapper.map(source, FeiraLivre.class);
        }catch (RuntimeException runtimeException){
            throw new ConverterException();
        }
    }

    public FeiraLivre convert(final Long id, final FeiraLivreDTORequest source) {
        try{
            FeiraLivre map = modelMapper.map(source, FeiraLivre.class);
            map.setId(id);

            return map;
        }catch (RuntimeException runtimeException){
            throw new ConverterException();
        }
    }
}
