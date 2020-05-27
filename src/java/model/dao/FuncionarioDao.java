/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author ridic
 */
public class FuncionarioDao {

    public List<Funcionario> getFuncionarios() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT cd_funcionario, nome, cpf, data_nascimento, senha, data_admissao, cargo FROM funcionario");
        ResultSet rs = ps.executeQuery();
        List<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()) {
            funcionarios.add(new Funcionario(rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3)));
        }
        return funcionarios;
    }

    public void adicionar(Funcionario func) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("INSERT INTO `funcionario` (`cd_funcionario`, `nome`, `cpf`, `data_nascimento`, `senha`, `data_admissao`, `cargo`) VALUES (?, ?, ?, ?, ?, ?,?);");
        ps.setString(5, func.getSenha());
        ps.setString(6, func.getData_admissao());
        ps.setString(7, func.getCargo());
        ps.setInt(1, func.getCodigo());
        ps.setString(2, func.getNome());
        ps.setString(4, func.getData_nascimento());
        ps.setString(3, func.getCpf());
        ps.execute();
    }

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_funcionario`, `nome`, `cpf`, `data_nascimento`, `senha`, `data_admissao`,`cargo` FROM funcionario WHERE `cd_funcionario` = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Funcionario func = null;
        if (rs != null && rs.next()) {
            func = new Funcionario(rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
        }
        return func;
    }

    public void editar(Funcionario func) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("UPDATE `funcionario` SET `cd_funcionario`= ?,`nome`= ?,`cpf`= ?,`data_nascimento`= ?,`senha`= ?,`data_admissao`= ?,`cargo`= ? WHERE `cd_funcionario` = ?");
        ps.setString(5, func.getSenha());
        ps.setString(6, func.getData_admissao());
        ps.setString(7, func.getCargo());
        ps.setInt(1, func.getCodigo());
        ps.setString(2, func.getNome());
        ps.setString(4, func.getData_nascimento());
        ps.setString(3, func.getCpf());
        ps.setInt(8, func.getCodigo());
        ps.execute();
    }

    public void excluir(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("DELETE FROM `funcionario` WHERE `funcionario`.`cd_funcionario` = ?");
        ps.setInt(1, id);
        ps.execute();
    }

    public boolean login(String usuario, String senha) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("SELECT `nome`, `senha` "
                + " FROM `funcionario` "
                + " WHERE `nome` = ? AND `senha` = ?");
        ps.setString(1, usuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();

        if (rs != null && rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
}
    
