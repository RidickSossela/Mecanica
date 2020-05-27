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
import model.Funcionario;
import model.dao.FuncionarioDao;

/**
 *
 * @author ridic
 */
public class AddFuncionarios implements Command {
    FuncionarioDao funcionarioDao = new FuncionarioDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("add") != null && request.getParameter("add").equals("cadastrar")){
            String nome = request.getParameter("nome");
            String data_nascimento = request.getParameter("data_nascimento");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            String data_admissao = request.getParameter("data_admissao");
            String cargo = request.getParameter("cargo");
            
            Funcionario funcionario = new Funcionario(senha, data_admissao, cargo, 0, nome, data_nascimento, cpf );
            
            try {
                funcionarioDao.adicionar(funcionario);
                request.setAttribute("menssagem", "Funcionario Adicionado com sucesso!.");
                request.setAttribute("funcionarios", funcionarioDao.getFuncionarios());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/funcionarios/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        } else {
            try {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/funcionarios/adicionar.jsp");
                rd.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AddFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
