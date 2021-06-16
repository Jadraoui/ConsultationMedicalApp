
import DB.CRUD_Patient;
import DB.Connect_db;
import Model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moham
 */
public class PatientGUI extends javax.swing.JFrame {
    
    CRUD_Patient crud_patient = new CRUD_Patient();

    
    public PatientGUI() {
        initComponents();
        data_table();
        txtId.setEditable(false);
    }
    
   public void data_table(){
       
            Connection con;
            PreparedStatement pstmt;
            ResultSet rs;
            String req = "select * from patient order by idPatient desc";
        try {
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            rs = pstmt.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;
            c = Rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) tbldata.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getInt("idPatient"));
                    v2.add(rs.getString("nom"));
                    v2.add(rs.getString("prenom"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("dateNaissance"));
                    v2.add(rs.getString("ville"));
                    v2.add(rs.getString("telephone"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDatenaissance = new javax.swing.JTextField();
        txtVille = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        btnajouter1 = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("GESTION PATIENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 340, 50));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel3.setText("TELEPHONE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 140, 30));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel5.setText("id");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 30));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel6.setText("PRENOM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel7.setText("EMAIL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 30));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel8.setText("DATE DE NAISSANCE ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 30));

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel9.setText("VILLE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 70, 30));
        getContentPane().add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 240, 30));
        getContentPane().add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 240, 30));
        getContentPane().add(txtPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 240, 30));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 240, 30));
        getContentPane().add(txtDatenaissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 240, 30));
        getContentPane().add(txtVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 240, 30));

        btnExit.setBackground(new java.awt.Color(255, 0, 0));
        btnExit.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 70, 30));

        btnSupprimer.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnSupprimer.setText("SUPPRIMER");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(btnSupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 150, 50));

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Patient", "Nom", "Prénom", "Email", "Date Naissance", "Ville", "Telephone"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 590, 330));

        btnajouter1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnajouter1.setText("AJOUTER");
        btnajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajouter1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnajouter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 150, 50));

        btnModifier.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        btnModifier.setText("MODIFIER");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        getContentPane().add(btnModifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 150, 50));

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel10.setText("NOM");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, 30));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 240, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        
        Patient p = new Patient(Integer.parseInt(txtId.getText()),txtNom.getText(),
                txtPrenom.getText(),txtTelephone.getText(),txtEmail.getText(),
                txtDatenaissance.getText(),txtVille.getText());
        
        if(crud_patient.supprimer(p)){
            JOptionPane.showMessageDialog(this, "Bien supprimer");
            txtId.setText("");
            txtNom.setText("");
            txtPrenom.setText("");
            txtTelephone.setText("");
            txtEmail.setText("");
            txtDatenaissance.setText("");
            txtVille.setText("");
            data_table();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur! Réessayer");
        }
        
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajouter1ActionPerformed
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String telephone = txtTelephone.getText();
        String email = txtEmail.getText();
        String datnaissance = txtDatenaissance.getText();
        String ville = txtVille.getText();
        
        Patient npatient = new Patient(nom, prenom, telephone, email, datnaissance, ville);
        
        if(crud_patient.addPatient(npatient)){
            JOptionPane.showMessageDialog(this, "Inséré avec succès");
            txtNom.setText("");
            txtPrenom.setText("");
            txtTelephone.setText("");
            txtEmail.setText("");
            txtDatenaissance.setText("");
            txtVille.setText("");
            data_table();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur d'insertion ! Réessayer");
        }
    }//GEN-LAST:event_btnajouter1ActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        Patient p = new Patient(Integer.parseInt(txtId.getText()),txtNom.getText(),
                txtPrenom.getText(),txtTelephone.getText(),txtEmail.getText(),
                txtDatenaissance.getText(),txtVille.getText());
        if(crud_patient.modifier(p)){
            JOptionPane.showMessageDialog(this, "Bien modifier");
            txtId.setText("");
            txtNom.setText("");
            txtPrenom.setText("");
            txtTelephone.setText("");
            txtEmail.setText("");
            txtDatenaissance.setText("");
            txtVille.setText("");
            data_table();
        }else {
            JOptionPane.showMessageDialog(this, "Erreur! Réessayer");
        }
    }//GEN-LAST:event_btnModifierActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        this.txtId.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 0).toString());
        this.txtNom.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 1).toString());
        this.txtPrenom.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 2).toString());
        this.txtEmail.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 3).toString());
        this.txtDatenaissance.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
        this.txtVille.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 5).toString());
        this.txtTelephone.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tbldataMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        
    }//GEN-LAST:event_txtIdActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JButton btnajouter1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtDatenaissance;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtVille;
    // End of variables declaration//GEN-END:variables
}
