/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.AplicacaoTableModel;
import model.bean.Aplicaçãobean;
import model.bean.Produtosbean;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class aplicaçãoDAO {

    usuarioDAO uDAO = new usuarioDAO();
    AplicacaoTableModel aplicacaoTableModel = new AplicacaoTableModel(this.read());

    public void create(Aplicaçãobean a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_aplicacao \n"
                    + "(cod_aplicacao, \n"
                    + "montadora_aplicacao, \n"
                    + "modelo, \n"
                    + "motor, \n"
                    + "pistao) \n"
                    + "VALUES (?,?,?,?,?);");

            stmt.setInt(1, a.getCodigo());
            stmt.setString(2, a.getMontadora());
            stmt.setString(3, a.getModelo());
            stmt.setString(4, a.getMotor());
            stmt.setDouble(5, a.getPistao());

            stmt.executeUpdate();
            
            System.out.println("deu bom");
        } catch (SQLException ex) {
            System.out.println("deu ruim " + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
    }

    public void update(Aplicaçãobean a, JTable tabela, JFrame tela, JTextField Tmontadora_aplicacao, JTextField Tmodelo, JTextField Tmotor, JTextField Tpistao) {
        int selectedRow = tabela.getSelectedRow();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tb_aplicacao "
                    + " SET montadora_aplicacao = '" + Tmontadora_aplicacao.getText() + "', "
                    + " modelo = '" + Tmodelo.getText() + "', "
                    + " motor = '" + Tmotor.getText() + "', "
                    + " pistao = '" + Tpistao.getText() + "' "
                    + " WHERE montadora_aplicacao = '" + tabela.getModel().getValueAt(selectedRow, 0).toString() + "' "
                    + " AND modelo = '" + tabela.getModel().getValueAt(selectedRow, 1).toString() + "' "
                    + " AND motor = '" + tabela.getModel().getValueAt(selectedRow, 2).toString() + "' "
                    + " AND pistao = '" + tabela.getModel().getValueAt(selectedRow, 3).toString() + "';");
            stmt.setString(1, a.getMontadora());
            stmt.setString(2, a.getModelo());
            stmt.setString(3, a.getMotor());
            stmt.setDouble(4, a.getPistao());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(tela, "Aplicação " + tabela.getModel().getValueAt(selectedRow, 1).toString() + " alterada com sucesso");
        } catch (SQLException ex) {
            System.out.println("deu ruim \n" + ex);
            JOptionPane.showMessageDialog(tela, "ERRO! \n" + ex);
            System.out.println(stmt);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
    }
    
    public List<Aplicaçãobean> delete (JTable tabela) {
        int selectedRow = tabela.getSelectedRow();        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        List<Aplicaçãobean> aplicacao = new ArrayList<>();

        System.out.println("remover");
        try {
                stmt = con.prepareStatement("DELETE FROM tb_aplicacao "
                        + "WHERE montadora_aplicacao = '" + tabela.getValueAt(selectedRow, 0) + "' "
                        + "AND modelo = '" + tabela.getValueAt(selectedRow, 1) + "' "
                        + "AND motor = '" + tabela.getValueAt(selectedRow, 2) + "' "
                        + "AND pistao = '" + tabela.getValueAt(selectedRow, 3) + "'; ");
                
                stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }        
        return aplicacao;
    }    

    public List<Aplicaçãobean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aplicaçãobean> aplicacao = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT p.codigo, tba.montadora_aplicacao, tba.modelo, tba. motor, tba.pistao "
                    + "    FROM produto p "
                    + "    JOIN tb_aplicacao tba "
                    + "    ON p.codigo = tba.cod_aplicacao;");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aplicaçãobean aplic = new Aplicaçãobean();

                aplic.setCodigo(rs.getInt("codigo"));
                aplic.setMontadora(rs.getString("montadora_aplicacao"));
                aplic.setModelo(rs.getString("modelo"));
                aplic.setMotor(rs.getString("motor"));
                aplic.setPistao(rs.getDouble("pistao"));

                aplicacao.add(aplic);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return aplicacao;
    }

    public List<Aplicaçãobean> search(int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aplicaçãobean> aplicacao = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT p.codigo, tba.montadora_aplicacao, tba.modelo, tba. motor, tba.pistao "
                    + "    FROM produto p "
                    + "    JOIN tb_aplicacao tba "
                    + "    ON p.codigo = tba.cod_aplicacao "
                    + "    WHERE codigo = ? ;");
            stmt.setInt(1, cod);

            rs = (ResultSet) stmt.executeQuery();

            while (rs.next()) {

                Aplicaçãobean aplic = new Aplicaçãobean();

                aplic.setCodigo(rs.getInt("codigo"));
                aplic.setMontadora(rs.getString("montadora_aplicacao"));
                aplic.setModelo(rs.getString("modelo"));
                aplic.setMotor(rs.getString("motor"));
                aplic.setPistao(rs.getDouble("pistao"));

                aplicacao.add(aplic);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return aplicacao;
    }

//                  *************PARA LER E SETAR OS DADOS DA TELA DE GERENCIAMENTO DE PRODUTOS*************
    
    
    public List<Produtosbean> read2(JTable tabela, JTextField Tcodigo, JTextField Tmontadora, JTextField Tmodelo, JTextField Tmotor, JTextField Tpistao) {
        int selectedRow = tabela.getSelectedRow();

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * "
                    + " FROM produto AS p "
                    + " JOIN tb_aplicacao AS tba "
                    + " ON p.codigo = tba.cod_aplicacao "
                    + " WHERE tba.montadora_aplicacao = '" + tabela.getValueAt(selectedRow, 0) + "'"
                    + " AND tba.modelo = '" + tabela.getValueAt(selectedRow, 1) + "'"
                    + " AND tba. motor = '" + tabela.getValueAt(selectedRow, 2) + "'"
                    + " AND tba.pistao = '" + tabela.getValueAt(selectedRow, 3) + "'");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                Tcodigo.setText(codigo);
                String montadora = rs.getString("montadora_aplicacao");
                Tmontadora.setText(montadora);
                String modelo = rs.getString("modelo");
                Tmodelo.setText(modelo);
                String motor = rs.getString("motor");
                Tmotor.setText(motor);
                String pistao = rs.getString("pistao");
                Tpistao.setText(pistao);
                byte[] img = rs.getBytes("imagem");
            }
            aplicacaoTableModel.setDados(this.read());
        } catch (SQLException ex) {
            System.out.println("ERRO. \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return null;
    }

    public List<Produtosbean> readMotorAplicacao(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto;
        produto = new ArrayList<>();

        final String sql = "SELECT * FROM produto p JOIN tb_aplicacao tba WHERE tba.motor LIKE CONVERT('%#%' USING 'utf8') GROUP BY codigo;";

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql.replaceAll("#", param));
            rs = (ResultSet) stmt.executeQuery();

            while (rs.next()) {

                Produtosbean produtos = new Produtosbean();

                produtos.setCodigo(rs.getInt("codigo"));
                produtos.setMontadora(rs.getString("montadora"));
                produtos.setTipopeca(rs.getString("tipopeca"));
                produtos.setAplicacao(rs.getString("aplicacao"));
                produtos.setPreco(rs.getDouble("preco"));

                produto.add(produtos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
            System.out.println("");
        }
        return produto;
    }
}
