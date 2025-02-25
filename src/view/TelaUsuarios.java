/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionFactory;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.UsuarioTableModel;
import model.dao.usuarioDAO;

/**
 *
 * @author JOAOARTHURDELIMAFLOR
 */
public class TelaUsuarios extends javax.swing.JFrame {

    public UsuarioTableModel userTableModel;
    public usuarioDAO uDAO;

    public String username;
    public String email;
    public String senha;
    public int id;
    public String desconto;

    public TelaUsuarios() {
        initComponents();
        setIcon();

        uDAO = new usuarioDAO();

        userTableModel = new UsuarioTableModel(uDAO.read());
        jTabelaUsuarios.setModel(userTableModel);

        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(5);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuarios = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnDesconto = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        paneEditar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnClearFields = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        txtEmpresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de usuários");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabelaUsuarios.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "desconto", "ID", "Usuario", "E-mail", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaUsuarios.setFillsViewportHeight(true);
        jTabelaUsuarios.setGridColor(new java.awt.Color(32, 56, 100));
        jTabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUsuariosMouseClicked(evt);
            }
        });
        jTabelaUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTabelaUsuariosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUsuarios);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar Dados");
        btnEditar.setBorder(null);
        btnEditar.setEnabled(false);
        btnEditar.setHideActionText(true);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDesconto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDesconto.setText("Definir Desconto");
        btnDesconto.setEnabled(false);
        btnDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontoActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDel.setText("Remover Usuario");
        btnDel.setEnabled(false);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Usuários Cadastrados");

        paneEditar.setBackground(new java.awt.Color(255, 255, 255));
        paneEditar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        paneEditar.setEnabled(false);

        jLabel2.setText("ID");

        txtID.setEnabled(false);

        txtUser.setEnabled(false);

        jLabel3.setText("Nome de usuário");

        txtSenha.setEnabled(false);

        txtEmail.setEnabled(false);

        jLabel4.setText("Senha");

        jLabel5.setText("E-Mail");

        txtTel.setEnabled(false);

        jLabel6.setText("Telefone");

        txtCNPJ.setEnabled(false);

        jLabel7.setText("CNPJ");

        btnClearFields.setText("Limpar Campos");
        btnClearFields.setEnabled(false);
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        btnAlterar.setText("Aplicar Alterações");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txtEmpresa.setEnabled(false);

        jLabel8.setText("Empresa");

        javax.swing.GroupLayout paneEditarLayout = new javax.swing.GroupLayout(paneEditar);
        paneEditar.setLayout(paneEditarLayout);
        paneEditarLayout.setHorizontalGroup(
            paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneEditarLayout.createSequentialGroup()
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneEditarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(paneEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneEditarLayout.createSequentialGroup()
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(159, 159, 159))))
            .addGroup(paneEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneEditarLayout.createSequentialGroup()
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneEditarLayout.createSequentialGroup()
                                .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(paneEditarLayout.createSequentialGroup()
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneEditarLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel7)))))
                .addContainerGap())
        );
        paneEditarLayout.setVerticalGroup(
            paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneEditarLayout.createSequentialGroup()
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneEditarLayout.createSequentialGroup()
                        .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int selectedRow = jTabelaUsuarios.getSelectedRow();
        String RowClick = (jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString());

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        JOptionPane.showConfirmDialog(this, "deseja REMOVER " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 2).toString() + "?");

        try {
            stmt = con.prepareStatement("DELETE FROM tb_usuarios WHERE id = " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString() + " ");

            stmt.executeUpdate();
            userTableModel.setDados(uDAO.read());

            JOptionPane.showMessageDialog(this, "Removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao remover \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void jTabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuariosMouseClicked
        int selectedRow = jTabelaUsuarios.getSelectedRow();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (jTabelaUsuarios.getSelectedRow() != -1) {
            btnDel.setEnabled(true);
            btnDesconto.setEnabled(true);
            btnEditar.setEnabled(true);
        } else {
            btnDel.setEnabled(false);
            btnDesconto.setEnabled(false);
            btnEditar.setEnabled(false);
        }
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_usuarios WHERE id = " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString() + "");

            rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                txtID.setText(id);
                String username = rs.getString("username");
                txtUser.setText(username);
                String email = rs.getString("email");
                txtEmail.setText(email);
                String senha = rs.getString("senha");
                txtSenha.setText(senha);
                String empresa = rs.getString("empresa");
                txtEmpresa.setText(empresa);
                String CNPJ = rs.getString("CNPJ");
                txtCNPJ.setText(CNPJ);
                String telefone = rs.getString("telefone");
                txtTel.setText(telefone);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao obter os dados do usuário. \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
        }
    }//GEN-LAST:event_jTabelaUsuariosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtCNPJ.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSenha.setEnabled(true);
        txtTel.setEnabled(true);
        txtUser.setEnabled(true);
        txtEmpresa.setEnabled(true);
        
        btnAlterar.setEnabled(true);
        btnClearFields.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontoActionPerformed
        int selectedRow = jTabelaUsuarios.getSelectedRow();

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        desconto = JOptionPane.showInputDialog(this, "Insira um número correspondente ao desconto que deseja aplicar: \n"
                + "0 = Preço Cheio \n"
                + "1 = 40% (0,6) \n"
                + "2 = 43% (0,57) \n"
                + "3 = 46% (0,54) \n"
                + "4 = 50% (0,5) \n"
                + "5 = 52,6% (0,475) \n"
                + "6 = 55% (0,45) \n"
                + "7 = 57,25% (0,4275) \n"
                + "8 = 59,5% (0,405) \n"
                + "9 = 61,53% (0,3847) \n");
        System.out.println("desconto: " + desconto);
        System.out.println("id: " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString());

        try {
            stmt = con.prepareStatement("UPDATE tb_usuarios SET desconto = " + desconto + " WHERE id = " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString() + " ");

            stmt.executeUpdate();
            userTableModel.setDados(uDAO.read());
            

            JOptionPane.showMessageDialog(this, "Desconto alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar desconto: \n" + ex);
        } finally {
            ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt);
        }
    }//GEN-LAST:event_btnDescontoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        usuarioDAO uDAO = new usuarioDAO();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (txtCNPJ.getText().equals("")
                || txtEmail.getText().equals("")
                || txtSenha.getText().equals("")
                || txtTel.getText().equals("")
                || txtEmpresa.getText().equals("")
                || txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Complete todos os campos para continuar");
        } else {

            try {
                stmt = con.prepareStatement("UPDATE tb_usuarios "
                        + "SET username = '" + txtUser.getText() + "', "
                        + "email = '" + txtEmail.getText() + "', "
                        + "senha = '" + txtSenha.getText() + "', "
                        + "empresa = '" + txtEmpresa.getText() + "', "
                        + "CNPJ = '" + txtCNPJ.getText() + "', "
                        + "telefone = '" + txtTel.getText() + "' "
                        + "WHERE id = '" +txtID.getText()+ "';");
                stmt.executeUpdate();
                userTableModel.setDados(uDAO.read());                

                JOptionPane.showMessageDialog(rootPane, "Dados do usuário alterados com sucesso");
            } catch (SQLException ex) {
                System.out.println(stmt);
                JOptionPane.showMessageDialog(rootPane, "Erro ao alterar os dados do usuario \n" + ex);
            } finally {
                ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
            }          
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jTabelaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabelaUsuariosKeyReleased
        int selectedRow = jTabelaUsuarios.getSelectedRow();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (jTabelaUsuarios.getSelectedRow() != -1) {
                btnDel.setEnabled(true);
                btnDesconto.setEnabled(true);
                btnEditar.setEnabled(true);
            } else {
                btnDel.setEnabled(false);
                btnDesconto.setEnabled(false);
                btnEditar.setEnabled(false);
            }
            try {
                stmt = con.prepareStatement("SELECT * FROM tb_usuarios WHERE id = " + jTabelaUsuarios.getModel().getValueAt(selectedRow, 0).toString() + "");

                rs = stmt.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    txtID.setText(id);
                    String username = rs.getString("username");
                    txtUser.setText(username);
                    String email = rs.getString("email");
                    txtEmail.setText(email);
                    String senha = rs.getString("senha");
                    txtSenha.setText(senha);
                    String empresa = rs.getString("empresa");
                    txtEmpresa.setText(empresa);
                    String CNPJ = rs.getString("CNPJ");
                    txtCNPJ.setText(CNPJ);
                    String telefone = rs.getString("telefone");
                    txtTel.setText(telefone);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao obter os dados do usuário. \n" + ex);
            } finally {
                ConnectionFactory.closeconnection((com.mysql.jdbc.Connection) (java.sql.Connection) con, stmt, (java.sql.ResultSet) rs);
            }
        }
    }//GEN-LAST:event_jTabelaUsuariosKeyReleased

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        txtCNPJ.setText("");
        txtEmail.setText("");
        txtEmpresa.setText("");
        txtSenha.setText("");
        txtTel.setText("");
        txtUser.setText("");
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDesconto;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaUsuarios;
    private javax.swing.JPanel paneEditar;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    private void setIcon () {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }
}
