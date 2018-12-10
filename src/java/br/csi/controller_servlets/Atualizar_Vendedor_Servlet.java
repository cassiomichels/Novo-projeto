package br.csi.controller_servlets;

import br.csi.dao.ClienteDAO;
import br.csi.dao.VendedorDAO;

import br.csi.model.Vendedor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"atualizar_vendedor"})
public class Atualizar_Vendedor_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        int id = Integer.parseInt(req.getParameter("id"));

        Vendedor p = new Vendedor(id, nome, email, senha);
        boolean retorno = new VendedorDAO().update(p);

        if (retorno) {
            req.setAttribute("mensagem", "Vendedor Atualizado");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/vendedor_atualizado.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Falha na atualização, Tente Novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/vendedor_atualizado.jsp");
            disp.forward(req, resp);
        }
    }
}
