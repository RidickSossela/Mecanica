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
public class Funcionario extends Pessoa {
    private String senha;
    private String data_admissao;
    private String cargo;

    public Funcionario(String senha, String data_admissao, String cargo, int codigo, String nome, String data_nacimento, String cpf) {
        super(codigo, nome, data_nacimento, cpf);
        this.senha = senha;
        this.data_admissao = data_admissao;
        this.cargo = cargo;
    }

    public Funcionario() {
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "senha=" + senha + ", data_admissao=" + data_admissao + ", cargo=" + cargo + '}';
    }   
}
