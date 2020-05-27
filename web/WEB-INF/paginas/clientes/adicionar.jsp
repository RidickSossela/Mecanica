<%-- 
    Document   : adicionar
    Created on : 14/04/2020, 22:28:14
    Author     : ridic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Adiconar Cliente</title>
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
                            <li class="breadcrumb-item active" aria-current="page">Adicionar Cliente</li>
                        </ol>
                    </nav>

                    <form method="POST" action="ControllerServlet?command=AddClientes&add=cadastrar">
                        <div class="form-group col-md-4 offset-md-4">
                            Nome: <input class="form-control" required="required" type="text" name="nome"/>
                            Data Nasc. <input class="form-control" required="required" type="date" name="data_nascimento"/>
                            CPF:  <input class="form-control" required="required" type="text" name="cpf"/>
                            <div class="form-group mt-3">
                                <input class="btn btn-primary" type="submit" value="Salvar"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>
