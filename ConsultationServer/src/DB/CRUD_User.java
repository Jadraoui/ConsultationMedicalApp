package DB;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD_User {
    
    public boolean addUser(User user){
        Connection con;
        PreparedStatement pstmt;
        String sql = "insert into User(nom,prenom,username,password,utype) values(?,?,?,?,?)";
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getNom());
            pstmt.setString(2, user.getPrenom());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getuType());

            
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
    
    
    
    public User login(String username,String password){
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        String req = "select * from user where username = ? and password = ?"; 
        User user=null;
        try{
            con = Connect_db.getCon();
            pstmt = con.prepareStatement(req);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String uname = rs.getString("username");
                String upass = rs.getString("password");
                String utype = rs.getString("utype");
                user = new User(uname,upass,utype);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            return user;
        }
    }
    
    
    
    
    
}
