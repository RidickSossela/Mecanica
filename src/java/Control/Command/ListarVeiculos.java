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
import model.dao.VeiculoDao;
import model.dao.ClienteDao;

/**
 *
 * @author ridic
 */
public class ListarVeiculos implements Command {

    VeiculoDao veiculoDao = new VeiculoDao();
    ClienteDao clienteDao = new ClienteDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        int cliente = Integer.parseInt(request.getParameter("proprietario"));
        try {
            request.setAttribute("cliente", clienteDao.getClienteById(cliente));
            request.setAttribute("veiculos", veiculoDao.getVeiculoByCliente(cliente));
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/paginas/clientes/veiculos/listar.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

