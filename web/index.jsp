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
        <title>Bem vindo</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center m-5 p-5">
                        <h1>Sistema de Mecânica</h1>
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">Bem Vindo!</h4>
                            <hr>
                            <p>Universidade Estácio de Sá</p>
                            <p>Pós Graduação em Engenharia de Softare</p>
                            <p>Disciplina: Projeto e Implementação Orientado a Objetos</p>
                            <p>Aluno: Ridick Luiz Sossela</p>
                            <p>2020</p>
                            <hr>
                            <p class="mb-0"><a href="ControllerServlet?command=Login&acao=login">Acessar o Sistema</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
    </body>
</html>

