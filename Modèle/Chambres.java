/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

/**
 *
 * @author ibra
 */
public class Chambres {
    private int id_client;
    private String type;
    private String caractéristique;
    private String situation;
    private double prix;

    public Chambres(int id_client, String type, String caractéristique, String situation, double prix) {
        this.id_client = id_client;
        this.type = type;
        this.caractéristique = caractéristique;
        this.situation = situation;
        this.prix = prix;
    }
    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaractéristique() {
        return caractéristique;
    }

    public void setCaractéristique(String caractéristique) {
        this.caractéristique = caractéristique;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

  
    
   
}
