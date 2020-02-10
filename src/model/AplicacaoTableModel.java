/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Aplicaçãobean;


/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class AplicacaoTableModel extends AbstractTableModel{

    private final List<model.bean.Aplicaçãobean> dados;
    private final String[] colunas = {"Montadora","Modelo","Motor","Pistao (Ø)"};

    public AplicacaoTableModel(List<Aplicaçãobean> dados) {
        this.dados = dados;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
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
                return dados.get(linha).getMontadora();
            case 1:
                return dados.get(linha).getModelo();
            case 2:
                return dados.get(linha).getMotor();
            case 3:
                return dados.get(linha).getPistao();
        }   
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setMontadora((String) valor);
                break;
            case 1:
                dados.get(linha).setModelo((String) valor);
                break;
            case 2:
                dados.get(linha).setMotor((String) valor);
                break;
            case 3:
                dados.get(linha).setPistao(Double.parseDouble((String) valor));
                break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
        
    }
    
    public void clear (){
        dados.clear();
            this.fireTableDataChanged();
    }

    public void addrow (Aplicaçãobean aplicBean){
        dados.add(aplicBean);
            this.fireTableRowsInserted(this.getRowCount(), this.getColumnCount());
    }
    public Aplicaçãobean getRow(int index) {
     return dados.get(index);
    }

    public void clearRows(){
     dados.clear();
     this.fireTableDataChanged();
    }

    public void addRow(Aplicaçãobean pb) {
        int linhas = dados.size();
        dados.add(linhas, pb);
        this.fireTableRowsInserted(linhas, linhas);
    }

    public void removeRow(int row) {
        dados.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
    
    public void setDados(List<Aplicaçãobean> dados) {
        this.dados.clear();
        this.dados.addAll(dados);
        this.fireTableDataChanged();
    }    
}
