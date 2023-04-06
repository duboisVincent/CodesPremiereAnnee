/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vincentjavagestionstocks;

/**
 *
 * @author sio1
 */
public class Produit {
    
    private int id;
    private String libelle;
    private double prix;
    private int quantite;
    private String local;
    
    Produit(int pId,String pLibelle, double pPrix,int pQuantite, String pLocal){
        
        id = pId;
        libelle = pLibelle;
        prix = pPrix;
        quantite = pQuantite;
        local = pLocal;
    }
    
    // Acesseurs:
    public int getId(){
        return id;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public double getPrix(){
        return prix;
    }
    
    public int getQuantite(){
        return quantite;
    }
    
    public String getLocal(){
        return local;
    }
    
    public String toString(){
        String p = " Le produit d'id " + id + " , est un  " + libelle + " coûte " + prix + " à l'unité, il y en a " + quantite + " en stock, sa localisation : " + local;  
        return p;
    }
    
    public double getPrixNombre(int pNbr){
        double prixTT = pNbr * prix;
        return prixTT;
    }
    // Mutateurs:
    
    public void setId(int pId){
        id = pId;
    }
    
    public void setLibelle(String pLibelle){
        libelle = pLibelle;
    }
    
    public void setPrix(double pPrix){
        prix = pPrix;
    }
    
    public void setQuantite(int pQuantite){
        quantite = pQuantite;
    }
    
    public void setLocal(String pLocal){
        local = pLocal;
    }
}
