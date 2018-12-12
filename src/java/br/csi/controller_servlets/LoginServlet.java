package br.csi.controller_servlets;

import br.csi.dao.VendaDAO;
import br.csi.excecoes.AutenticacaoException;
import br.csi.model.Autenticavel;
import br.csi.model.Cliente;
import br.csi.model.Vendedor;
import br.csi.servicos.Autenticador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher disp;
        try {
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");

            Autenticavel usuarioAutenticado = Autenticador.autententicar(email, senha);

            HttpSession sessao = req.getSession();
            if (usuarioAutenticado instanceof Cliente) {
                Cliente cliente = (Cliente) usuarioAutenticado;
                sessao.setAttribute("usuarioLogado", cliente);
                req.setAttribute("vendas", new VendaDAO().readPorCliente(cliente.getId()));
                disp = req.getRequestDispatcher("/WEB-INF/views/pagina_inicial_cliente.jsp");
            } else {
                sessao.setAttribute("usuarioLogado", (Vendedor) usuarioAutenticado);
                disp = req.getRequestDispatcher("/WEB-INF/views/pagina_inicial_vendedor.jsp");
            }
            disp.forward(req, resp);
        } catch (AutenticacaoException ex) {
            req.setAttribute("mensagem", ex.getMessage());
            disp = req.getRequestDispatcher("index.jsp");
            disp.forward(req, resp);
        }

    }
    
}
