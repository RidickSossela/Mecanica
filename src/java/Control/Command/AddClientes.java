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
import model.Cliente;
import model.dao.ClienteDao;

/**
 *
 * @author ridic
 */
public class AddClientes implements Command{
    ClienteDao clienteDao = new ClienteDao();
    
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
      if (request.getParameter("add") != null && request.getParameter("add").equals("cadastrar")){
            String nome = request.getParameter("nome");
            String data_nascimento = request.getParameter("data_nascimento");
            String cpf = request.getParameter("cpf");
            
            Cliente funcionario = new Cliente(0, nome, data_nascimento, cpf );
            
            try {
                clienteDao.adicionar(funcionario);
                request.setAttribute("menssagem", "Cliente Adicionado com sucesso!.");
                request.setAttribute("clientes", clienteDao.getClientes());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        } else {
            try {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/adicionar.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
