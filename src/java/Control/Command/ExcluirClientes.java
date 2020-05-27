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
import model.dao.ClienteDao;

/**
 *
 * @author ridic
 */
public class ExcluirClientes implements Command {

    ClienteDao clienteDao = new ClienteDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("id") != null) {
            try {
                clienteDao.excluir(Integer.parseInt(request.getParameter("id")));
              
                request.setAttribute("menssagem", "Cliente Excluido!");
                request.setAttribute("clientes", clienteDao.getClientes());
                RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/paginas/clientes/listar.jsp");
                rs.forward(request, response);
            } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ExcluirClientes.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally {
                try {
                request.setAttribute("menssagem", "Exclua todos os veiculos do cliente para poder excluir esse cliente!");
                    request.setAttribute("clientes", clienteDao.getClientes());
                RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/paginas/clientes/listar.jsp");
                rs.forward(request, response);
                } catch (SQLException | IOException | ServletException |ClassNotFoundException ex) {
                    Logger.getLogger(ExcluirClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
