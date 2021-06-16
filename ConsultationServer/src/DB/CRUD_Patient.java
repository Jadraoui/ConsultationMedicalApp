package DB;

import Model.Patient;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CRUD_Patient {
    
    public boolean addPatient(Patient patient){
        Connection con;
        PreparedStatement pstmt;
        String sql = "insert into patient(nom,prenom,telephone,email,dateNaissance,ville) values(?,?,?,?,?,?)";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setString(3, patient.getTelephone());
            pstmt.setString(4, patient.getEmail());
            pstmt.setString(5, patient.getDatNaissance());
            pstmt.setString(6, patient.getVille());

            
            int res = pstmt.executeUpdate();
            
            if(res > 0){
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public  ArrayList<Patient> getPatients(){
        ArrayList<Patient> data = new ArrayList<>();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String req = "select * from patient order by idPatient desc";
        
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idPatient");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String dateNaissance = rs.getString("dateNaissance");
                String ville = rs.getString("ville");
                Patient pat = new Patient(id, nom, prenom, telephone, email, dateNaissance, ville);
                data.add(pat);
            }
        }catch(SQLException e){
            System.out.println("Data Not Found Or "+e);
        }finally{
            return data;
        }
    }
    
    public boolean modifier(Patient patient) {
        Connection con;
        PreparedStatement pstmt;
        String sql = "update patient set nom = ?, prenom = ?, telephone = ?, email = ?, dateNaissance = ?, ville = ? where idPatient = ? ";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setString(3, patient.getTelephone());
            pstmt.setString(4, patient.getEmail());
            pstmt.setString(5, patient.getDatNaissance());
            pstmt.setString(6, patient.getVille());
            pstmt.setInt(7, patient.getId());
            
            int res = pstmt.executeUpdate();
            
            if(res > 0){
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erreur "+e.getMessage());
            return false;
        }
        
    }
    
    public boolean supprimer(Patient patient) {
        Connection con;
        PreparedStatement pstmt;
        String sql = "delete from patient where idPatient = ?";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, patient.getId());
            
            int res = pstmt.executeUpdate();
            
            if(res > 0){
                //con.close();
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erreur "+e.getMessage());
            return false;
        }
    }
    
    
}
