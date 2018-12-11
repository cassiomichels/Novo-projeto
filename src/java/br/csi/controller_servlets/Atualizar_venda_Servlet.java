package br.csi.controller_servlets;

import br.csi.dao.CaminhoneiroDAO;
import br.csi.dao.ClienteDAO;
import br.csi.dao.ProdutoDAO;
import br.csi.dao.VendaDAO;
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

@WebServlet(urlPatterns = {"atualizar_venda"})
public class Atualizar_venda_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chamou GET ....");
    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
            int id = Integer.parseInt(req.getParameter("id"));
            int idCliente = Integer.parseInt(req.getParameter("id_cliente"));
            int idVendedor = Integer.parseInt(req.getParameter("id_vendedor"));
            int idCaminhoneiro = Integer.parseInt(req.getParameter("id_caminhoneiro"));
            int idProduto = Integer.parseInt(req.getParameter("id_produto"));
            String endereco = req.getParameter("endereco");
            

            new VendaDAO().update(id,idCliente, idVendedor, idCaminhoneiro, idProduto, endereco);
             
            RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/venda_atualizada.jsp");
            disp.forward(req, resp);
        } }