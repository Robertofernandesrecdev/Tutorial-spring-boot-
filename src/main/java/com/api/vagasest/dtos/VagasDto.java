// tratamentos dos dados de entrada! validações
// para fazer essas verificações que usamos o validation nas depedencias
package com.api.vagasest.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VagasDto {

    @NotBlank       // verifica se o campo não é nulo nem tem string vazia.
    private String vagasNumber;
    @NotBlank
    @Size(max = 7)        // limita o número de caracters
    private String placaVeiculo;
    @NotBlank
    private String marcaVeiculo;
    @NotBlank
    private String modeloVeiculo;
    @NotBlank
    private String corVeiculo;
    @NotBlank
    private String responsavelName;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;


    //obs: para quem estiver utilizando lombok é só utilizar as anotações!


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
