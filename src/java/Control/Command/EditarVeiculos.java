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
import model.Veiculo;
import model.dao.ClienteDao;
import model.dao.VeiculoDao;

/**
 *
 * @author ridic
 */
public class EditarVeiculos implements Command {

    VeiculoDao veiculoDao = new VeiculoDao();
    ClienteDao clienteDao = new ClienteDao();
    
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int proprietario = Integer.parseInt(request.getParameter("proprietario"));

        if (request.getParameter("editar") != null && request.getParameter("editar").equals("salvar")) {
            int cd_veiculo = id;
            String modelo = request.getParameter("modelo");
            String placa = request.getParameter("placa");
            int ano = Integer.parseInt(request.getParameter("ano"));

            Veiculo veiculo = new Veiculo(cd_veiculo, proprietario, modelo, placa, ano);
            
            try {
                veiculoDao.editar(veiculo);
                request.setAttribute("menssagem", "Veiculo Editado!");
                
                request.setAttribute("cliente", clienteDao.getClienteById(proprietario));
                request.setAttribute("veiculos", veiculoDao.getVeiculoByCliente(proprietario));
                
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/veiculos/listar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | ServletException | IOException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Cliente cliente = clienteDao.getClienteById(proprietario);
                request.setAttribute("cliente", cliente);
                
                Veiculo veiculo =  veiculoDao.getVeiculoById(id);
                request.setAttribute("veiculo", veiculo);
                
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/paginas/clientes/veiculos/editar.jsp");
                rd.forward(request, response);
            } catch (SQLException | ClassNotFoundException | IOException | ServletException ex) {
                Logger.getLogger(EditarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
