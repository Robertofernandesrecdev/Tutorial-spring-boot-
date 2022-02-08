package com.api.vagasest.repositories;

import com.api.vagasest.models.VagasModels;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.UUID;

//estendendo o JpaRepository, tem metodos prontos para utilizar, simplificando evitando de ter que criar cada um desses metodos.
@Repository
public interface VagasRepository extends JpaRepository<VagasModels, UUID> {

    boolean existsByPlacaVeiculo(String placaVeiculo);
    boolean existsByVagasNumber(String vagasNumber);
    boolean existsByApartamentoAndBloco(String apartamento, String bloco);


}
