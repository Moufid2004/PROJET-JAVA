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
import Modèle.Chambres;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ControlleChambres {
      private static String AJOUT="INSERT INTO chambre(id_client,type_Chambre,caracteristique_chambre,situation_chambre,prix_Chambre) VALUES(?,?,?,?,?)";
    private static String MODIFICATION="UPDATE chambre SET type_Chambre=?, caracteristique_chambre=?, situation_chambre=?, prix_Chambre=? WHERE num_chambre=?;";
    private static String SUPRESSION="DELETE FROM chambre  WHERE num_chambre=?;";
    PreparedStatement ABI;
    
    public ControlleChambres(){
        
    }
    public void ajouterchambre(Chambres a){
       int ABA=0;
        try {
             ABI=Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
            ABI.setInt(1,a.getId_client() );
            ABI.setString(2, a.getType());
            ABI.setString(3, a.getCaractéristique());
            ABI.setString(4, a.getSituation());
            ABI.setDouble(5, a.getPrix());
            ABA=ABI.executeUpdate();
             if(ABA>0){
            JOptionPane.showMessageDialog(null, "Chambre ajouter avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de la chambre");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Databasemanager.fermerConnection();
        }
    }
    public void ModifierChambre(Chambres b,String num) {
    int ABA = 0;
    //int id = getClientID(b);

    try {
        // Utilisez la variable correcte ici (ABI au lieu de ABA)
        ABI = Databasemanager.ouvrirconnection().prepareStatement(MODIFICATION);
        ABI.setString(1, b.getType());
        ABI.setString(2, b.getCaractéristique());
        ABI.setString(3, b.getSituation());
        ABI.setDouble(4, b.getPrix());
        ABI.setString(5, num);
        ABA = ABI.executeUpdate();  
        if(ABA>0){
            JOptionPane.showMessageDialog(null, "Chambre modifier avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de la modification de la chambre");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } 
    finally {
        Databasemanager.fermerConnection();
    }
     // Vérifiez le résultat de l'opération de mise à jour
    //return ABA != 0;
    }
    public void SupprimerChambre(Chambres c,String num){
        int ABA=0;
        int p=JOptionPane.showConfirmDialog(null, "êtes vous sûre de vouloir supprimer cette Chambre?","Suprimer",JOptionPane.YES_NO_OPTION);
        if(p==0){
        try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(SUPRESSION);
            ABI.setString(1, num);
            ABA=ABI.executeUpdate();
                JOptionPane.showMessageDialog(null, "Chambre Supprimer avec succèes"); 
            
           } 
        catch (Exception e){
                 System.out.println(e.getMessage());
        } finally {
                Databasemanager.fermerConnection();
        }
    } else{
    JOptionPane.showMessageDialog(null, "Chambre non supprimer");
          }
        
    } 
               
    
}
