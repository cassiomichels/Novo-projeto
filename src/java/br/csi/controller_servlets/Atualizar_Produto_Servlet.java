package br.csi.controller_servlets;

import br.csi.dao.ProdutoDAO;

import br.csi.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"atualizar_produto"})
public class Atualizar_Produto_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");

        int id = Integer.parseInt(req.getParameter("id"));

        Produto p = new Produto(id, nome, descricao);
        boolean retorno = new ProdutoDAO().update(p);

        if (retorno) {
            req.setAttribute("mensagem", "produto Atualizado");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/produto_atualizado.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Falha na atualização, Tente Novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/produto_atualizado.jsp");
            disp.forward(req, resp);
        }
    }
}
