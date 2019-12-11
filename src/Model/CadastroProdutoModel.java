/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
public class CadastroProdutoModel {
    private int codigo;
    private String nome;
    private String descricao;
    private String fornecedor;
    private String marca;
    private float valorCompra;
    private float valorLucro;
    private float valorVenda;

    public CadastroProdutoModel() {
    }

    public CadastroProdutoModel(int codigo, String nome, String descricao, String fornecedor, String marca, float valorCompra, float valorLucro, float valorVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.valorCompra = valorCompra;
        this.valorLucro = valorLucro;
        this.valorVenda = valorVenda;
    }

    public float getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(float valorLucro) {
        this.valorLucro = valorLucro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
}
