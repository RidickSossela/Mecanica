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
public class Cliente extends Pessoa {

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String data_nacimento, String cpf) {
        super(codigo, nome, data_nacimento, cpf);
    }
}
