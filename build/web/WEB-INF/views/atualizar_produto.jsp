
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Clientes</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar13">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar13"> <a class="navbar-brand d-none d-md-block" href="#">
                        <i class="fa d-inline fa-lg fa-stop-circle-o"></i>
                        <b> Máquinas Agricolas SM </b>
                    </a>
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/busca_caminhoneiro">Equipe de Caminhineiros</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/busca_produto">Lista de Produtos</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/busca_cliente">Lista de clientes</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/busca_vendedor">Lista de Vendedores</a> </li> 
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/busca_venda">Lista de vendas realizados</a> </li> 
                        <li class="nav-item"> <a class="nav-item" href="http://localhost:8080/MaquinariosAgricola/logout">SAIR</a> </li>
                    </ul>

                </div>
            </div>
        </nav>


        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="atualizar_produto?id=${id}" method="POST">
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <input name="nome" type="text" class="form-control" id="nome" value="<c:out value="${produto.nome}"/>">                
                            </div>

                            <div class="form-group">
                                <label for="descricao">Descrição:</label>
                                <input name="descricao" type="text" class="form-control" id="descricao" value=<c:out value="${produto.descricao}"/>>                
                            </div>
                            <div class="form-group">
                                <label for="preco">Descrição:</label>
                                <input name="preco" type="number" class="form-control" id="preco" value=<c:out value="${produto.preco}"/>>                
                            </div>


                            <button type="submit" value="Enviar" class="btn btn-primary">Atualizar</button>
                        </form>	        
                    </div>
                    </body>
                    </html>