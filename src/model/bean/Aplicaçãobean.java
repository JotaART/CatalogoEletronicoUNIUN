/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class Aplicaçãobean {
    private int codigo;
    private String montadora;
    private String modelo;
    private String motor;
    private double pistao;
    
//          PRODUTOS
    public String tipopeca;
    public String aplicacao;
    public double preco;

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public double getPistao() {
        return pistao;
    }

    public void setPistao(double pistao) {
        this.pistao = pistao;
    }
    
}
