<%-- 
    Document   : editar
    Created on : 15/04/2020, 12:47:39
    Author     : ridic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Editar Cliente</title>
    </head>
    <body>
        <%
            String usuario = (String) session.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("ControllerServlet?command=Login");
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

                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="ControllerServlet?command=Home">Home</a></li>
                            <li class="breadcrumb-item"><a href="ControllerServlet?command=ListarClientes">Clientes</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Editar Funcionario</li>
                        </ol>
                    </nav>

                    <form method="POST" action="ControllerServlet?command=EditarClientes&editar=salvar&id=${cliente.codigo}">
                        <div class="form-group col-md-4 offset-md-4">
                            Nome: <input class="form-control" type="text" required="required" name="nome" value="${cliente.nome}"/> 
                            Data Nasc. <input class="form-control" type="date" required="required" name="data_nascimento" value="${cliente.data_nascimento}"/> 
                            CPF:  <input class="form-control" type="text" required="required" name="cpf" value="${cliente.cpf}"/> 
                            <div class="form-group mt-3">
                                <input class="btn btn-primary" type="submit">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
