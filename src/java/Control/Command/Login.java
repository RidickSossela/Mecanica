/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ridic
 */
public class Login implements Command {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("acao") != null) {
            request.setAttribute("logout", true);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        } else {
            request.setAttribute("menssagem", "Faça o login para ter acesso!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

            try {
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
