package model;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Produtosbean;
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
public class ProdutoTableModel2 extends AbstractTableModel{
    
//                                          ~~MODEL APENAS PARA TABELA DE CADASTRO~~    
    
    usuarioDAO uDAO = new usuarioDAO();
    produtoDAO pDAO = new produtoDAO();
        
    
    private final List<model.bean.Produtosbean> dados;
    private final String[] colunas = {"Codigo","Montadora","Tipo peça","Aplicação","Preço"};
    
    public Double getDesconto(Double precoDesconto) throws FileNotFoundException {
        return precoDesconto;
    }    

    public ProdutoTableModel2(List<Produtosbean> dados) {
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

            NumberFormat format = NumberFormat.getCurrencyInstance();
            return dados.get(linha).getPreco();
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
            dados.get(linha).setPreco(Double.parseDouble((String) valor));
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
