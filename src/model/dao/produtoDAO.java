/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import java.awt.Image;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Produtosbean;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.AplicacaoTableModel;
import view.TelaGerProdutos;

/**
 *
 * @author JOAOARTHURDELIMAFLORES
 */
public class produtoDAO {

    usuarioDAO uDAO = new usuarioDAO();
    aplicaçãoDAO aDAO = new aplicaçãoDAO();
    AplicacaoTableModel aplicacaoTableModel = new AplicacaoTableModel(aDAO.read());

    public void create(Produtosbean p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (imagem, cod_referencia, codigo, montadora, tipopeca, aplicacao, preco) VALUES (?,?,?,?,?,?,?);");
            stmt.setBytes(1, p.getImagem());
            stmt.setString(2, p.getCodigoref());
            stmt.setInt(3, p.getCodigo());
            stmt.setString(4, p.getMontadora());
            stmt.setString(5, p.getTipopeca());
            stmt.setString(6, p.getAplicacao());
            stmt.setDouble(7, p.getPreco());

            stmt.executeUpdate();

            System.out.println("deu bom");
        } catch (SQLException ex) {
            System.out.println("deu ruim" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
    }

    public void update(Produtosbean p, String codigo) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        TelaGerProdutos tgp = new TelaGerProdutos();

        try {
            stmt = con.prepareStatement("UPDATE produto "
                    + "SET imagem = ? , "
                    + "cod_referencia = ? , "
                    + "codigo = ? , "
                    + "montadora = ? , "
                    + "tipopeca = ? , "
                    + "aplicacao = ? , "
                    + "preco = ? "
                    + "WHERE codigo = " + codigo + "");

            stmt.setBytes(1, p.getImagem());
            stmt.setString(2, p.getCodigoref());
            stmt.setInt(3, p.getCodigo());
            stmt.setString(4, p.getMontadora());
            stmt.setString(5, p.getTipopeca());
            stmt.setString(6, p.getAplicacao());
            stmt.setDouble(7, p.getPreco());

            stmt.executeUpdate();

            System.out.println("deu bom");
            JOptionPane.showMessageDialog(tgp, "Produto " + p.getAplicacao() + " cadastrado com sucesso");
        } catch (SQLException ex) {
            System.out.println("deu ruim \n" + ex);
            JOptionPane.showMessageDialog(tgp, "ERRO! \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
    }
    
    public List<Produtosbean> delete (int cod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        List<Produtosbean> produto = new ArrayList<>();

        System.out.println("remover");
        try {
            stmt = con.prepareStatement("DELETE FROM produto "
                    + "WHERE codigo = '"+cod+"';");
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }        
        return produto;
    }

    public List<Produtosbean> read(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        final String sql = "SELECT * FROM produto WHERE codigo LIKE CONVERT('%#%' USING 'utf8') "
                + "OR cod_referencia LIKE CONVERT('%#%' USING 'utf8') "
                + "OR montadora LIKE CONVERT('%#%' USING 'utf8') "
                + "OR tipopeca LIKE CONVERT('%#%' USING 'utf8') "
                + "OR aplicacao LIKE CONVERT('%#%' USING 'utf8') "
                + "OR preco LIKE CONVERT('%#%' USING 'utf8')";

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql.replaceAll("#", param));
            rs = (ResultSet) stmt.executeQuery();

            while (rs.next()) {

                Produtosbean produtos = new Produtosbean();

                produtos.setImagem(rs.getBytes("imagem"));
                produtos.setCodigoref(rs.getString("cod_referencia"));
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
        }
        return produto;
    }

    public List<Produtosbean> read2(JTable tabela, JLabel imagem, JTextField Tcod_referencia, JTextField Tcodigo, JTextField Tmontadora, JTextField Ttipopeca, JTextField Taplicacao, JTextField Tpreco) {
        int selectedRow = tabela.getSelectedRow();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM produto "
                    + "WHERE codigo = " + tabela.getValueAt(selectedRow, 0) + ";");
            rs = stmt.executeQuery();

            while (rs.next()) {
                byte[] img = rs.getBytes("imagem");
                try {
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    imagem.setIcon(newImage);
                    imagem.setText("");
                } catch (NullPointerException NPE) {
                    imagem.setIcon(null);
                    imagem.setText("Imagem não \n disponível");
                }
                String cod_referencia = rs.getString("cod_referencia");
                Tcod_referencia.setText(cod_referencia);
                String codigo = rs.getString("codigo");
                Tcodigo.setText(codigo);
                String montadora = rs.getString("montadora");
                Tmontadora.setText(montadora);
                String tipopeca = rs.getString("tipopeca");
                Ttipopeca.setText(tipopeca);
                String aplicacao = rs.getString("aplicacao");
                Taplicacao.setText(aplicacao);
                String preco = rs.getString("preco");
                Tpreco.setText(preco);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return null;
    }

    public List<Produtosbean> readCod(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        final String sql = "SELECT * FROM produto WHERE codigo LIKE CONVERT('%#%' USING 'utf8')"
                + "OR cod_referencia LIKE CONVERT('%#%' USING 'utf8')";
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
        }
        return produto;
    }

    public List<Produtosbean> readCod2(int cod, JTextField Tcod) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM produto WHERE codigo = " + cod + "");
        try {
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtosbean produtos = new Produtosbean();

                String codigo = rs.getString("codigo");
                Tcod.setText(codigo);

                produto.add(produtos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return produto;
    }

    public List<Produtosbean> readImage(JTable tabela, JLabel imagem) {
        int selectedRow = tabela.getSelectedRow();
        if (tabela.getSelectedRow() != -1) {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                stmt = con.prepareStatement("SELECT imagem \n"
                        + "    FROM produto"
                        + "    WHERE codigo = " + tabela.getModel().getValueAt(selectedRow, 0).toString() + ";");
                rs = stmt.executeQuery();

                while (rs.next()) {
                    byte[] img = rs.getBytes("imagem");
                    try {
                        ImageIcon image = new ImageIcon(img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        imagem.setIcon(newImage);
                        imagem.setText("");
                    } catch (NullPointerException NPE) {
                        imagem.setIcon(null);
                        imagem.setText("Imagem não \n disponível");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
            }
        }
        return null;
    }

    public List<Produtosbean> readMontadora(String param) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        final String sql = "SELECT * FROM produto WHERE montadora LIKE CONVERT('%#%' USING 'utf8');";
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
        }
        return produto;
    }

    public List<Produtosbean> readTipopeca(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        final String sql = "SELECT * FROM produto WHERE tipopeca LIKE CONVERT('%#%' USING 'utf8');";
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
        }
        return produto;
    }

    public List<Produtosbean> readAplicacao(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();
        final String sql = "SELECT * FROM produto WHERE aplicacao LIKE CONVERT('%#%' USING 'utf8');";
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
        }
        return produto;
    }

    public List<Produtosbean> readMotorAplicacao(String param) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        final String sql = "SELECT *"
                + "FROM produto AS p "
                + "JOIN tb_aplicacao AS tba "
                + "ON p.codigo = tba.cod_aplicacao "
                + "WHERE tba.motor LIKE CONVERT('%#%' USING 'utf8') "
                + "GROUP BY codigo;";

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql.replaceAll("#", param));
            rs = (ResultSet) stmt.executeQuery();
            System.out.println("\n" + stmt + "\n");

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
        }
        return produto;
    }
}