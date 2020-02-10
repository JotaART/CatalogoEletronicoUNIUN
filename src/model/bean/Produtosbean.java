/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.produtoDAO;
import model.dao.usuarioDAO;

/**
 *
 * @author JOAOARTHURDELIMAFLORES
 */
public class Produtosbean {
    
    produtoDAO pDAO = new produtoDAO();  
    usuarioDAO uDAO = new usuarioDAO();
    
    Usuariobean uBEAN = new Usuariobean(); 
    public int desconto = 1;
    public Double precoDesconto = 1.0; 
    
    public byte[] imagem;   
    public String codigoref;
    public int codigo;
    public String montadora;
    public String tipopeca;
    public String aplicacao;
    public double preco;
    
//  CARRINHO
    public int qtd;
    public int precototal;
    
    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }   

    public int getPrecototal() {
        return precototal;
    }

    public void setPrecototal(int precototal) {
        this.precototal = precototal;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }   
       
    public String getCodigoref() {
        return codigoref;
    }

    public void setCodigoref(String codigoref) {
        this.codigoref = codigoref;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getTipopeca() {
        return tipopeca;
    }

    public void setTipopeca(String tipopeca) {
        this.tipopeca = tipopeca;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public double getPreco() {          
        return preco;
    }

    public void setPreco(double preco) {     
        this.preco = preco;
    }      
}
