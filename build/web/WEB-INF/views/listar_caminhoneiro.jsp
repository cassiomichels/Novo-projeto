
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>caminhoneiro</title>

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
        <br><br>
        <div class="container">
            <h1>Lista de nossos caminhoneiros</h1><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>                        
                        <th>Nome</th>
                        <th>E-mail</th>
                        <th>Placa</th>  


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${caminhoneiros}" var="caminhoneiro">
                        <tr>
                            <td><c:out value="${caminhoneiro.id}"/></td>
                            <td><c:out value="${caminhoneiro.nome}"/></td>
                            <td><c:out value="${caminhoneiro.email}"/></td>

                            <td><c:out value="${caminhoneiro.placa}"/> <br /></td> 

                        </tr>                        
                    </c:forEach>          
                </tbody>						
            </table>					        
        </div>
    </body>
</html>