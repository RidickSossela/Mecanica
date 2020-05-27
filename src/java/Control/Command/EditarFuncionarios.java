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
public class EditarFuncionarios implements Command {

    private FuncionarioDao funcionarioDao = new FuncionarioDao();

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        if (request.getParameter("editar") != null && request.getParameter("editar").equals("salvar")) {
            int cd_funcionario = id;
            String nome = request.getParameter("nome");
            String data_nascimento = request.getParameter("data_nascimento");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            String data_admissao = request.getParameter("data_admissao");
            String cargo = request.getParameter("cargo");
            
            Funcionario funcionario = new Funcionario(senha, data_admissao, cargo, cd_funcionario, nome, data_nascimento, cpf );
            try {
                funcionarioDao.editar(funcionario);
                request.setAttribute("menssagem","Funcionario Editado!");
                request.setAttribute("funcionarios", funcionarioDao.getFuncionarios());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/funcionarios/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException |ServletException | IOException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Funcionario func = funcionarioDao.getFuncionarioById(id);
                request.setAttribute("funcionario", func);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/funcionarios/editar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException |IOException |ServletException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}