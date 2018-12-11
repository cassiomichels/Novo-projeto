package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.dao.ClienteDAO;
import br.csi.dao.ProdutoDAO;
import br.csi.dao.VendedorDAO;
import br.csi.model.Caminhoneiro;
import br.csi.model.Cliente;
import br.csi.model.Produto;
import br.csi.model.Vendedor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"alterar_venda"})
public class Alterar_Venda_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("id", id);
req.setAttribute("clientes", new ClienteDAO().getClientes());
        req.setAttribute("vendedores", new VendedorDAO().getVendedores());
        req.setAttribute("caminhoneiros", new CaminhoneiroDAO().getCaminhoneiros());
        req.setAttribute("produtos", new ProdutoDAO().getProdutos());

        ArrayList<Cliente> clientes = new ClienteDAO().getClientes();
        ArrayList<Vendedor> vendedores = new VendedorDAO().getVendedores();
        ArrayList<Caminhoneiro> caminhoneiros = new CaminhoneiroDAO().getCaminhoneiros();
        ArrayList<Produto> produtos = new ProdutoDAO().getProdutos();

        RequestDispatcher disp
                = req.getRequestDispatcher("/WEB-INF/views/atualizar_venda.jsp");
        disp.forward(req, resp);
    }
}
