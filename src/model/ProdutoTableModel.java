package model;

import connection.ConnectionFactory;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.bean.Produtosbean;
import model.bean.Usuariobean;
import model.dao.produtoDAO;
import model.dao.usuarioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    usuarioDAO uDAO = new usuarioDAO();
    produtoDAO pDAO = new produtoDAO();
    
//				~~CALCULADOR DE DESCONTO~~
//	Variaveis
    public Double preco = 1.0;            
    public int desconto = 1;
    public Double precoDesconto = 1.0;
    
    
    private final List<model.bean.Produtosbean> dados;
    private final String[] colunas = {"Codigo","Montadora","Tipo peça","Aplicação","Preço"};
    
    public Double getDesconto(Double precoDesconto) throws FileNotFoundException {
        return precoDesconto;
    }    

    public ProdutoTableModel(List<Produtosbean> dados) {
        this.dados = dados;
    }
    
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        String arq = "conf.txt";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT desconto FROM tb_usuarios WHERE id = " + uDAO.Read(arq) + "");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuariobean user = new Usuariobean();

                int desconto = rs.getInt("desconto");
                
                switch (desconto) {
                    case 0:
                        precoDesconto = preco * 1; // preco 126
                        break;
                    case 1:
                        precoDesconto = preco * 0.6; // preco 132
                        break;
                    case 2:
                        precoDesconto = preco * 0.57; // preco 132
                        break;
                    case 3:
                        precoDesconto = preco * 0.54; // preco 132
                        break;
                    case 4:
                        precoDesconto = preco * 0.5; // preco 132
                        break;
                    case 5:
                        precoDesconto = preco * 0.475; // preco 132
                        break;
                    case 6:
                        precoDesconto = preco * 0.45; // preco 132
                        break;
                    case 7:
                        precoDesconto = preco * 0.4275; // preco 132
                        break;
                    case 8:
                        precoDesconto = preco * 0.405; // preco 132
                        break;
                    case 9:
                        precoDesconto = preco * 0.3847; // preco 132
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarrinhoTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }        
        switch(coluna){
            case 0:
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getMontadora();
            case 2:
                return dados.get(linha).getTipopeca();
            case 3:
                return dados.get(linha).getAplicacao();
            case 4:
        {

            try {             
                NumberFormat format = NumberFormat.getCurrencyInstance();
                return dados.get(linha).getPreco() * getDesconto(getDesconto(precoDesconto));
                
            } catch (FileNotFoundException ex) {
                    System.out.println("\n" + this + " Erro ao obter preco com desconto: " + ex);
            }
        }
        }   
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setCodigo(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setMontadora((String) valor);
                break;
            case 2:
                dados.get(linha).setTipopeca((String) valor);
                break;
            case 3:
                dados.get(linha).setAplicacao((String) valor);
                break;
            case 4:
        {
            try {
                dados.get(linha).setPreco(Double.parseDouble((String) valor) * getDesconto(precoDesconto));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProdutoTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                
        }
        
        this.fireTableRowsUpdated(linha, linha);
        
    }    

public void clear (){
        dados.clear();
            this.fireTableDataChanged();
    }

    public void addrow (Produtosbean aplicBean){
        dados.add(aplicBean);
            this.fireTableRowsInserted(this.getRowCount(), this.getColumnCount());
    }
    public Produtosbean getRow(int index) {
     return dados.get(index);
    }

    public void clearRows(){
     dados.clear();
     this.fireTableDataChanged();
    }

    public void addRow(Produtosbean pb) {
        int linhas = dados.size();
        dados.add(linhas, pb);
        this.fireTableRowsInserted(linhas, linhas);
    }

    public void removeRow(int row) {
        dados.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
        public void setDados(List<Produtosbean> dados) {
        this.dados.clear();
        this.dados.addAll(dados);
        this.fireTableDataChanged();
    } 
}
