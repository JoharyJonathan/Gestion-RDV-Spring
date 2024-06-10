package com.johary.rdvpt.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Creneaux> creneaux;

    public Medecin()
    {

    }

    public Medecin(String titre, String nom, String prenom, List<Creneaux> creneaux) {
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.creneaux = creneaux;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Creneaux> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneaux> creneaux) {
        this.creneaux = creneaux;
    }
}
