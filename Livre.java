package org.example.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livre")
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long isbn;
    public String titre;
    public String auteur;
    public String editeur;
    public double prix;


    public Livre() {
    }

    public Livre(Long isbn,String titre, String auteur, String editeur, double prix) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.prix = prix;
    }


    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "isbn='" + isbn + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", prix=" + prix +
                '}';
    }
}
