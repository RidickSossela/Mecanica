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
public class ExcluirFuncionarios implements Command {

    FuncionarioDao func = new FuncionarioDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("id") != null) {
            try {
                func.excluir(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("menssagem", "Funcionario Excluido!");
                request.setAttribute("funcionarios", func.getFuncionarios());
                RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/paginas/funcionarios/listar.jsp");
                rs.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(ExcluirFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
