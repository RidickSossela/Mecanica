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
public class Atendente extends Funcionario {

    public Atendente() {
    }

    public Atendente(String senha, String data_admissao, String cargo, int codigo, String nome, String data_nacimento, String cpf) {
        super(senha, data_admissao, cargo, codigo, nome, data_nacimento, cpf);
    }
}
