package br.csi.dao;

import br.csi.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    public boolean update(Cliente cliente) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " UPDATE cliente"
                    + " SET nome = ?, email = ?, senha =?, endereco=? "
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getNome());
            pre.setString(2, cliente.getEmail());
            pre.setString(3, cliente.getSenha());
            pre.setString(4, cliente.getEndereco());
            pre.setInt(5, cliente.getId());

            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(int id, Cliente cliente) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            Cliente usuario = new Cliente();
            usuario.setId(id);
            usuario.setNome(cliente.getNome());
            usuario.setSenha(cliente.getSenha());
            usuario.setEmail(cliente.getEmail());
            System.out.println("usuario id: " + usuario.getId() + " nome: " + usuario.getNome() + " senha: " + usuario.getSenha());
            boolean retorno = new ClienteDAO().update(usuario);
            System.out.println("retorno = " + retorno);

            String sql = " UPDATE cliente"
                    + " SET nome = ?, email=? , senha=?, endereco=? "
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getNome());
            pre.setString(2, cliente.getEmail());
            pre.setString(3, cliente.getSenha());
            pre.setString(4, cliente.getSenha());

            pre.setInt(5, id);
            //System.out.println("id: " + id + " endereco " + cliente.getEndereco() + " telefone " + cliente.getTelefone() );
            //executeUpdate() = executa uma atualização/inserção/delete no banco
            //executeQuery() = executa uma pesquisa no banco
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cliente read(String email, String senha) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM cliente WHERE email = ? AND senha=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, senha);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cliente u = new Cliente();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente read(int id) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = "SELECT * FROM cliente"
                    + " WHERE id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setEndereco(rs.getString("endereco"));

                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(String email, String senha) {
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " INSERT INTO cliente( email, senha) "
                    + " VALUES(?, ?);";
            PreparedStatement pre
                    = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setString(1, email);
            pre.setString(2, senha);
            pre.execute();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();

            if (rs.getInt(1) > 0) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean create(Cliente cliente) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {

            String sql = " INSERT INTO cliente(nome, email, senha, endereco) "
                    + " VALUES(?, ?, ?, ?);";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getNome());
            pre.setString(2, cliente.getEmail());
            pre.setString(3, cliente.getSenha());
            pre.setString(4, cliente.getEndereco());

            if (pre.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {

        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            String sql = " DELETE FROM cliente"
                    + " WHERE id = ?";
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

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        // Connection conn = new ConectaDB_Postgres().getConexao();
        try (Connection conn = new ConectaDB_Postgres().getConexao()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setSenha(rs.getString("senha"));
                cli.setEndereco(rs.getString("endereco"));

                clientes.add(cli);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    public boolean autenticar(String email, String senha) {

        try (Connection conn
                = new ConectaDB_Postgres().getConexao()) {

            String sql = "SELECT * FROM cliente  WHERE email = ? AND senha = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, email);
            pStmt.setString(2, senha);

            ResultSet rs = pStmt.executeQuery();
            boolean autenticado = rs.next();
            System.out.println(autenticado);
            return autenticado;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
