/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

/**
 *
 * @author ibra
 */
public class Restaurant {
    private int idclient;
    private String plat;
    private int nbreplat;
    private int prix;

    public Restaurant(int idclient, String plat, int nbreplat, int prix) {
        this.idclient = idclient;
        this.plat = plat;
        this.nbreplat = nbreplat;
        this.prix = prix;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public int getNbreplat() {
        return nbreplat;
    }

    public void setNbreplat(int nbreplat) {
        this.nbreplat = nbreplat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

   
    
}
