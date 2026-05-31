/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.*;
import java.awt.Color;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mw300
 */
public class PullSummaryDialog extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PullSummaryDialog.class.getName());

    /**
     * Creates new form pullSummaryDialog
     */
    public PullSummaryDialog(java.awt.Frame parent, boolean modal, List<Item> items) {
        super(parent, modal);
        initComponents();

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.getViewport().setOpaque(false);
        jPanel2.setBackground(new Color(0, 0, 0, 180));
        jPanel3.setBackground(new Color(0, 0, 0, 180));
        jPanel4.setBackground(new Color(0, 0, 0, 180));
        panelContainer.setBackground(new Color(0, 0, 0, 160));

        for (Item item : items) {
            // 1. Inisialisasi CharacterDisplayPanel menggunakan path gambar dari objek item
            CharacterDisplayPanel panelGambarTampil = new CharacterDisplayPanel(item.getImagePath());

            // 2. Tentukan ukuran dimensi komponen panel gambar (Tinggi: 250)
            // Lebar disesuaikan secara proporsional atau menggunakan batas default kartu (misal: 180)
            panelGambarTampil.setPreferredSize(new java.awt.Dimension(180, 250));

            // 3. Masukkan komponen panel gambar yang tajam langsung ke dalam panelItems
            panelItems.add(panelGambarTampil);
        }

// 4. Segarkan tata letak dan grafik panelItems setelah semua komponen baru dimasukkan
        panelItems.revalidate();
        panelItems.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelItems = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("kamu mendapatkan");
        setPreferredSize(new java.awt.Dimension(1024, 576));
        setResizable(false);

        panelContainer.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1022, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kamu mendapatkan");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(40, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setPreferredSize(new java.awt.Dimension(40, 5));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnClose.setBackground(new java.awt.Color(170, 11, 11));
        btnClose.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/close.png"))); // NOI18N
        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(this::btnCloseActionPerformed);
        jPanel4.add(btnClose, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4, java.awt.BorderLayout.EAST);

        panelContainer.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        panelItems.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelItems.setOpaque(false);
        panelItems.setLayout(new java.awt.GridLayout(0, 5));
        jScrollPane1.setViewportView(panelItems);

        panelContainer.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelContainer, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelItems;
    // End of variables declaration//GEN-END:variables
}
