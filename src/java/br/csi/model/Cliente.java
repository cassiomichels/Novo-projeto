package br.csi.model;

public class Cliente implements Autenticavel {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public Cliente(int id, String nome, String email, String senha, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(String nome, String email, String senha, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

}
