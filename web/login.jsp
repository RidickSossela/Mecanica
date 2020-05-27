<%-- 
    Document   : index
    Created on : 16/04/2020, 21:44:40
    Author     : ridic
--%>

<%@page import="model.dao.FuncionarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12 m-5 p-5">
                    <div class="text-center"
                         <h2 class="alert alert-danger">${menssagem}</h2>
                        <h1>Faça o login</h1>
                    </div>
                    <div class="col-4 offset-4">
                        <form action="login.jsp">
                            <div class="form-group"
                                 <label for="usuario">
                                    Usuario: <input class="form-control" type="text" name="usuario"/>
                                </label>
                            </div>
                            <div class="form-group">
                                <label for="senha">
                                    Senha: <input class="form-control" size="50" type="password" name="senha"/>
                                </label>
                            </div>
                            <div class="text-center">
                                <a href="index.jsp" class=" btn btn-secundary">Voltar ao Inicio</a>
                                <input class=" btn btn-primary" type="submit" value="Login"/>
                            </div>
                        </form>        
                        <div class="text-center">
                            <p><b>Usuario: admin</b></p>
                            <p><b>Senha: admin</b></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            if (request.getParameter("acao") != null && request.getParameter("acao").equals("logout")) {
                session.invalidate();
            }

            if (usuario != null && senha != null) {
                FuncionarioDao funcionarioDao = new FuncionarioDao();

                if (funcionarioDao.login(usuario, senha)) {
                    response.sendRedirect("ControllerServlet?command=Home");
                    session.setAttribute("usuario", usuario);
                } else {
                    request.setAttribute("menssagem", "Usuario Invalido!");
                    response.sendRedirect("ControllerServlet?command=Login");
                }
            }

        %>

    </body>
</html>

