/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import connection.ConnectionFactory;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.dao.usuarioDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.TelaCarrinho;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class InserirParametro {
        HashMap mapa = new HashMap();
        JasperPrint jasperPrint = null;
        String arq = "conf.txt";
        usuarioDAO uDAO = new usuarioDAO();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;    

        String src = "..\\src\\utils\\Carrinho.jasper";
        String srcPDF = "..\\src\\utils\\Carrinho.pdf";        
    
    public void printPDF (Object tela) {

        try {
            mapa.put("PARAMETRO_ID", uDAO.Read(arq));

            stmt = con.prepareStatement("SELECT desconto FROM tb_usuarios WHERE id = " + uDAO.Read(arq) + "");
            rs = stmt.executeQuery();
            rs.next();

            int desconto = rs.getInt("desconto");
            mapa.put("PARAMETRO_DESCONTO", desconto);

        } catch (FileNotFoundException ex) {
            System.out.println(this+"Arquivo não encontrado"+ ex);
        } catch (SQLException ex) { //catch do STMT
            Logger.getLogger(TelaCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jasperPrint = JasperFillManager.fillReport(src, mapa, con);
        } catch (JRException ex) {
            Logger.getLogger(TelaCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, srcPDF);
            System.out.println("converteu. "+srcPDF);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog((Component) tela,"Erro ao salvar o carrinho em pdf. \n" + ex);
        }        
    }
    
    public void openJasper (Object tela) {
        try {
            mapa.put("PARAMETRO_ID", uDAO.Read(arq));

            stmt = con.prepareStatement("SELECT desconto FROM tb_usuarios WHERE id = " +uDAO.Read(arq)+ "");
            rs = stmt.executeQuery();
            System.out.println("\n"+stmt+"\n");
            rs.next();

            int desconto = rs.getInt("desconto");
            mapa.put("PARAMETRO_DESCONTO", desconto);

        } catch (FileNotFoundException ex) {
            System.out.println(this+ " FileNotFound " +ex);
        } catch (SQLException ex) { //catch do STMT
            Logger.getLogger(TelaCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jasperPrint = JasperFillManager.fillReport(src, mapa, con);
        } catch (JRException ex) {
            Logger.getLogger(TelaCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer jasperViewer = new JasperViewer(jasperPrint);
        jasperViewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, srcPDF);
            System.out.println("converteu. " + srcPDF);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog((Component) tela, "Erro ao salvar o carrinho em pdf. \n" + ex);
        }
        jasperViewer.setVisible(true);
        System.out.println("Abriu: " + src);              
    }    
}
