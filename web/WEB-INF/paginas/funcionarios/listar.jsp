<%-- 
    Document   : funcionarios
    Created on : 13/04/2020, 14:25:35
    Author     : ridic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Funionarios</title>
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
                            <li class="breadcrumb-item active" aria-current="page">Listar funcionarios</li>
                        </ol>
                    </nav>
                    <h1>Funcionarios</h1>
                    <h3><a class="btn btn-success" href="ControllerServlet?command=AddFuncionarios">Adicionar</a></h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Nome</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Data Nasc.</th>
                                <th scope="col">Senha</th>
                                <th scope="col">Data Admissão</th>
                                <th scope="col">Cargo</th>
                                <th scope="col" colspan="2">Açoes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="f" items="${funcionarios}">
                                <tr>
                                    <td>${f.codigo}</td>
                                    <td>${f.nome}</td>
                                    <td>${f.cpf}</td>
                                    <td>${f.data_nascimento}</td>
                                    <td>${f.senha}</td>
                                    <td>${f.data_admissao}</td>
                                    <td>${f.cargo}</td>
                                    <td>
                                        <a href="ControllerServlet?command=EditarFuncionarios&id=${f.codigo}">Editar</a>
                                        <a href="ControllerServlet?command=ExcluirFuncionarios&id=${f.codigo}"
                                           onclick="return confirm('Deseja mesmo excluir esse funcionario?')">Excluir</a> </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

