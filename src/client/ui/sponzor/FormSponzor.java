package client.ui.sponzor;

import client.ui.clan.*;
import domen.Clan;
import domen.Tim;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author luka
 * @deprecated Koristi se nova, JPanel forma {@link PanelFormSponzor}
 */
@Deprecated
public class FormSponzor extends javax.swing.JFrame {

    /**
     * Creates new form FormClan
     */
    public FormSponzor() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            tblSponzor.setModel(new SponzorTableModel(kontroleri.KontrolerSponzor.getList()));
        } catch (SQLException ex) {
            Logger.getLogger(FormSponzor.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTableWidth();
        try {
            napuniTabelu();
        } catch (SQLException ex) {
            Logger.getLogger(FormSponzor.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnLoad = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnDetails = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSponzor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(1156, 40));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnLoad.setText("Učitaj");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel2.add(btnLoad);

        btnAdd.setText("Dodaj");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnUpdate.setText("Izmeni");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);

        btnSearch.setText("Traži");
        jPanel2.add(btnSearch);

        jTextField1.setPreferredSize(new java.awt.Dimension(420, 25));
        jPanel2.add(jTextField1);

        btnDetails.setText("PREGLED");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });
        jPanel2.add(btnDetails);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        tblSponzor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSponzor);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new CreateSponzor(null, true).setVisible(true);
        try {
            napuniTabelu();
        } catch (SQLException ex) {
            Logger.getLogger(FormSponzor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

//        int selectedRow = tblSponzor.getSelectedRow();
//        // Ako nije selektovan ni jedan red, gornja f-ja vraca vrednost -1
//        if (selectedRow < 0) {
//            JOptionPane.showMessageDialog(null, "Nije odabran ni jedan red!", "Sistem", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        System.out.println(selectedRow);
//        // Bitan je samo ID za izmenu.
//        new UpdateClan(this, true, new Clan(
//                (Long) tblSponzor.getValueAt(selectedRow, 0),
//                (String) tblSponzor.getValueAt(selectedRow, 1),
//                (String) tblSponzor.getValueAt(selectedRow, 2),
//                (String) tblSponzor.getValueAt(selectedRow, 3),
//                "NULL",
//                (String) tblSponzor.getValueAt(selectedRow, 4),
//                (String) tblSponzor.getValueAt(selectedRow, 5))).setVisible(true);
//
//        try {
//            napuniTabelu();
//        } catch (SQLException ex) {
//            Logger.getLogger(FormSponzor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblSponzor;
    // End of variables declaration//GEN-END:variables

    private void initTableWidth() { // Moze i ovako?!
        TableColumnModel columnModel = tblSponzor.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(0).setMaxWidth(250);

        columnModel.getColumn(2).setPreferredWidth(450);
        columnModel.getColumn(2).setMaxWidth(450);
    }

    private void napuniTabelu() throws SQLException {
        tblSponzor.setModel(new SponzorTableModel(kontroleri.KontrolerSponzor.getList()));
    }
}
