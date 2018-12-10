package br.csi.servicos;

import br.csi.dao.ClienteDAO;
import br.csi.dao.VendedorDAO;
import br.csi.model.Autenticavel;
import br.csi.excecoes.AutenticacaoException;

public class Autenticador {

    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static VendedorDAO vendedorDAO = new VendedorDAO();

    private Autenticador() {
    }

    ;
    
    
    public static Autenticavel autententicar(String email, String senha) throws AutenticacaoException {
        if (clienteDAO.autenticar(email, senha)) {
            System.out.println("Autenticado como cliente");
            return (Autenticavel) clienteDAO.read(email, senha);
        } else if (vendedorDAO.autenticar(email, senha)) {
            System.out.println("Autenticado como vendador");
            return (Autenticavel) vendedorDAO.read(email, senha);
        }
        throw new AutenticacaoException();
    }

}
