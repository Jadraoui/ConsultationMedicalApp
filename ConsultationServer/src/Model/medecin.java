package Model;

public class medecin {
    
    private int id;
    private String username;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;

    public medecin() {
    }
    
    public medecin(String username,String nom,String prenom){
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
    }

    public medecin(int id,String username, String nom, String prenom, String specialite, String email) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    
    
    
}
