package com.api.vagasest.controllers;

import com.api.vagasest.dtos.VagasDto;
import com.api.vagasest.models.VagasModels;
import com.api.vagasest.services.VagasService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600 ) // permite que seja acessado de qualquer fonte.
@RequestMapping("/vagas")        //define a URI a nivel de classe.
public class VagasController {

    final VagasService vagasService;

    //ponto de injeção para vagasService via construtor
    public VagasController(VagasService vagasService) {
        this.vagasService = vagasService;
    }

    //metodo post
    @PostMapping
    public ResponseEntity<Object> saveVagas(@RequestBody @Valid VagasDto vagasDto){

       //verificação se há algum registro no banco, para não fazer registros duplicados.

        if(vagasService.existsByPlacaVeiculo(vagasDto.getPlacaVeiculo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: placa já em uso!");
        }
        if (vagasService.existsByVagasNumber(vagasDto.getVagasNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Numero da vaga já em uso!");
        }
        if (vagasService.existsByApartamentoAndBloco(vagasDto.getApartamento(), vagasDto.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: vagas registrada para este apartamento/bloco!");
       }
        var vagasModel = new VagasModels();
        BeanUtils.copyProperties(vagasDto, vagasModel);
        vagasModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vagasService.save(vagasModel));



    }


     //Metodo GET


        @GetMapping
        public ResponseEntity<List<VagasModels>> getAllVagas(){
        return ResponseEntity.status(HttpStatus.OK).body(vagasService.findAll());


    /*
    // Metodo GET              // ir em Service fazer os ajustes no metodo findAll                          //paginação
        @GetMapping
        public ResponseEntity<List<VagasModels>> getAllVagas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(vagasService.findAll());
*/
    }

    //Metodo GET por Id e verificação se o id já existe!

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVagas(@PathVariable(value = "id") UUID id){
        Optional<VagasModels> vagasModelsOptional = vagasService.findById(id);
        if(!vagasModelsOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vagas not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vagasModelsOptional.get());
    }


    // Metodo Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVagas(@PathVariable(value = "id") UUID id){
        Optional<VagasModels> vagasModelsOptional = vagasService.findById(id);
        if (!vagasModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vagas not found.");
        }
        vagasService.delete(vagasModelsOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vaga deleted successfully.");
    }


    //Metodo PUt update
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVagas(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid VagasDto vagasDto){
        Optional<VagasModels> vagasModelsOptional = vagasService.findById(id);
        if (!vagasModelsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga not found.");
        }
        var vagaModel = new VagasModels();
        BeanUtils.copyProperties(vagasDto, vagaModel);
        vagaModel.setId(vagasModelsOptional.get().getId());
        vagaModel.setRegistrationDate(vagasModelsOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(vagasService.save(vagaModel));
    }


}
