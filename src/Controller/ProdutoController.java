/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CadastroProdutoModel;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ProdutoController {
    public boolean inserirProduto(CadastroProdutoModel produto) {
        boolean retorno = false;
        Conexao c = new Conexao();
        /*String sql="insert into produto(descricao,valor,estoque) "
                + "values('"+produto.getDescricao()+"',"+produto.getPreco()+","+produto.getEstoque()+")";*/
        String sql = "insert into produto(nome,descricao,fornecedor,marca,valorcompra) "
                + "values(?,?,?,?,?)";
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setString(1, produto.getNome());
            sentenca.setString(2, produto.getDescricao());
            sentenca.setString(3, produto.getFornecedor());
            sentenca.setString(4, produto.getMarca());
            sentenca.setFloat(5, produto.getValorCompra());
            if (!sentenca.execute()) {
                retorno = true;
            }
            c.desconectar();
        } catch (SQLException erro) {
            System.out.println("Erro na sentenca: " + erro.getMessage());
        }
        return retorno;
    }
    
    public boolean editarProduto(CadastroProdutoModel produto) {
        boolean retorno = false;
        Conexao c = new Conexao();
        String sql = "update produto set nome = ?, descricao = ?, fornecedor = ?, marca = ?, valorcompra = ?"
                + "where id_produto=?";
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setString(1, produto.getNome());
            sentenca.setString(2, produto.getDescricao());
            sentenca.setString(3, produto.getFornecedor());
            sentenca.setString(4, produto.getMarca());
            sentenca.setFloat(5, produto.getValorCompra());
            sentenca.setInt(6, produto.getCodigo());
            if (sentenca.executeUpdate() == 1) {
                retorno = true;
            }
            c.desconectar();
        } catch (SQLException erro) {
            System.out.println("Erro na sentenca: " + erro.getMessage());
        }
        return retorno;
    }
    
    public CadastroProdutoModel selecionarProduto(CadastroProdutoModel produto) {
        CadastroProdutoModel p = null;
        Conexao c = new Conexao();
        String sql = "select * from produto where id_produto=?";
        try {
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, produto.getCodigo());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                p = new CadastroProdutoModel();
                p.setCodigo(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setFornecedor(rs.getString("fornecedor"));
                p.setMarca(rs.getString("marca"));
                p.setValorCompra(rs.getFloat("valorcompra"));
                p.setValorLucro(rs.getFloat("valorlucro"));
                p.setValorVenda(rs.getFloat("valorvenda"));
            }
            c.desconectar();
        } catch (SQLException erro) {
            System.out.println("Erro na sentenca: " + erro.getMessage());
        }
        return p;
    }
    
    public ArrayList<CadastroProdutoModel> selecionarTodosProdutos(){
        ArrayList<CadastroProdutoModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        String sql = "select * from produto";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){
                CadastroProdutoModel p= new CadastroProdutoModel();
                p.setCodigo(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setFornecedor(rs.getString("fornecedor"));
                p.setMarca(rs.getString("marca"));
                p.setValorCompra(rs.getFloat("valorcompra"));
                p.setValorLucro(rs.getFloat("valorlucro"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                lista.add(p);
            }
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return lista;
    }
    
    public ArrayList<CadastroProdutoModel> selecionarTodosNomesProdutos(CadastroProdutoModel produto){
        ArrayList<CadastroProdutoModel> lista = new ArrayList<>();
        Conexao c = new Conexao();
        String sql = "select * from produto where nome like ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            String nome = "%"+produto.getNome()+ "%";
            sentenca.setString(1, nome);
            ResultSet rs = sentenca.executeQuery();
            while(rs.next()){
                CadastroProdutoModel p= new CadastroProdutoModel();
                p.setCodigo(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setFornecedor(rs.getString("fornecedor"));
                p.setMarca(rs.getString("marca"));
                p.setValorCompra(rs.getFloat("valorcompra"));
                p.setValorLucro(rs.getFloat("valorlucro"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                lista.add(p);
            }
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return lista;
    }
    
    public boolean excluirProduto(CadastroProdutoModel produto){
        boolean retorno = false;
        Conexao c = new Conexao();
        String sql = "delete from produto where id_produto = ?";
        try{
            PreparedStatement sentenca = c.con.prepareStatement(sql);
            sentenca.setInt(1, produto.getCodigo());
            if(!sentenca.execute())
                retorno = true;
            c.desconectar();
        }catch(SQLException erro){
            System.out.println("Erro na sentenca: "+ erro.getMessage());
        }
        return retorno;
    }
    
}
