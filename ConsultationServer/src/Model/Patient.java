package Model;

public class Patient {
    
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String datNaissance;
    private String ville;

    public Patient() {
    }

    public Patient(String nom, String prenom, String telephone, String email, String datNaissance, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.datNaissance = datNaissance;
        this.ville = ville;
    }

    public Patient(int id, String nom, String prenom, String telephone, String email, String datNaissance, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.datNaissance = datNaissance;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getDatNaissance() {
        return datNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setDatNaissance(String datNaissance) {
        this.datNaissance = datNaissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
    
}
