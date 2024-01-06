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
import Modèle.Clients;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import hotel.Menu;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ControlleClients {
    private static String AJOUT="INSERT INTO clients(nom_client,prenom_client,Telephone,cartedeFidelite,pays) VALUES(?,?,?,?,?)";
    private static String MODIFICATION="UPDATE clients SET nom_client=?, prenom_client=?, Telephone=?, cartedeFidelite=?, pays=? WHERE id_client=?;";
    private static String SUPRESSION="DELETE FROM clients  WHERE id_client=?;";
    private static String SELECTION="SELECT id_client from clients WHERE nom_client=? AND prenom_client=? AND Telephone=? AND cartedeFidelite=? AND pays=?;";
    PreparedStatement ABI;
    ResultSet ra;
    public ControlleClients(){
    }
public boolean ajouterclient(Clients a) {
    boolean moufid = true;
    try {
        ABI = Databasemanager.ouvrirconnection().prepareStatement(AJOUT);
        ABI.setString(1, a.getNom());
        ABI.setString(2, a.getPrenom());
        ABI.setInt(3, a.getTelephone());
        ABI.setString(4, a.getCarteFidelite());
        ABI.setString(5, a.getPays());

        moufid = ABI.executeUpdate() > 0;

        Databasemanager.fermerConnection();
    } catch (SQLException e) {
        System.out.println(e);
    }

    return moufid;
}


public void Modifierclient(Clients b,String id) {
    int ABA = 0;
    //int id = getClientID(b);

    try {
        // Utilisez la variable correcte ici (ABI au lieu de ABA)
        ABI = Databasemanager.ouvrirconnection().prepareStatement(MODIFICATION);
        ABI.setString(1, b.getNom());
        ABI.setString(2, b.getPrenom());
        ABI.setInt(3, b.getTelephone());
        ABI.setString(4, b.getCarteFidelite());
        ABI.setString(5, b.getPays());
        ABI.setString(6, id);
        ABA = ABI.executeUpdate();  
        if(ABA>0){
            JOptionPane.showMessageDialog(null, "Client modifier avec succès");
        }else{
             JOptionPane.showMessageDialog(null, "Erreur lors de la modification du client");
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


public boolean supprimerClient(Clients c) {
    int AFI = 0;
    int id=getClientID(c);
    try {
        ABI = Databasemanager.ouvrirconnection().prepareStatement(SUPRESSION);
        ABI.setInt(1,id );
         AFI= ABI.executeUpdate();
         //String reprise="ALTER TABLE client AUTO_INCREMENT= 0;";
         
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Databasemanager.fermerConnection();
    }
    if(AFI!=0){
        return true;
    }
    return false;
}


public int getClientID(Clients y){
    int idclient=0;
     try {
        ABI = Databasemanager.ouvrirconnection().prepareStatement(SELECTION);
        ABI.setString(1, y.getNom());
        ABI.setString(2, y.getPrenom());
        ABI.setInt(3, y.getTelephone());
        ABI.setString(4, y.getCarteFidelite());
        ABI.setString(5, y.getPays());
        ResultSet result=ABI.executeQuery();
        if (result.next()) {
		idclient=result.getInt(1);
         } 
	   result.close();
        Databasemanager.fermerConnection();
    } catch (SQLException e){
        System.out.println(e);
    }
     return idclient;
}


}

