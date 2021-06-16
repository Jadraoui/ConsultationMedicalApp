package Model;

public class Affectation {
    
    private int idAffectation;
    private int idMedecin;
    private int idPatient;
    private int numSalle;
    private String date;
    
    public Affectation(){
        
    }

    public Affectation(int idAffectation, int idMedecin, int idPatient, int numSalle, String date) {
        this.idAffectation = idAffectation;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.numSalle = numSalle;
        this.date = date;
    }
    public Affectation(int idMedecin, int idPatient, int numSalle, String date) {
        
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.numSalle = numSalle;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getIdAffectation() {
        return idAffectation;
    }

   

    public int getNumSalle() {
        return numSalle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdAffectation(int idAffectation) {
        this.idAffectation = idAffectation;
    }

  

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
    
    
    
    
    
}
