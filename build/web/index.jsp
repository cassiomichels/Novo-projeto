
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Pagina de login</title>

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
                        <b> Máquinas Agricolas SM </b>
                    </a>
                    <ul class="navbar-nav mx-auto">

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
        <div class="py-0">
            <div class="container">
                <div class="row" >
                    <div class="px-20 col-md-8 text-center mx-auto">
                        <h3 class="text-primary display-4"> <b>Máquinas Agrícolas SM </b> </h3>

                        <br><br>

                        <p class="mb-3">

                            A tecnologia está presente em todo nosso trabalho. Usamos tecnologia de ponta para oferecer a melhor experiência aos nossos usuários.
                        <div class="row">
                            <div class="col-md-3"> </div>
                            <div class="col-md-6">
                                <div class="card text-white p-5 bg-dark">
                                    <div class="card-body bg-">
                                        <h1 class="mb-4"> Bem-Vindo
                                            <br>
                                            <br> </h1>
                                        <form action="login" method="POST">
                                            <label for="login">Email:</label>
                                            <input type="email" name="email" />
                                            <label for="senha">Senha:</label>
                                            <input type="password" name="senha" />
                                            <br>
                                            <button type="submit" class="btn btn-success">Entre</button>
                                        </form>
                                        <br><br>
                                        <a href="http://localhost:8080/MaquinariosAgricola/cadastro_cliente">
                                            <button class="btn btn-primary">Crie seu cadastro</button>
                                        </a>
                                        <br>
                                        <c:if test="${not empty mensagem}">
                                            <h2> OPS: 
                                                <strong style="color:red;">${mensagem}</strong>
                                            </h2>
                                        </c:if>  

                                    </div>
                                </div>
                            </div>
                        </div>

                        <p class="mt-2"> <small>Segurança garantida </small> </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p class="mt-2 mb-0" >©2018 Maquinas Agricolas SM. All rights reserved</p>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>