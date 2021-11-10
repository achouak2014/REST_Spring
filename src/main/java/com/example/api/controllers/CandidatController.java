package com.example.api.controllers;

import com.example.api.models.Candidat;
import com.example.api.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatRepository candidatRepository ;

//GET
    @GetMapping (value = "/")
    List<Candidat>all(){
        return candidatRepository.findAll();
    }
    @GetMapping(value = "/{candidat}")
    Candidat getOne(@PathVariable(name = "candidat", required = false)Candidat candidat){
        if(candidat == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Candidat introuvable"
            );
        }
        else {
            return  candidat ;
        }
    }
    /*
    @GetMapping(value = "/{id}")
    Candidat getById(@PathVariable(name = "id",required = false)Long id ){
        Optional<Candidat> candidat = candidatRepository.findById(id);
        return candidat.get();
    }
   */
    //POST
    @PostMapping (value = "/")
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else{
            candidatRepository.save(candidat);
            return new ResponseEntity<>(candidat,HttpStatus.CREATED);
        }
    }

    //PUT
    @PutMapping(value = "/{candidat}")
    public ResponseEntity<Candidat> update(@PathVariable(name = "candidat", required = false)Candidat candidat,
                                           @Valid @RequestBody Candidat candidatUpdate, BindingResult bindingResult){
        if(candidat== null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cnadidat introvable"
            );
        }
        else {
            if(bindingResult.hasErrors()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else {
                candidatUpdate.setId(candidat.getId());
                candidatRepository.save(candidatUpdate);
                return new ResponseEntity<>(candidatUpdate,HttpStatus.OK);
            }
        }
    }

    //DELETE
    @DeleteMapping(value = "/{candidat}")
    public void deleteOne(@PathVariable(name = "candidat", required = false) Candidat candidat) {
        if (candidat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );
        }else {
            candidatRepository.delete(candidat);
        }
    }

}
