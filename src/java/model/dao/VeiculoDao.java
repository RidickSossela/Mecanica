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
import model.Veiculo;

/**
 *
 * @author ridic
 */
public class VeiculoDao {

    public List<Veiculo> getVeiculos() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_veiculo`, `cliente_cd_cliente`, `modelo`, `placa`, `ano` FROM `veiculo`");
        ResultSet rs = ps.executeQuery();
        List<Veiculo> veiculo = new ArrayList<>();
        while (rs.next()) {
            veiculo.add(new Veiculo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        return veiculo;
    }

    public void adicionar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("INSERT INTO `veiculo`(`cd_veiculo`, `modelo`, `placa`, `ano`, `cliente_cd_cliente`) VALUES (?,?,?,?,?)");
        ps.setInt(1, veiculo.getCd_veiculo());
        ps.setString(2, veiculo.getModelo());
        ps.setString(3, veiculo.getPlaca());
        ps.setInt(4, veiculo.getAno());
        ps.setInt(5, veiculo.getProprietario());
        ps.execute();
    }

    public List<Veiculo> getVeiculoByCliente(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_veiculo`, `cliente_cd_cliente`, `modelo`, `placa`, `ano` FROM `veiculo` WHERE `cliente_cd_cliente` = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<Veiculo> veiculo = new ArrayList<>();
        while (rs.next()) {
            veiculo.add(new Veiculo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }
        return veiculo;
    }

    public void editar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("UPDATE `veiculo` SET `cd_veiculo`= ?,`modelo`= ?,`placa`= ?,`ano`= ?, `cliente_cd_cliente` = ? WHERE `cd_veiculo` = ?");
        ps.setInt(1, veiculo.getCd_veiculo());
        ps.setString(2, veiculo.getModelo());
        ps.setString(3, veiculo.getPlaca());
        ps.setInt(4, veiculo.getAno());
        ps.setInt(5, veiculo.getProprietario());
        ps.setInt(6, veiculo.getCd_veiculo());
        ps.execute();
    }

    public void excluir(int id) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = con.prepareStatement("DELETE FROM `veiculo` WHERE `cd_veiculo` = ?");
        ps.setInt(1, id);
        ps.execute();
    }

    public Veiculo getVeiculoById(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoJDBCFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT `cd_veiculo`, `modelo`, `placa`, `ano`, `cliente_cd_cliente` FROM `veiculo` WHERE cd_veiculo = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Veiculo veiculo = null;
        if (rs != null && rs.next()) {
            veiculo = new Veiculo(rs.getInt(1),rs.getInt(5), rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        return veiculo;
    }

}
