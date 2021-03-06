
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> </head>

    <title>Cadastrar Venda</title>
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
    </nav> <br><br>

    <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
            <div class="card text-white p-5 bg-dark">
                <div class="card-body bg-">
                    <h1 class="mb-4">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cadastrar Venda
                        <br>
                        <br> </h1>
                    <form action="cadastro_venda" method="POST">
                        <div class="form-group">
                            <label for="idCliente">Cliente (Selecione o cliente desejado)</label>
                            <select class="custom-select" name="id_cliente">                
                               >
                                <c:forEach items="${clientes}" var="cliente">                                  
                                    <option value="<c:out value="${cliente.id}"/>">
                                        <c:out value="${cliente.id}${' - '}${cliente.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idVendedor">Vendedor (Selecione qual vendedor responsável )</label>
                            <select class="custom-select" name="id_vendedor">                
                                
                                <c:forEach items="${vendedores}" var="vendedor">                                  
                                    <option value="<c:out value="${vendedor.id}"/>">
                                        <c:out value="${vendedor.id}${' - '}${vendedor.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idFuncionario">Caminhoneiro (Selecione o caminhoneiro que irá fazer a entrega)</label>
                            <select class="custom-select" name="id_caminhoneiro">                
                               
                                <c:forEach items="${caminhoneiros}" var="caminhoneiro">                                  
                                    <option value="<c:out value="${caminhoneiro.id}"/>">
                                        <c:out value="${caminhoneiro.id}${' - '}${caminhoneiro.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idVeiculo">Maquina (Selecione máquina que será vendida)</label>
                            <select class="custom-select" name="id_produto">                
                                
                                <c:forEach items="${produtos}" var="produto">                                  
                                    <option value="<c:out value="${produto.id}"/>">
                                        <c:out value="${produto.id}${' - '}${produto.nome}${' - '}${produto.descricao} ${' Preço RS '}${produto.preco}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nome">Endereço:</label>
                            <input type="text" class="form-control" placeholder="Digite o endereço de entrega"  name="endereco" required> </div>

                        <button type="submit" value="Enviar" class="btn btn-primary">Cadastrar</button>
                    </form>
                    </body>
                    </html>
