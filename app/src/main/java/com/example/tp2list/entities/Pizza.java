package com.example.tp2list.entities;

public class Pizza {
    private static int lastId = 0;
    private int id;
    private String nom;
    private int nbrIngredients;
    private int photo;
    private float duree;
    private String detailsIngred;
    private String description;
    private String preparation;
    private int comp;

    // Constructor without parameters
    public Pizza() {
    }

    // Constructor with parameters (auto-incrementing id)
    public Pizza(String nom, int nbrIngredients, int photo, String duree, String detailsIngred,
                 String description, String preparation, int comp) {
        this.id = ++lastId;
        this.nom = nom;
        this.nbrIngredients = nbrIngredients;
        this.photo = photo;
        this.duree = Float.parseFloat(duree.split(" ")[0]); // Extract numeric value from "XX min"
        this.detailsIngred = detailsIngred;
        this.description = description;
        this.preparation = preparation;
        this.comp = comp;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrIngredients() {
        return nbrIngredients;
    }

    public void setNbrIngredients(int nbrIngredients) {
        this.nbrIngredients = nbrIngredients;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public String getDetailsIngred() {
        return detailsIngred;
    }

    public void setDetailsIngred(String detailsIngred) {
        this.detailsIngred = detailsIngred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrIngredients=" + nbrIngredients +
                ", photo=" + photo +
                ", duree=" + duree +
                ", detailsIngred='" + detailsIngred + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                ", comp=" + comp +
                '}';
    }
}