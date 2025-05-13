package model;

import java.sql.Date;

public class Note {
    private int id;
    private int etudiantId;
    private String matiere;
    private double valeur;
    private Date dateNote;
    
    private String nomEtudiant;

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }


    public Note() {}

    public Note(int etudiantId, String matiere, double valeur) {
        this.etudiantId = etudiantId;
        this.matiere = matiere;
        this.valeur = valeur;
    }

    // Getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getEtudiantId() {
        return etudiantId;
    }
    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getMatiere() {
        return matiere;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public double getValeur() {
        return valeur;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDateNote() {
        return dateNote;
    }
    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }
}
