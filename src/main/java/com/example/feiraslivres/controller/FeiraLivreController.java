package com.example.feiraslivres.controller;

import com.example.feiraslivres.dto.FeiraLivreDTORequest;
import com.example.feiraslivres.service.FeiraLivreService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/feira-livre")
@AllArgsConstructor
public class FeiraLivreController {

    private final FeiraLivreService feiraLivreService;

    @PostMapping
    public ResponseEntity<?> createFeiraLivre(@RequestBody FeiraLivreDTORequest request){
        log.info("INFO - CREATE_FEIRA_LIVRE: Received the following request to create a FeiraLivre: "+request.toString());
        return new ResponseEntity<>(feiraLivreService.createFeiraLivre(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeiraLivre(@PathVariable Long id){
        log.info("INFO - DELETE_FEIRA_LIVRE: Received the following request to delete a FeiraLivre: "+id);
        feiraLivreService.deleteFeiraLivre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFeiraLivre(@PathVariable Long id, @RequestBody FeiraLivreDTORequest request){
        log.info("INFO - UPDATE_FEIRA_LIVRE: Received the following request to update FeiraLivre " +
                "of id {} to new entity: {} ", id, request.toString());
        return new ResponseEntity<>(feiraLivreService.updateFeiraLivre(id, request), HttpStatus.OK);
    }

   @GetMapping
    public ResponseEntity<?> findFeiraLivre(@RequestParam(value = "distrito", required = false) String distrito ,
                                            @RequestParam(value = "regiao5", required = false) String regiao5,
                                            @RequestParam(value = "nome_feira", required = false) String nomeFeira,
                                            @RequestParam(value = "bairro", required = false) String bairro){
       log.info("INFO - FIND_FEIRA_LIVRE: Received the following request to search FeiraLivre using the following parameters: " +
               "distrito: {}, regiao5: {}, nomeFeira: {}, bairro: {}", distrito, regiao5, nomeFeira, bairro);

       return new ResponseEntity<>(feiraLivreService.findFeiraLivre(distrito, regiao5, nomeFeira, bairro), HttpStatus.OK);
    }
}
