/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ridic
 */
public class Veiculo {

    private int cd_veiculo;
    private int proprietario;
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo() {
    }

    public Veiculo(int cd_veiculo, int proprietario, String modelo, String placa, int ano) {
        this.cd_veiculo = cd_veiculo;
        this.proprietario = proprietario;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public int getCd_veiculo() {
        return cd_veiculo;
    }

    public void setCd_veiculo(int cd_veiculo) {
        this.cd_veiculo = cd_veiculo;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    }
