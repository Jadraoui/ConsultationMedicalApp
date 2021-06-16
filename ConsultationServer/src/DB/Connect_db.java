package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_db {
        
        private static Connection con;
        private static String url = "jdbc:mysql://localhost/suivimedical";
	private static String uname = "root";
	private static String pass = "";
        static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,uname,pass);
                //System.out.println("Connection bien établie");
            }catch(ClassNotFoundException e){
                System.out.println("problème au niveau du pilote");
            } catch (SQLException ex) {
                System.out.println("Erreur au niveau BD");
            }
        }
        
        public static Connection getCon(){
            return con;
        }
    
}