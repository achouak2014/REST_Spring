package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "nom")
    @NotNull(message = "Le champ nom ne peut être null")
    @NotBlank(message = "le nom ville ne peut être vide ")
    private String nom ;

    @Column(name = "prenom")
    @NotNull(message = "Le champ prenom ne peut être null")
    @NotBlank(message = "le champ prenom ne peut être vide ")
    private String prenom ;

    @Column(name = "dateNaissance")
    @NotNull(message = "Le champ adresse ne peut être null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;

    @Column(name = "adress")
    @NotNull(message = "Le champ adresse ne peut être null")
    @NotBlank(message = "le champ adresse ne peut être vide ")
    private String adress ;

    @Column(name = "ville")
    @NotNull(message = "Le champ ville ne peut être null")
    @NotBlank(message = "le champ ville ne peut être vide ")
    private String ville ;

    @Column(name = "codePostal")
    @NotNull(message = "Le champ postal ne peut être null")
    @NotBlank(message = "le champ postal ne peut être vide ")
    private String codePostal ;

public Candidat (){

}

    public Candidat(String nom, String prenom, Date dateNaissance, String adress, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adress = adress;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adress='" + adress + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
