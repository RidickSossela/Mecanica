/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Veiculo;
import model.dao.ClienteDao;
import model.dao.VeiculoDao;

/**
 *
 * @author ridic
 */
public class AddVeiculos implements Command{
    VeiculoDao veiculoDao = new VeiculoDao();
    ClienteDao clienteDao = new ClienteDao();
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("add").equals("cadastrar") && request.getParameter("proprietario")!= null){
            String modelo = request.getParameter("modelo");
            String placa = request.getParameter("placa");
            int ano = Integer.parseInt( request.getParameter("ano") );
            int cliente_cd_cliente = Integer.parseInt( request.getParameter("proprietario") );
            
            Veiculo veiculo = new Veiculo(0, cliente_cd_cliente, modelo, placa, ano );
            
            try {
                veiculoDao.adicionar(veiculo);
                request.setAttribute("menssagem", "Veiculo Adicionado com sucesso!.");
                request.setAttribute("cliente", clienteDao.getClienteById(Integer.parseInt(request.getParameter("proprietario"))));
                request.setAttribute("veiculos", veiculoDao.getVeiculoByCliente(Integer.parseInt(request.getParameter("proprietario"))));
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/veiculos/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        } else {
            try {
                request.setAttribute("cliente", request.getParameter("proprietario"));
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/veiculos/adicionar.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
