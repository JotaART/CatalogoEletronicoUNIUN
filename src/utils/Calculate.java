/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.CarrinhoTableModel;
import model.dao.carrinhoDAO;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class Calculate {
    public Double soma = 0.0;
                
    public void calculaTotalProdutos(JFrame tela, JTable tabela, JLabel lblTotal) throws FileNotFoundException {
        carrinhoDAO cDAO  = new carrinhoDAO();
        CarrinhoTableModel carrinhoTableModel = new CarrinhoTableModel(cDAO.read());
        
        try {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                Double valorAux = (Double) tabela.getValueAt(i, 3);
                soma += valorAux;
            }            
            carrinhoTableModel.setDados(cDAO.read());
            lblTotal.setText(String.valueOf(soma));            

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao calcular Total Produtos: " + e.getMessage());
        }
    }

    public void recalcula(JTable tabela, JLabel lblTotal) throws FileNotFoundException {
        carrinhoDAO cDAO  = new carrinhoDAO();
        CarrinhoTableModel carrinhoTableModel = new CarrinhoTableModel(cDAO.read());
        for (int i = 0; i < tabela.getRowCount(); i++) {
            soma = 0.0;
        }        
        carrinhoTableModel.setDados(cDAO.read());
        lblTotal.setText(String.valueOf(soma));        
    }            
}
