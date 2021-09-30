package com.example.feiraslivres.controller;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.service.FeiraLivreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feira-livre")
@AllArgsConstructor
public class FeiraLivreController {

    private final FeiraLivreService feiraLivreService;

    @PostMapping
    public ResponseEntity<?> createFeiraLivre(@RequestBody FeiraLivreDTORequest request){
        return new ResponseEntity<>(feiraLivreService.createFeiraLivre(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeiraLivre(@PathVariable Long id){
        feiraLivreService.deleteFeiraLivre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeiraLivre(@PathVariable Long id, @RequestBody FeiraLivreDTORequest request){
        return new ResponseEntity<>(feiraLivreService.updateFeiraLivre(id, request), HttpStatus.OK);
    }

   @GetMapping
    public ResponseEntity<?> findFeiraLivre(@RequestParam(value = "distrito", required = false) String distrito ,
                                            @RequestParam(value = "regiao5", required = false) String regiao5,
                                            @RequestParam(value = "nome_feira", required = false) String nomeFeira,
                                            @RequestParam(value = "bairro", required = false) String bairro){
        return new ResponseEntity<>(feiraLivreService.findFeiraLivre(distrito, regiao5, nomeFeira, bairro), HttpStatus.OK);
    }
}
