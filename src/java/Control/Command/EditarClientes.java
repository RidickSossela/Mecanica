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
public class EditarClientes implements Command {

    ClienteDao clienteDao = new ClienteDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        if (request.getParameter("editar") != null && request.getParameter("editar").equals("salvar")) {
            int cd_cliente = id;
            String nome = request.getParameter("nome");
            String data_nascimento = request.getParameter("data_nascimento");
            String cpf = request.getParameter("cpf");

            Cliente cliente = new Cliente(cd_cliente, nome, data_nascimento, cpf);
            try {
                clienteDao.editar(cliente);
                request.setAttribute("menssagem", "Cliente Editado!");
                request.setAttribute("clientes", clienteDao.getClientes());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | ServletException | IOException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Cliente cliente = clienteDao.getClienteById(id);
                request.setAttribute("cliente", cliente);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/editar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
