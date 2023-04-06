/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vincentjavagestionstocks;

import static vincentjavagestionstocks.Passerelle.seConnecter;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static vincentjavagestionstocks.Passerelle.deConnection;
import static vincentjavagestionstocks.Passerelle.donnerToutLesProduits;
/**
 *
 * @author sio1
 */
public class VincentJavaGestionStocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection conn = (Connection) seConnecter();
        System.out.println(conn);
        try{
            conn.close();
            System.out.println("Vous êtez déconnecté.");
        }catch (SQLException e){
            e.printStackTrace();
        }
        /* donnerToutLesProduits */ 
        ArrayList<Produit> LesProds = donnerToutLesProduits();
        for(Produit unProd:LesProds){
            System.out.println(unProd.toString());
        }
        
        /*    
        
        Produit Pun = Passerelle.donnerUnProduit(5);
        System.out.println(Pun);

        Produit Pdeux = new Produit(8,"Jeux pour enfants", 10.99,23, "Air de jeux");
        Passerelle.ajouterProduit(Pdeux);
        
        Produit Ptrois = new Produit(6,"Alcool 70°",15.95,17,"Local 1 placard 1, etage 1");
        Passerelle.modifierProduit(Ptrois);  
        
        Produit Pquatre = Passerelle.donnerUnProduit(8);
        Passerelle.supprimerProduit(Pquatre);
        
        */

    }
    
}

