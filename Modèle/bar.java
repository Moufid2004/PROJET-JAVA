/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

/**
 *
 * @author ibra
 */
public class bar {
    private int idclientbar;
    private String boisson;
    private int nbre;
    private int prixbar;

    public bar(int idclientbar, String boisson, int nbre, int prixbar) {
        this.idclientbar = idclientbar;
        this.boisson = boisson;
        this.nbre = nbre;
        this.prixbar = prixbar;
    }

    public int getIdclientbar() {
        return idclientbar;
    }

    public void setIdclientbar(int idclientbar) {
        this.idclientbar = idclientbar;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    public int getNbre() {
        return nbre;
    }

    public void setNbre(int nbre) {
        this.nbre = nbre;
    }

    public int getPrixbar() {
        return prixbar;
    }

    public void setPrixbar(int prixbar) {
        this.prixbar = prixbar;
    }
    
    
    
}
