/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ridic
 */
public abstract class Pessoa {
    private int codigo;
    private String nome;
    private String data_nascimento;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome, String data_nascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + ", data_nacimento=" + data_nascimento + ", cpf=" + cpf + '}';
    }
}
