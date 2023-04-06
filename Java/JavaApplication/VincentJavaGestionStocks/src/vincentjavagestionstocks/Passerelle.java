/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vincentjavagestionstocks;

/**
 *
 * @author sio1
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Passerelle {
    
    public static Connection seConnecter(){
        String url= "jdbc:postgresql://192.168.1.245:5432/slam2024hopitalpharmacie_dubois";
        String user = "dubois";
        String passwd = "Chienchatcheval.";
        
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective");
        }
        catch (SQLException ex){
        // do something appropriate with the exception, *at least*:
        //ex.printStackTrace();
            System.out.println("Erreur");
            ex.printStackTrace();
        }
        return conn;
    
    }
    public static void deConnection(Connection pConn){
        Connection conn = pConn;
        try{
            conn.close();
            System.out.println("Vous êtez déconnecté.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Produit> donnerToutLesProduits() throws SQLException{
        Connection conn = (Connection) seConnecter();
        Statement state;
        ResultSet resultat;
        ArrayList<Produit> LesProduits = new ArrayList();
        try{
            state=conn.createStatement();
        }
        catch(SQLException ex){
            state=null;
            System.out.println("Erreur au niveau du creation de statement");
        }
        try{
            resultat=state.executeQuery("Select * from \"produit\" order by idproduit");
        }
        catch(SQLException ex){
            resultat = null;
            System.out.println("Erreur au niveau de la commande select ");
        }
        
        try{
            while(resultat.next()){
                int id = resultat.getInt(1);
                String libelle = resultat.getString(2);
                double prix = resultat.getInt(3);
                int quantite = resultat.getInt(4);
                String localisation = resultat.getString(5);
                Produit p1 = new Produit(id, libelle, prix, quantite, localisation );
                LesProduits.add(p1);
            }
        }
        catch(SQLException ex){
            LesProduits=null;
        }
        conn.close();
        return LesProduits;
    }
    
    public static Produit donnerUnProduit(int unId) throws SQLException{
        Connection conn = (Connection) seConnecter();
        Statement state;
        Produit unProduit = null;
        ResultSet resultat;
        try{      
            state=conn.createStatement();
            PreparedStatement prepare = conn.prepareStatement("SELECT * from \"produit\" WHERE idproduit = ?");
            //Association de les paramètres à la fonction
            prepare.setInt(1,unId);
            String sql;
            sql = prepare.toString();
            resultat = state.executeQuery(sql);
            while(resultat.next()){
                int id = resultat.getInt(1);
                String libelle = resultat.getString(2);
                double prix = resultat.getDouble(3);
                int qtt = resultat.getInt(4);
                String local = resultat.getString(5);
                Produit leProduit = new Produit(id,libelle,prix,qtt,local);
                return leProduit;
            }
        }
        catch(SQLException ex){ 
            // ex.printStackTrace();
            System.out.println("Erreur dans la reqûete SELECT");
        }
        //set les valeurs une a une dans unProduit
        return unProduit;  
    }
    
    public static boolean ajouterProduit(Produit unProduit) throws SQLException{
        Connection conn = (Connection) seConnecter();
        Statement state;
        ResultSet resultat;
        int idP = unProduit.getId();
        String pLibelle = unProduit.getLibelle();
        double pPrix = unProduit.getPrix();
        int pQtt = unProduit.getQuantite();
        String pLocal = unProduit.getLocal();

        try{
            state=conn.createStatement();
            PreparedStatement prepare = conn.prepareStatement("INSERT INTO produit (idproduit,libelle,prix,quantite,localisation)"
                    + " Values(?,?,?,?,?)");
            prepare.setInt(1,idP);
            prepare.setString(2,pLibelle);
            prepare.setDouble(3,pPrix);
            prepare.setInt(4,pQtt);
            prepare.setString(5,pLocal);
            String sql;
            sql = prepare.toString();
            state.executeUpdate(sql);
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erreur dans la commande INSERT");
            // ex.printStackTrace();
        }
        return true;  
    }
    
    public static boolean modifierProduit(Produit unProduit) throws SQLException{
        Connection conn = (Connection) seConnecter();
        Statement state;
        ResultSet resultat;
        int idP = unProduit.getId();
        String pLibelle = unProduit.getLibelle();
        double pPrix = unProduit.getPrix();
        int pQtt = unProduit.getQuantite();
        String pLocal = unProduit.getLocal();   
        try{         
            state=conn.createStatement();
            PreparedStatement prepare = conn.prepareStatement("UPDATE \"produit\" "
                    + "SET idproduit = ?,"
                    + " libelle = ?,"
                    + " prix = ?,"
                    + " quantite = ?,"
                    + " localisation = ?"
                    + " WHERE idproduit = ?");
            prepare.setInt(1,idP);
            prepare.setString(2,pLibelle);
            prepare.setDouble(3,pPrix);
            prepare.setInt(4,pQtt);
            prepare.setString(5,pLocal);
            prepare.setInt(6,idP);
            String sql;
            sql = prepare.toString();
            state.executeUpdate(sql);            
        }
        catch(SQLException ex){
            System.out.println("Erreur dans la commande UPDATE" + ex);
        }
        return true;   
    }
    
    public static boolean supprimerProduit(Produit unProduit) throws SQLException{
        Connection conn = (Connection) seConnecter();
        Statement state;
        ResultSet resultat;
        try{
            int idP = unProduit.getId();           
            state=conn.createStatement();
            PreparedStatement prepare = conn.prepareStatement("DELETE FROM \"produit\" WHERE idproduit = ?");      
            prepare.setInt(1,idP);
            String sql;
            sql = prepare.toString();
            state.executeUpdate(sql);             
        }
        catch(SQLException ex){
            System.out.println("Erreur dans la commande DELETE" +ex );
            // ex.printStackTrace();
        }
        return true;   
    }
}


