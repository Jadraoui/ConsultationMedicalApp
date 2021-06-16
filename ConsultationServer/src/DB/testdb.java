/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class testdb {
       public static void main(String[] args){
           try {
               Connection con;
               ResultSet rs;
               PreparedStatement pstat;
               String req = "SELECT * FROM user";
               con = Connect_db.getCon();
               
               pstat = con.prepareStatement(req);
               
               rs = pstat.executeQuery();
               
               while(rs.next()){
                   System.out.println(rs.getString("nom"));
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(testdb.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    
}
