package br.csi.excecoes;

public class AutenticacaoException extends Exception {

    public AutenticacaoException() {
        super("Email ou senha inválidos");
    }

    public AutenticacaoException(String message) {
        super(message);
    }

}
