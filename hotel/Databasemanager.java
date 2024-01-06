/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vue;

//importation des classes de java responsable de la connexion à la base de données
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasemanager {
        private static java.sql.Connection connection = null;
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String databaseName = "gestionhotel";
	private static String username = "root";
	private static String password = "";
	private static String host = "localhost";
	private static String url = "jdbc:mysql://localhost:3306/gestionhotel";
	
    public static java.sql.Connection ouvrirconnection() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void fermerConnection(){
		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
