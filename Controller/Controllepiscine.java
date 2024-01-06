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
import Modèle.piscine;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Controllepiscine {
    private static String AJOUT="INSERT INTO piscine(idclient,optionpiscine,nbreheure,prixtotal) VALUES(?,?,?,?)";
    private static String SUPRESSION="DELETE FROM restaurant  WHERE idservice=?;";
    PreparedStatement ABI;

    public Controllepiscine() {
    }
    
    public void ajouterservice(piscine a){
           int ABA=0;
          try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
            ABI.setInt(1,a.getIdclient());
            ABI.setString(2, a.getOption());
            ABI.setInt(3, a.getNbheure());
            ABI.setInt(4, a.getPrix());
            ABA=ABI.executeUpdate();
             if(ABA>0){
            JOptionPane.showMessageDialog(null, "service ajouter avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du service");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Databasemanager.fermerConnection();
        }
    }
    public void supprimerservice(piscine b,String num){
         int ABA=0;
        int p=JOptionPane.showConfirmDialog(null, "êtes vous sûre de vouloir supprimer ce service?","Suprimer",JOptionPane.YES_NO_OPTION);
        if(p==0){
        try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(SUPRESSION);
            ABI.setString(1, num);
            ABA=ABI.executeUpdate();
                JOptionPane.showMessageDialog(null, "service Supprimer avec succèes"); 
            
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
