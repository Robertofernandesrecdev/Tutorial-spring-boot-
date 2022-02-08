package com.api.vagasest.services;


import com.api.vagasest.models.VagasModels;
import com.api.vagasest.repositories.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class VagasService {

    //criando via construtor! Reitra a anotação @Autowired.

    final VagasRepository vagasRepository;

    public VagasService(VagasRepository vagasRepository){
        this.vagasRepository =vagasRepository;
    }

    @Transactional
    public VagasModels save(VagasModels vagasModel) {
        return vagasRepository.save(vagasModel);
    }

    // Este metodo precisa ser declarado dentro do repository
    public boolean existsByPlacaVeiculo(String placaVeiculo) {
        return vagasRepository.existsByPlacaVeiculo(placaVeiculo);
    }

    public boolean existsByVagasNumber(String vagasNumber) {
        return vagasRepository.existsByVagasNumber(vagasNumber);
    }

    public boolean existsByApartamentoAndBloco(String apartamento, String bloco) {
        return vagasRepository.existsByApartamentoAndBloco(apartamento, bloco);
    }

    public List<VagasModels> findAll() {
       return vagasRepository.findAll();
    }

    public Optional<VagasModels> findById(UUID id) {
        return vagasRepository.findById(id);
    }

    @Transactional
    public void delete(VagasModels vagasModels) {
        vagasRepository.delete(vagasModels);

    }
}

/*@Service
public class VagasService {

    @Autowired  // cria o ponto de injeção, injeta dependência de VagasRepository dentro de VagasService
    VagasRepository vagasRepository;

}*/

