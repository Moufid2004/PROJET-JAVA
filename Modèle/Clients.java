
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

/**
 *
 * @author ibra
 */
public class Clients {
    private String nom;
    private String prenom;
    private int Telephone;
    private String CarteFidelite;
    private String pays;

    public Clients(String nom, String prenom, int Telephone, String CarteFidelite, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.Telephone = Telephone;
        this.CarteFidelite = CarteFidelite;
        this.pays = pays;
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

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    public String getCarteFidelite() {
        return CarteFidelite;
    }

    public void setCarteFidelite(String CarteFidelite) {
        this.CarteFidelite = CarteFidelite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    
}
 