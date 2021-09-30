package com.example.feiraslivres.repository;

import com.example.feiraslivres.entity.FeiraLivre;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeiraLivreRepository extends JpaRepository<FeiraLivre, Long>, JpaSpecificationExecutor<FeiraLivre> {

    List<FeiraLivre> findAll(Specification<FeiraLivre> specification);
}
