/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

import com.toedter.calendar.DateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Reservation {
    private int id_Reservation;
    private String date_reservation;
    private String date_ARRIVE;
    private String date_Sortie;
    private int id_client;
    private int num_Chambre;
    private String TOTAL;
    private Chambres chambre;

    public Reservation(int id_Reservation, String date_reservation, String date_ARRIVE, String date_Sortie, int id_client, int num_Chambre, String TOTAL) {
        this.id_Reservation = id_Reservation;
        this.date_reservation = date_reservation;
        this.date_ARRIVE = date_ARRIVE;
        this.date_Sortie = date_Sortie;
        this.id_client = id_client;
        this.num_Chambre = num_Chambre;
        this.TOTAL = TOTAL;
    }

    public int getId_Reservation() {
        return id_Reservation;
    }

    public void setId_Reservation(int id_Reservation) {
        this.id_Reservation = id_Reservation;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public String getDate_ARRIVE() {
        return date_ARRIVE;
    }

    public void setDate_ARRIVE(String date_ARRIVE) {
        this.date_ARRIVE = date_ARRIVE;
    }

    public String getDate_Sortie() {
        return date_Sortie;
    }

    public void setDate_Sortie(String date_Sortie) {
        this.date_Sortie = date_Sortie;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getNum_Chambre() {
        return num_Chambre;
    }

    public void setNum_Chambre(int num_Chambre) {
        this.num_Chambre = num_Chambre;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }

    public Chambres getChambre() {
        return chambre;
    }

    public void setChambre(Chambres chambre) {
        this.chambre = chambre;
    }
    public double calculerPrixTotal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateArrivee = LocalDate.parse(date_ARRIVE, formatter);
        LocalDate dateSortie = LocalDate.parse(date_Sortie, formatter);

        long differenceEnJours = ChronoUnit.DAYS.between(dateArrivee, dateSortie);
        double tarifParNuit = chambre.getPrix();

        return differenceEnJours * tarifParNuit;
    }
      
    
}
