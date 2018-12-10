package br.csi.controller_servlets;

import br.csi.dao.ClienteDAO;
import br.csi.model.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"atualizar_cliente"})
public class Atualizar_Cliente_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String endereco = req.getParameter("endereco");

        int id = Integer.parseInt(req.getParameter("id"));

        Cliente p = new Cliente(id, nome, email, senha, endereco);
        boolean retorno = new ClienteDAO().update(p);

        if (retorno) {
            req.setAttribute("mensagem", "Cliente Atualizado");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/cliente_atualizado.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Falha na atualização, Tente Novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/cliente_atualizado.jsp");
            disp.forward(req, resp);
        }
    }
}
