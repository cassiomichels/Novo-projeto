
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
    <body >
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar13">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbar13"> <a class="navbar-brand d-none d-md-block" href="#">
                        <i class="fa d-inline fa-lg fa-stop-circle-o"></i>
                        <b> Máquinas Agrícolas SM</b>
                    </a>
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/listar_caminhoneiro">Equipe de caminhoneiros</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/listar_vendedor">Equipe de vendedores</a> </li>
                        <li class="nav-item"> <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/listar_produto">Máquinas de nosso catálogo</a> </li>

                        <li class="nav-item"> <a class="nav-item" href="http://localhost:8080/MaquinariosAgricola/logout">SAIR</a> </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item"> <a class="nav-link" href="#">
                                <i class="fa fa-twitter fa-fw"></i>
                            </a> </li>
                        <li class="nav-item"> <a class="nav-link" href="#">
                                <i class="fa fa-facebook fa-fw"></i>
                            </a> </li>
                        <li class="nav-item"> <a class="nav-link" href="#">
                                <i class="fa fa-slack fa-fw"></i>
                            </a> </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="py-5">
            <div class="container">
                <div class="row" >
                    <div class="px-5 col-md-8 text-center mx-auto">
                        <h3 class="text-primary display-4"> <b>Máquinas Agricolas SM</b> </h3>
                        <h2 class="my-3"> <h1>Bem vindo(a) ${sessionScope['usuarioLogado'].nome} ao nosso site. </h1> <br><br> Nosso site maquinários Agrícola.</h2>
                        <p class="mb-3">

                            Catálogo de implementos agrícolas da empresa máquinas agrícola SM, <br>
                            produtos disponíveis no estoque. 
                            
                            
                            <a class="nav-link" href="http://localhost:8080/MaquinariosAgricola/listar_produto">Catálogo de máquinas </a> 

                        <p class="mt-2"> <small>Segurança garantida </small> </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <c:if test="${not empty vendas}">




                <h1>Compras realizadas </h1><br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Vendedor</th>
                            <th>Caminhoneiro </th>
                            <th>Produto</th>  
                            <th>Preço</th>
                            <th>Endereço para entrega</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${vendas}" var="venda">
                            <tr>
                                <td><c:out value="${venda.vendedor.nome}"/></td>
                                <td><c:out value="${venda.caminhoneiro.nome}"/></td>
                                <td><c:out value="${venda.produto.nome}"/></td> 
                                <td><c:out value="R$ ${venda.produto.preco}"/></td> 
                                <td><c:out value="${venda.endereco}"/> <br /></td>

                            </tr>                        
                        </c:forEach>          
                    </tbody>						
                </table>		
            </c:if> 
        </div>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p class="mt-2 mb-0" >© 2018 Maquinarios Agricola SM.</p>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>