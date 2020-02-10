/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.bean.Produtosbean;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class carrinhoDAO {

    usuarioDAO uDAO = new usuarioDAO();
    String arq = "conf.txt";
    String texto = uDAO.Read(arq);

    public carrinhoDAO() throws FileNotFoundException {

    }

    public void create(Produtosbean p) throws FileNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_carrinho (id_produto, qtd, id_usuario) values (?,?," + uDAO.Read(arq) + ")");
            stmt.setInt(1, p.getCodigo());
            stmt.setInt(2, p.getQtd());

            stmt.executeUpdate();
            System.out.println(texto);

        } catch (SQLException ex) {
            System.out.println("deu ruim " + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
    }

    public void update(Produtosbean p, JTable tabela, int ID, int qtd) throws FileNotFoundException {
        if (tabela.getSelectedColumn() == 2) {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            try {
                stmt = con.prepareStatement("UPDATE tb_carrinho "
                        + "SET qtd = ? "
                        + "WHERE id_produto = " + ID + " "
                        + "AND qtd = " + qtd + ";");
                stmt.setInt(1, p.getQtd());
                stmt.executeUpdate();

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
            }
        }
    }

    public List<Produtosbean> read() throws FileNotFoundException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT c.id_usuario, c.id_produto, p.aplicacao, p.preco, c.qtd "
                    + "FROM tb_carrinho AS c "
                    + "JOIN produto AS p "
                    + "ON c.id_produto = p.codigo "
                    + "WHERE c.id_usuario = " + uDAO.Read(arq) + " "
                    + "ORDER BY c.id_produto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtosbean produtos = new Produtosbean();

                produtos.setCodigo(rs.getInt("c.id_produto"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setQtd(rs.getInt("c.qtd"));

                produto.add(produtos);
            }
        } catch (SQLException ex) {
            System.out.println("deu ruim. " + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return produto;
    }

    public List<Produtosbean> readProduto(String prod) throws FileNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produtosbean> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT c.id_usuario, c.id_produto, p.aplicacao, p.preco, c.qtd "
                    + "FROM tb_carrinho AS c "
                    + "JOIN produto AS p "
                    + "ON c.id_produto = p.codigo "
                    + "WHERE c.id_usuario = " + uDAO.Read(arq) + " "
                    + "ORDER BY c.id_produto;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtosbean produtos = new Produtosbean();

                produtos.setCodigo(rs.getInt("c.id_produto"));
                produtos.setPreco(rs.getDouble("preco"));
                produtos.setQtd(rs.getInt("c.qtd"));

                produto.add(produtos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return produto;
    }

    public List<Produtosbean> delete(JFrame tela, int cod, int qtd) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        List<Produtosbean> produto = new ArrayList<>();

        System.out.println("remover");
        try {
            stmt = con.prepareStatement("DELETE FROM tb_carrinho "
                    + "WHERE id_produto = " +cod+ " "
                    + "AND qtd = " +qtd+ ";");
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
        return produto;
    }

    public List<Produtosbean> clearCart() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        List<Produtosbean> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("DELETE FROM tb_carrinho WHERE id_usuario = " +uDAO.Read(arq)+ "");
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao limpar carrinho \n" + ex);
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO! Identificador de ID não encontrado \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
        return produto;
    }

    public String readAplicacao(int cod, JLabel label) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT p.aplicacao \n"
                    + "    FROM tb_carrinho as c \n"
                    + "    JOIN produto as p \n"
                    + "    ON c.id_produto = p.codigo \n"
                    + "    WHERE c.id_produto = " + cod + ";");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String aplicacao = rs.getString("aplicacao");
                label.setText(aplicacao);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return null;
    }

    public List<Produtosbean> search(int cod) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtosbean> aplicacao = new ArrayList<>();

        try {
            stmt = (PreparedStatement) con.prepareStatement(" SELECT * from tb_aplicacao WHERE codigo = ? ;");
            stmt.setInt(1, cod);

            rs = (ResultSet) stmt.executeQuery();

            while (rs.next()) {

                Produtosbean aplic = new Produtosbean();

                aplic.setAplicacao(rs.getString("aplicacao"));

                aplicacao.add(aplic);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return aplicacao;
    }
}
