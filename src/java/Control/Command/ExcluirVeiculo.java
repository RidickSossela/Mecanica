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
import model.dao.VeiculoDao;

/**
 *
 * @author ridic
 */
public class ExcluirVeiculo implements Command {
    ClienteDao clienteDao = new ClienteDao();
    VeiculoDao veiculoDao = new VeiculoDao();
    
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        String pro = request.getParameter("proprietario");
        if (request.getParameter("id") != null && request.getParameter("proprietario") != null) {
            try {
                veiculoDao.excluir(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("menssagem", "Veiculo Excluido!");
                request.setAttribute("veiculos", veiculoDao.getVeiculoByCliente(Integer.parseInt(request.getParameter("proprietario"))));
                
                request.setAttribute("cliente", clienteDao.getClienteById(Integer.parseInt(request.getParameter("proprietario"))));
                
                RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/paginas/clientes/veiculos/listar.jsp");
                rs.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(ExcluirFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
