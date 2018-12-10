package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.dao.ClienteDAO;
import br.csi.dao.VendaDAO;
import br.csi.dao.ProdutoDAO;
import br.csi.dao.VendedorDAO;
import br.csi.model.Caminhoneiro;
import br.csi.model.Cliente;
import br.csi.model.Produto;
import br.csi.model.Vendedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "cadastro_venda")
public class Cadastra_Venda_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamou doGet do Servlet ....");
        //processRequest(request, response);
        req.setAttribute("clientes", new ClienteDAO().getClientes());
        req.setAttribute("vendedores", new VendedorDAO().getVendedores());
        req.setAttribute("caminhoneiros", new CaminhoneiroDAO().getCaminhoneiros());
        req.setAttribute("produtos", new ProdutoDAO().getProdutos());

        ArrayList<Cliente> clientes = new ClienteDAO().getClientes();
        ArrayList<Vendedor> vendedores = new VendedorDAO().getVendedores();
        ArrayList<Caminhoneiro> caminhoneiros = new CaminhoneiroDAO().getCaminhoneiros();
        ArrayList<Produto> produtos = new ProdutoDAO().getProdutos();

        RequestDispatcher disp
                = req.getRequestDispatcher("/WEB-INF/views/cadastro_venda.jsp");
        disp.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter resposta = null;
        try {
            System.out.println("método post requisitado ....");
            resposta = resp.getWriter();
            int idCliente = Integer.parseInt(req.getParameter("id_cliente"));
            int idVendedor = Integer.parseInt(req.getParameter("id_vendedor"));
            int idCaminhoneiro = Integer.parseInt(req.getParameter("id_caminhoneiro"));
            int idProduto = Integer.parseInt(req.getParameter("id_produto"));
            String endereco = req.getParameter("endereco");
            new VendaDAO().create(idCliente, idVendedor, idCaminhoneiro, idProduto, endereco);

            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/sucesso_venda.jsp");
            disp.forward(req, resp);
        } catch (IOException | ServletException ex) {
            resposta.println("<html><body><strong>ERRO</strong></body></html>");
        } finally {
            resposta.close();
        }
    }
}
