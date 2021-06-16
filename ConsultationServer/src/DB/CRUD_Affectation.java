package DB;

import Model.Affectation;
import Model.Patient;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CRUD_Affectation {
    
    public boolean addAffectation(Affectation affectation){
        Connection con;
        PreparedStatement pstmt;
        String sql = "insert into affectation(idMedecin,idPatient,numSalle,date) values(?,?,?,?)";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, affectation.getIdMedecin());
            pstmt.setInt(2, affectation.getIdPatient());
            pstmt.setInt(3, affectation.getNumSalle());
            pstmt.setString(4, affectation.getDate());

            
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
    
    public boolean supprimer(Affectation affectation) {
        Connection con;
        PreparedStatement pstmt;
        String sql = "delete from affectation where idAffectation = ?";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, affectation.getIdAffectation());
            
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
