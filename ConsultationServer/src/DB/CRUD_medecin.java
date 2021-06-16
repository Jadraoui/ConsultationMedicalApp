package DB;

import Model.Patient;
import Model.User;
import Model.medecin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD_medecin {
    
    public  medecin getMedecin(String username){
        medecin med = null;
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String req = "select * from medecin where username = ?";
        
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idMedecin");
                String uname= rs.getString("username");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String specialite = rs.getString("specialite");
                String email = rs.getString("email");
                med = new medecin(id, username, nom, prenom, specialite, email);
            }
        }catch(SQLException e){
            System.out.println("Data Not Found Or "+e);
        }finally{
            return med;
        }
    }
    
    public boolean addUaddMedecin(medecin m){
        Connection con;
        PreparedStatement pstmt;
        String sql = "insert into medecin(username,nom,prenom) values(?,?,?)";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getUsername());
            pstmt.setString(2, m.getNom());
            pstmt.setString(3, m.getPrenom());

            
            int res = pstmt.executeUpdate();
            
            if(res > 0){
                System.out.println("bien insérer");
                return true;
            }else{
                return false;
            }
            
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    
}
