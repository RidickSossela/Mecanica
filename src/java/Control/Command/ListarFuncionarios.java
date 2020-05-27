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
import model.dao.FuncionarioDao;

/**
 *
 * @author ridic
 */
public class ListarFuncionarios implements Command{
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    
    @Override
      public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("funcionarios", funcionarioDao.getFuncionarios());
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/paginas/funcionarios/listar.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
