package br.csi.dao;

import br.csi.model.Caminhoneiro;
import br.csi.model.Cliente;
import br.csi.model.Produto;
import br.csi.model.Venda;
import br.csi.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private VendedorDAO vDAO = new VendedorDAO();
    private CaminhoneiroDAO cDAO = new CaminhoneiroDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public Venda read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "select pedido.* from caminhoneiro, cliente, vendedor, produto, pedido where caminhoneiro.id = pedido.id_caminhoneiro and cliente.id = pedido.id_cliente and vendedor.id = pedido.id_vendedor and produto.id = pedido.id_produto and pedido.id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int idVenda = rs.getInt("id");
                int idCliente = rs.getInt("id_cliente");
                int idVendedor = rs.getInt("id_vendedor");
                int idCamioneiro = rs.getInt("id_caminhoneiro");
                int idProduto = rs.getInt("id_produto");
                String endereco = rs.getString("endereco");

                Caminhoneiro caminhoneiro = this.cDAO.read(idCamioneiro);
                Cliente cliente = this.clienteDAO.read(idCliente);
                Produto produto = this.produtoDAO.read(idProduto);
                Vendedor vendedor = this.vDAO.read(idVendedor);

                return new Venda(idVenda, cliente, vendedor, caminhoneiro, produto, endereco);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Venda> readPorCliente(int id_cliente) {
        List<Venda> retorno = new ArrayList<>();

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * from pedido where id_cliente = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id_cliente);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int idVenda = rs.getInt("id");
                int idCliente = rs.getInt("id_cliente");
                int idVendedor = rs.getInt("id_vendedor");
                int idCamioneiro = rs.getInt("id_caminhoneiro");
                int idProduto = rs.getInt("id_produto");
                String endereco = rs.getString("endereco");

                Caminhoneiro caminhoneiro = this.cDAO.read(idCamioneiro);
                Cliente cliente = this.clienteDAO.read(idCliente);
                Produto produto = this.produtoDAO.read(idProduto);
                Vendedor vendedor = this.vDAO.read(idVendedor);

                retorno.add(new Venda(idVenda, cliente, vendedor, caminhoneiro, produto, endereco));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

        public boolean update(int id,int id_cliente, int id_vendedor, int id_caminhoneiro, int id_produto, String endereco) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "update pedido set id_cliente =?, id_vendedor = ?, id_caminhoneiro = ?, id_produto = ?, endereco = ? where id =?;";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id_cliente);
            pre.setInt(2, id_vendedor);
            pre.setInt(3, id_caminhoneiro);
            pre.setInt(4, id_produto);
            pre.setString(5, endereco);
            pre.setInt(6, id);

            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
    
    public void create(int id_cliente, int id_vendedor, int id_caminhoneiro, int id_produto, String endereco) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "INSERT INTO pedido(id_cliente, id_vendedor, id_caminhoneiro, id_produto, endereco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id_cliente);
            pre.setInt(2, id_vendedor);
            pre.setInt(3, id_caminhoneiro);
            pre.setInt(4, id_produto);
            pre.setString(5, endereco);

            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean delete(int id) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "DELETE FROM pedido WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Venda> getVendas() {
        List<Venda> retorno = new ArrayList<>();

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * from pedido";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int idVenda = rs.getInt("id");
                int idCliente = rs.getInt("id_cliente");
                int idVendedor = rs.getInt("id_vendedor");
                int idCamioneiro = rs.getInt("id_caminhoneiro");
                int idProduto = rs.getInt("id_produto");
                String endereco = rs.getString("endereco");

                Caminhoneiro caminhoneiro = this.cDAO.read(idCamioneiro);
                Cliente cliente = this.clienteDAO.read(idCliente);
                Vendedor vendedor = this.vDAO.read(idVendedor);
                Produto produto = this.produtoDAO.read(idProduto);

                retorno.add(new Venda(idVenda, cliente, vendedor, caminhoneiro, produto, endereco));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }
}
