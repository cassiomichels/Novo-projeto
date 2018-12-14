
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>vendas</title>

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

        <h1>Atualize os dados incorretos na venda selecionada</h1>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="atualizar_venda?id=${id}" method="POST">
                            <div class="form-group">
                            <label for="idCliente">Cliente (Selecione o cliente desejado)</label>
                            <select class="custom-select" name="id_cliente">                
                              
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
                            <label for="idCaminhoneiro">Caminhoneiro (Selecione o caminhoneiro que irá fazer a entrega)</label>
                            <select class="custom-select" name="id_caminhoneiro">                
                               
                                <c:forEach items="${caminhoneiros}" var="caminhoneiro">                                  
                                    <option value="<c:out value="${caminhoneiro.id}"/>">
                                        <c:out value="${caminhoneiro.id}${' - '}${caminhoneiro.nome}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="idProduto">Maquina (Selecione máquina que será vendida)</label>
                            <select class="custom-select" name="id_produto">                
                              
                                <c:forEach items="${produtos}" var="produto">                                  
                                    <option value="<c:out value="${produto.id}"/>">
                                        <c:out value="${produto.id}${' - '}${produto.nome}${' - '}${produto.descricao}"/></option>'
                                    </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="endereco">Endereço:</label>
                            <input type="text" class="form-control" placeholder="Digite o endereço de entrega"  name="endereco" required> </div>

                        <button type="submit" value="Enviar" class="btn btn-primary">Atualizar Venda</button>
                    </form>
                    </div>
                    </body>
                    </html>