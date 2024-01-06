/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import vue.Databasemanager;
import java.util.ArrayList;
import java.util.List;
import Modèle.Restaurant;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Controllerestaurant {
    private static String AJOUT="INSERT INTO restaurant(idclient,plat,nombreplat,prixplat) VALUES(?,?,?,?)";
    private static String SUPRESSION="DELETE FROM restaurant  WHERE idcommande=?;";
    PreparedStatement ABI;

    public Controllerestaurant() {
    }
    
    public void ajoutercommande(Restaurant a){
         int ABA=0;
          try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
            ABI.setInt(1,a.getIdclient());
            ABI.setString(2, a.getPlat());
            ABI.setInt(3, a.getNbreplat());
            ABI.setInt(4, a.getPrix());
            ABA=ABI.executeUpdate();
             if(ABA>0){
            JOptionPane.showMessageDialog(null, "commande ajouter avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de la commande");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Databasemanager.fermerConnection();
        }
    }
     public void supprimercommande(Restaurant c,String num){
        int ABA=0;
        int p=JOptionPane.showConfirmDialog(null, "êtes vous sûre de vouloir supprimer cette Commande?","Suprimer",JOptionPane.YES_NO_OPTION);
        if(p==0){
        try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(SUPRESSION);
            ABI.setString(1, num);
            ABA=ABI.executeUpdate();
                JOptionPane.showMessageDialog(null, "Commande Supprimer avec succèes"); 
            
           } 
        catch (Exception e){
                 System.out.println(e.getMessage());
        } finally {
                Databasemanager.fermerConnection();
        }
    } else{
    JOptionPane.showMessageDialog(null, "Commande non supprimer");
          }
        
    } 
}
