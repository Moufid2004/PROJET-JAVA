/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modèle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class calculjours{
    public static long differenceEnJours(LocalDate date_Sortie, LocalDate date_ARRIVE) {
        return ChronoUnit.DAYS.between(date_ARRIVE, date_Sortie);
    }
}

