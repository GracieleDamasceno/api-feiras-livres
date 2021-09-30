package com.example.feiraslivres.specification;

import com.example.feiraslivres.dto.FeiraLivreQueryRequest;
import com.example.feiraslivres.entity.FeiraLivre;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FeiraLivreSpecification {

    public Specification<FeiraLivre> getFeirasLivres(final FeiraLivreQueryRequest request){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(request.getNomeFeira() != null && !request.getNomeFeira().isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("nomeFeira"), request.getNomeFeira()));
            }
            if(request.getDistrito() != null && !request.getDistrito().isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("distrito"), request.getDistrito()));
            }
            if(request.getRegiao5() != null && !request.getRegiao5().isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("regiao5"), request.getRegiao5()));
            }
            if(request.getBairro() != null && !request.getBairro().isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("bairro"), request.getBairro()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
