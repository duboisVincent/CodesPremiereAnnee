/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */

package vincentjavagestionstocks;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author sio1
 */
public class pMenu extends java.awt.Dialog {

    /**
     * Creates new form pMenu
     */
    public pMenu(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        DefaultListModel ListModel = new DefaultListModel();
        for(Produit unProduit:Passerelle.donnerToutLesProduits()){
            ListModel.addElement(unProduit.toString());
        }
        ListeProduit.setModel(ListModel);
        
        // EVENT EN CLIC SOURIS
    }
    private InteractionProduit viewInteraction;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    pMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Quitter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListeProduit = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        Quitter.setText("Quitter");
        Quitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitterMouseClicked(evt);
            }
        });
        add(Quitter, java.awt.BorderLayout.SOUTH);

        ListeProduit.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListeProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeProduitMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListeProduit);

        add(jScrollPane2, java.awt.BorderLayout.NORTH);

        jButton1.setText("Ajouter un produit");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void QuitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitterMouseClicked
        // Bouton quitter, action en clic
        this.dispose();
    }//GEN-LAST:event_QuitterMouseClicked

    private void ListeProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeProduitMouseClicked
        // Liste produit, action en clic ( tentative UNE )
        viewInteraction = new InteractionProduit(null,true);
        viewInteraction.setVisible(true);
    }//GEN-LAST:event_ListeProduitMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // Bouton Ajouter un produit, action en clic
        viewInteraction = new InteractionProduit(null,true);
        viewInteraction.setVisible(true);        
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pMenu dialog = null;
                try {
                    dialog = new pMenu(new java.awt.Frame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(pMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListeProduit;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
