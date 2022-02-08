package com.api.vagasest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "VG_VAGAS") // nome da tabela na base de dados!
public class VagasModels implements Serializable {

    private static final long serialVersionUID = 1L; // ID do serializable!

    //colunas a serem criadas na base de dados!
    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String vagasNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String placaVeiculo;
    @Column(nullable = false, length = 70)
    private String marcaVeiculo;
    @Column(nullable = false, length = 70)
    private String modeloVeiculo;
    @Column(nullable = false, length = 70)
    private String corVeiculo;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsavelName;
    @Column(nullable = false, length = 30)
    private String apartamento;
    @Column(nullable = false, length = 30)
    private String bloco;

//obs: para quem estiver utilizando lombok é só utilizar as anotações!


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVagasNumber() {
        return vagasNumber;
    }

    public void setVagasNumber(String vagasNumber) {
        this.vagasNumber = vagasNumber;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsavelName() {
        return responsavelName;
    }

    public void setResponsavelName(String responsavelName) {
        this.responsavelName = responsavelName;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
}
