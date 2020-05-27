<%-- 
    Document   : home
    Created on : 16/04/2020, 23:21:24
    Author     : ridic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body
        <%
            String usuario = (String) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("/index.jsp");
            }
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="alert alert-primary" role="alert">
                        Usuario: <%=session.getAttribute("usuario")%> 
                        <a href="ControllerServlet?command=Login&acao=logout">Sair</a>
                    </div>

                    <c:if test="${menssagem!=null}">
                        <div class="alert alert-warning" role="alert">${menssagem}</div>
                    </c:if>
                    <h1>Mecanica</h1>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Funcionarios</h5>
                                    <p class="card-text">Adicione, edite, atualiza e exclua funcionarios do sistema</p>
                                    <a href="ControllerServlet?command=ListarFuncionarios" class="btn btn-primary">Acessar</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Cliente e Veiculos</h5>
                                    <p class="card-text">Adicione, edite, atualiza e exclua clientes e seus veiculos do sistema</p>
                                    <a href="ControllerServlet?command=ListarClientes" class="btn btn-primary">Acessar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
