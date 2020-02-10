/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bean.Usuariobean;
import view.TelaCadastro;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class usuarioDAO {

    carrinhoDAO cDAOEnviaID;
    usuarioDAO uDAO;

    public void create(Usuariobean p) {
        TelaCadastro telaCad = new TelaCadastro();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_usuarios "
                    + "(username, "
                    + "email, "
                    + "senha, "
                    + "empresa, "
                    + "CNPJ, "
                    + "telefone) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? );");

            stmt.setString(1, p.getUsername());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.setString(4, p.getEmpresa());
            stmt.setString(5, p.getCNPJ());
            stmt.setString(6, p.getTelefone());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(telaCad, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaCad, "Erro ao cadastrar-se \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }

    }

    public void update(Usuariobean p) throws FileNotFoundException {
        usuarioDAO uDAO = new usuarioDAO();
        String arq = "conf.txt";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("UPDATE tb_usuarios "
                    + "SET username = ?, "
                    + "email = ?, "
                    + "senha = ?, "
                    + "empresa = ?, "
                    + "CNPJ = ?, "
                    + "telefone = ?"
                    + "WHERE id = " + uDAO.Read(arq) + ";");

            stmt.setString(1, p.getUsername());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getSenha());
            stmt.setString(4, p.getEmpresa());
            stmt.setString(5, p.getCNPJ());
            stmt.setString(6, p.getTelefone());

            stmt.executeUpdate();

            System.out.println("deu bom");
        } catch (SQLException ex) {
            System.out.println(stmt);
            System.out.println("deu ruim \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }

    }

    public List<Usuariobean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuariobean> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_usuarios");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuariobean user = new Usuariobean();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setDesconto(rs.getInt("desconto"));

                usuarios.add(user);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return usuarios;
    }

    public List<Usuariobean> readUserEmail(JTextField txtuser, JTextField txtemail) throws FileNotFoundException {
        String arq = "conf.txt";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuariobean> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT username, email FROM tb_usuarios WHERE id = " + this.Read(arq) + "");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuariobean user = new Usuariobean();

                String username = rs.getString("username");
                txtuser.setText(username);
                String email = rs.getString("email");
                txtemail.setText(email);

                usuarios.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return usuarios;
    }

    public List<Usuariobean> readUserEmailEmpresa(JTextField txtuser, JTextField txtemail, JTextField txtempresa) throws FileNotFoundException {
        String arq = "conf.txt";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuariobean> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT username, email, empresa FROM tb_usuarios WHERE id = " + this.Read(arq) + "");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuariobean user = new Usuariobean();

                String username = rs.getString("username");
                txtuser.setText(username);
                String email = rs.getString("email");
                txtemail.setText(email);
                String empresa = rs.getString("empresa");
                txtempresa.setText(empresa);

                usuarios.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return usuarios;
    }

    public int read2() throws FileNotFoundException {

        String arq = "conf.txt";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuariobean> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT desconto FROM tb_usuarios WHERE id = " +this.Read(arq)+ "");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuariobean user = new Usuariobean();
                
                user.setDesconto(rs.getInt("desconto"));

                usuarios.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return 0;
    }

    public boolean CheckLogin(String username, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_usuarios WHERE username = ? AND senha = ?");
            stmt.setString(1, username);
            stmt.setString(2, senha);
            rs = (ResultSet) stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return check;
    }

    public String getId(String username, String senha) {
        String texto = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT id FROM tb_usuarios WHERE username = '"+username+"' AND senha = '"+senha+"'");
            rs = (ResultSet) stmt.executeQuery();
            System.out.println("\n"+stmt+"\n");
            rs.next();
                
                String id = rs.getString("id");
                texto = id;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
        return texto;
    }

    public static String Read(String diretorio) throws FileNotFoundException {
        String conteudo = "";
        diretorio = "conf.txt";
        try {
            FileReader arq;
            arq = new FileReader("..\\nbproject\\private\\" +diretorio);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha;
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Não foi possível ler o arquivo " + ex);
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado " + ex);
            return "";
        }
    }

    public static boolean Write(String texto) {        
        String diretorio = "conf.txt";
        try {
            FileWriter arq;
            arq = new FileWriter("..\\nbproject\\private\\" +diretorio);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(texto);
            gravarArq.close();
            System.out.println("Criou " +diretorio);
            return true;
        } catch (IOException e) {
            System.out.println("Nao criou ..\\nbproject\\private\\" +diretorio+ ". " + e);
            return false;
        }
    }
}
