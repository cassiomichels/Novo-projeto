/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.model;

public class Venda {

    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private Caminhoneiro caminhoneiro;
    private Produto produto;
    private String endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Caminhoneiro getCaminhoneiro() {
        return caminhoneiro;
    }

    public void setCaminhoneiro(Caminhoneiro caminhoneiro) {
        this.caminhoneiro = caminhoneiro;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Venda() {
    }

    public Venda(Cliente cliente, Caminhoneiro caminhoneiro, Produto produto, String endereco) {
        this.cliente = cliente;
        this.caminhoneiro = caminhoneiro;
        this.produto = produto;
        this.endereco = endereco;
    }

    public Venda(int id, Cliente cliente, Caminhoneiro caminhoneiro, Produto produto, String endereco) {
        this.id = id;
        this.cliente = cliente;
        this.caminhoneiro = caminhoneiro;
        this.produto = produto;
        this.endereco = endereco;
    }

    public Venda(int id, Cliente cliente, Vendedor vendedor, Caminhoneiro caminhoneiro, Produto produto, String endereco) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.caminhoneiro = caminhoneiro;
        this.produto = produto;
        this.endereco = endereco;
    }

    public Venda(Cliente cliente, Vendedor vendedor, Caminhoneiro caminhoneiro, Produto produto, String endereco) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.caminhoneiro = caminhoneiro;
        this.produto = produto;
        this.endereco = endereco;
    }

}
