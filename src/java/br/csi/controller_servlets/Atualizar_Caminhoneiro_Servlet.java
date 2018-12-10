package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.model.Caminhoneiro;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"atualizar_caminhoneiro"})
public class Atualizar_Caminhoneiro_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String placa = req.getParameter("placa");

        int id = Integer.parseInt(req.getParameter("id"));

        Caminhoneiro p = new Caminhoneiro(id, nome, email, endereco, placa);
        boolean retorno = new CaminhoneiroDAO().update(p);

        if (retorno) {
            req.setAttribute("mensagem", "Caminhoneiro Atualizado");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/caminhoneiro_atualizado.jsp");
            disp.forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Falha na atualização, Tente Novamente!");
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/caminhoneiro_atualizado.jsp");
            disp.forward(req, resp);
        }
    }
}
