package Model;


public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String uType;
    
    public User(String nom,String prenom,String username,String password,String uType){
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.uType = uType;
    }
    
    public User(String username,String password,String utype){
        this.username = username;
        this.password = password;
        this.uType = utype;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdUser() {
        return idUser;
    }
    

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }
           
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }   

    public String getuType() {
        return uType;
    }
    
    
    
    
}
