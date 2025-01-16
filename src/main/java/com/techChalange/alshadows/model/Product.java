package com.techChalange.alshadows.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le nom du produit ne peut pas être nul")
    @NotEmpty(message = "Le nom du produit ne peut pas être vide")
    private String nom;

    @NotNull(message = "La description ne peut pas être nulle")
    @NotEmpty(message = "La description ne peut pas être vide")
    private String description;

    @NotNull(message = "Le prix ne peut pas être nul")
    @Positive(message = "Le prix doit être un nombre positif")
    private double prix;

    // Getter pour id
    public Long getId() {
        return id;
    }

    // Setter pour id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour description
    public String getDescription() {
        return description;
    }

    // Setter pour description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter pour prix
    public double getPrix() {
        return prix;
    }

    // Setter pour prix
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
