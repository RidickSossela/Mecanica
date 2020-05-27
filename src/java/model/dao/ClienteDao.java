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
import model.Cliente;

/**
 *
 * @author ridic
 */
public class ClienteDao {

    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_cliente`, `nome`, `data_nascimento`, `cpf` FROM `cliente`");
        ResultSet rs = ps.executeQuery();
        List<Cliente> cliente = new ArrayList<>();
        while (rs.next()) {
            cliente.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return cliente;
    }

    public void adicionar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("INSERT INTO `cliente`(`cd_cliente`, `nome`, `cpf`, `data_nascimento`) VALUES (?,?,?,?)");
        ps.setInt(1, cliente.getCodigo());
        ps.setString(2, cliente.getNome());
        ps.setString(4, cliente.getData_nascimento());
        ps.setString(3, cliente.getCpf());
        ps.execute();
    }

    public Cliente getClienteById(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_cliente`, `nome`, `data_nascimento`,`cpf` FROM `cliente` WHERE `cd_cliente` = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Cliente cliente = null;
        if (rs != null && rs.next()) {
            cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        return cliente;
    }

    public void editar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("UPDATE `cliente` SET `cd_cliente`= ?,`nome`= ?,`cpf`= ?,`data_nascimento`= ? WHERE `cd_cliente` = ?");
        ps.setInt(1, cliente.getCodigo());
        ps.setString(2, cliente.getNome());
        ps.setString(4, cliente.getData_nascimento());
        ps.setString(3, cliente.getCpf());
        ps.setInt(5, cliente.getCodigo());
        ps.execute();
    }

    public void excluir(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("DELETE FROM `cliente` WHERE `cd_cliente` = ?");
        ps.setInt(1, id);
        ps.execute();
    }
}
