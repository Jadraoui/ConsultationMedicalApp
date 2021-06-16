
import DB.CRUD_Affectation;
import DB.Connect_db;
import Model.Affectation;
import Model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AffectationGUI extends javax.swing.JFrame {

  
    public AffectationGUI() {
        initComponents();
        txtId.setEditable(false);
        loadMedecin();
        loadPatient();
        data_table();
    }

    

    
    public void data_table(){
       
            Connection con;
            PreparedStatement pstmt;
            ResultSet rs;
            String req = "select a.idAffectation,u.nom,p.nom as 'nompatient',a.numSalle,a.date"
                    + " from affectation a,user u,patient p where a.idMedecin=u.id and a.idPatient=p.idPatient ";
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
                    v2.add(rs.getInt("idAffectation"));
                    v2.add(rs.getString("nom"));
                    v2.add(rs.getString("nompatient"));
                    v2.add(rs.getInt("numSalle"));
                    v2.add(rs.getString("date"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    
    public class Mmedecin{
        int id;
        String nom;
        
        public Mmedecin(int id,String nom){
            this.id = id;
            this.nom = nom;
        }
        
        public String toString(){
            return this.nom;
        }
        
    }
    
    public void loadMedecin(){
        try {
            Connection con;
            PreparedStatement pstmt;
            ResultSet rs;
            String req = "select * from user where utype like 'Medecin' ";
        
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            rs = pstmt.executeQuery();
            
            txtmedecin.removeAll();
            while(rs.next()){
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                txtmedecin.addItem(new Mmedecin(id,nom));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AffectationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public class Ppatient {
        int id;
        String nom;
        
        public Ppatient(int id,String nom){
            this.id = id;
            this.nom = nom;
        }
        
        public String toString(){
            return this.nom;
        }
        
    }
    
    public void loadPatient(){
        try {
            Connection con;
            PreparedStatement pstmt;
            ResultSet rs;
            String req = "select * from patient order by idPatient desc";
        
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            rs = pstmt.executeQuery();
            
            txtPatient.removeAll();
            while(rs.next()){
                int id = rs.getInt("idPatient");
                String nom = rs.getString("nom");
                txtPatient.addItem(new Ppatient(id,nom));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AffectationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    
    CRUD_Affectation crud_affectation = new CRUD_Affectation();
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        txtPatient = new javax.swing.JComboBox();
        txtmedecin = new javax.swing.JComboBox();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtsalle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("AJOUTER UNE AFFECTATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 430, 50));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel2.setText("Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel3.setText("Affectation ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel4.setText("Nom médecin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel5.setText("Nom patient");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel6.setText("Numéro salle");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txtdate.setText("JJ/MM/YYYY");
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 210, 30));

        getContentPane().add(txtPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 210, 30));

        getContentPane().add(txtmedecin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 210, 30));

        txtId.setText("Générer automatiquement...");
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 210, 30));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 80, 40));
        getContentPane().add(txtsalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 210, 30));

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Médecin", "Patient", "Salle", "Date"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 540, 300));

        jButton2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 140, 40));

        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton3.setText("Anuuler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 140, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Mmedecin nomMed = (Mmedecin)txtmedecin.getSelectedItem();
        Ppatient nomPatient = (Ppatient) txtPatient.getSelectedItem();
        int numSalle = Integer.parseInt(txtsalle.getText());
        String d = txtdate.getText();
        Affectation affectation = new Affectation(nomMed.id, nomPatient.id, numSalle, d);
        if(crud_affectation.addAffectation(affectation)){
            JOptionPane.showMessageDialog(this, "Inséré avec succès");
            txtsalle.setText("");
            txtdate.setText("");
            data_table();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur d'insertion ! Réessayer");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        this.txtId.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 0).toString());
        this.txtmedecin.setSelectedItem(tbldata.getValueAt(tbldata.getSelectedRow(), 1).toString());
        this.txtPatient.setSelectedItem(tbldata.getValueAt(tbldata.getSelectedRow(), 2).toString());
        this.txtsalle.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 3).toString());
        this.txtdate.setText(tbldata.getValueAt(tbldata.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tbldataMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int id = Integer.parseInt(txtId.getText());
        Mmedecin nomMed = (Mmedecin)txtmedecin.getSelectedItem();
        Ppatient nomPatient = (Ppatient) txtPatient.getSelectedItem();
        int numSalle = Integer.parseInt(txtsalle.getText());
        String d = txtdate.getText();
        Affectation aff = new Affectation(id,nomMed.id,nomPatient.id,numSalle,d);
        if(crud_affectation.supprimer(aff)){
            JOptionPane.showMessageDialog(this, "Supprimé avec succès");
            txtId.setText("");
            txtsalle.setText("");
            txtdate.setText("");
            data_table();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur de suppression ! Réessayer");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AffectationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffectationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffectationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffectationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffectationGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox txtPatient;
    private javax.swing.JTextField txtdate;
    private javax.swing.JComboBox txtmedecin;
    private javax.swing.JTextField txtsalle;
    // End of variables declaration//GEN-END:variables
}
