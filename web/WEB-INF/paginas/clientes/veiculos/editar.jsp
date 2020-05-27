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
                            <li class="breadcrumb-item"><a href="ControllerServlet?command=ListarVeiculos&proprietario=${cliente.codigo}">Veiculos</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Editar Veiculos</li>
                        </ol>
                    </nav>
                            <h4>Editar veiculo de: ${cliente.nome}</h4> 
                    <form method="POST" action="ControllerServlet?command=EditarVeiculos&editar=salvar&id=${veiculo.cd_veiculo}&proprietario=${cliente.codigo}">
                        <div class="form-group col-md-4 offset-md-4">
                            Modelo: <input class="form-control" type="text" required="required" name="modelo" value="${veiculo.modelo}"/> 
                            Placa: <input class="form-control" type="text" required="required" name="placa" value="${veiculo.placa}"/> 
                            Ano: <input class="form-control" type="number" required="required" name="ano" value="${veiculo.ano}"/> 
                            <div class="form-group">
                                <input class="btn btn-primary" value="Salvar" type="submit">
                            </div>
                        </div>  
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
