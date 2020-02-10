package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Usuariobean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class UsuarioTableModel extends AbstractTableModel {

    private final List<model.bean.Usuariobean> dados;
    private final String[] colunas = {"ID", "Desconto", "Usuario", "Senha", "E-Mail"};

    public UsuarioTableModel(List<Usuariobean> dados) {
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
        switch (coluna) {
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getDesconto();
            case 2:
                return dados.get(linha).getUsername();
            case 3:
                return dados.get(linha).getSenha();
            case 4:
                return dados.get(linha).getEmail();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setId(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setDesconto(Integer.parseInt((String) valor));
                break;
            case 2:
                dados.get(linha).setUsername((String) valor);
                break;
            case 3:
                dados.get(linha).setSenha((String) valor);
                break;
            case 4:
                dados.get(linha).setEmail((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }

    public void clear() {
        dados.clear();
        this.fireTableDataChanged();
    }

    public void addrow(Usuariobean uBean) {
        dados.add(uBean);
        this.fireTableRowsInserted(this.getRowCount(), this.getColumnCount());
    }

    public Usuariobean getRow(int index) {
        return dados.get(index);
    }

    public void clearRows() {
        dados.clear();
        this.fireTableDataChanged();
    }

    public void addRow(Usuariobean ub) {
        int linhas = dados.size();
        dados.add(linhas, ub);
        this.fireTableRowsInserted(linhas, linhas);
    }

    public void removeRow(int row) {
        dados.remove(row);
        this.fireTableRowsDeleted(row, row);
    }

    public void setDados(List<Usuariobean> dados) {
        this.dados.clear();
        this.dados.addAll(dados);
        this.fireTableDataChanged();
    }
}
