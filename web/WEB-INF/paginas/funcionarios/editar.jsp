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
        <title>Editar Funcionario</title>
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
                            <li class="breadcrumb-item"><a href="ControllerServlet?command=ListarFuncionarios">Funcionarios</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Editar Funcionario</li>
                        </ol>
                    </nav>

                    <form method="POST" action="ControllerServlet?command=EditarFuncionarios&editar=salvar&id=${funcionario.codigo}">
                        <div class="form-group col-md-4 offset-md-4">
                            Nome: <input class="form-control" type="text" required="required" name="nome" value="${funcionario.nome}"/>
                        Data Nascimento <input class="form-control" type="date" required="required" name="data_nascimento" value="${funcionario.data_nascimento}"/>
                        CPF:  <input class="form-control" type="text" name="cpf" required="required" value="${funcionario.cpf}"/>
                        Senha: <input class="form-control" type="password" name="senha" required="required" value="${funcionario.senha}"/>
                        Data Admissão:  <input class="form-control" type="date" required="required" name="data_admissao" value="${funcionario.data_admissao}"/>
                        Cargo:
                        <select class="form-control" name="cargo" required="required" selected="${funcionario.cargo}">
                            <option value="atendente">Atendente</option>
                            <option value="mecanico">Mecanico</option>
                        </select>
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
