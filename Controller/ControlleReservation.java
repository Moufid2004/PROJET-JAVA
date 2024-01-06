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
import Modèle.Reservation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Statement;
public class ControlleReservation {
    private static String AJOUT="INSERT INTO reservations(Date_reservation,Date_ARRIVE,Date_Sortie,id_client,num_Chambre,TOTAL) VALUES(?,?,?,?,?,?)";
    private static String MODIFICATION="UPDATE reservations SET Date_reservation=?,Date_ARRIVE=?,Date_Sortie=?,TOTAL=? WHERE id_reservation=?;";
    private static String SUPRESSION="DELETE FROM reservations  WHERE id_reservation=?;";
    PreparedStatement ABI;

    public ControlleReservation() {
    }
    public void ajouterReservation(Reservation a){
        int ABA=0;
          try {
             ABI=Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
            ABI.setString(1, a.getDate_reservation());
            ABI.setString(2, a.getDate_ARRIVE());
            ABI.setString(3, a.getDate_Sortie());
            ABI.setInt(4,a.getId_client());
            ABI.setInt(5, a.getNum_Chambre());
            ABI.setString(6, a.getTOTAL());
            ABA=ABI.executeUpdate();
             if(ABA>0){
            JOptionPane.showMessageDialog(null, "Reservation ajouter avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de l'opération de Réservation");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Databasemanager.fermerConnection();
        }
    }
    public void modifierReservation(Reservation b,String id){
        int ABA=0;
         try {
        // Utilisez la variable correcte ici (ABI au lieu de ABA)
        ABI = Databasemanager.ouvrirconnection().prepareStatement(MODIFICATION);
          ABI=Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
            ABI.setString(1, b.getDate_reservation());
            ABI.setString(2, b.getDate_ARRIVE());
            ABI.setString(3, b.getDate_Sortie());
            ABI.setInt(4,b.getId_client());
            ABI.setInt(5, b.getNum_Chambre());
            ABI.setString(6, b.getTOTAL());
        ABA = ABI.executeUpdate();  
        if(ABA>0){
            JOptionPane.showMessageDialog(null, "Reservation modifier avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de la modification de la Reservation");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } 
    finally {
        Databasemanager.fermerConnection();
    }   
   }
    public void supprimerclient(Reservation c,String num){
         int ABA=0;
        int p=JOptionPane.showConfirmDialog(null, "êtes vous sûre de vouloir supprimer cette Reservation?","Suprimer",JOptionPane.YES_NO_OPTION);
        if(p==0){
        try {
            ABI=Databasemanager.ouvrirconnection().prepareStatement(SUPRESSION);
            ABI.setString(1, num);
            ABA=ABI.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reservation Supprimer avec succèes"); 
            
           } 
        catch (Exception e){
                 System.out.println(e.getMessage());
        } finally {
                Databasemanager.fermerConnection();
        }
    } else{
    JOptionPane.showMessageDialog(null, "Reservation non supprimer");
          }
        
    } 
    
}
