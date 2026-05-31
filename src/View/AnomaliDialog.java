/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.Item;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mw300
 */
public class AnomaliDialog extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AnomaliDialog.class.getName());

    /**
     * Creates new form AnomaliDialog
     */
    public AnomaliDialog(java.awt.Frame parent, boolean modal, List<Item> allItems) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        mainPanel.setBackground(new Color(0, 0, 0, 180));

        tampilkanAnomali(allItems);
    }

    public void tampilkanAnomali(List<Item> items) {
        for (Item item : items) {
            JPanel targetPanel = null;

            switch (item.getRarity()) {
                case 5:
                    targetPanel = panelItem5;
                    break;
                case 4:
                    targetPanel = panelItem4;
                    break;
                case 3:
                    targetPanel = panelItem3;
                    break;
            }

            if (targetPanel == null) {
                continue;
            }

            // 1. Inisialisasi CharacterDisplayPanel menggunakan path gambar dari objek item
            CharacterDisplayPanel panelGambarTampil = new CharacterDisplayPanel(item.getImagePath());

            // 2. Tentukan ukuran dimensi komponen panel gambar agar seragam (Tinggi: 250)
            // Nilai lebar disesuaikan secara proporsional atau menggunakan batas default kartu (misal: 180)
            panelGambarTampil.setPreferredSize(new java.awt.Dimension(180, 250));

            // 3. Masukkan komponen panel gambar yang tajam langsung ke dalam panel target
            targetPanel.add(panelGambarTampil);

            // 4. Segarkan tata letak panel target setelah komponen baru ditambahkan
            targetPanel.revalidate();
            targetPanel.repaint();
        }

        // Segarkan seluruh kontainer utama halaman untuk memastikan semua elemen rendering dengan sempurna
        panel5star.revalidate();
        panel4star.revalidate();
        panel3star.revalidate();

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        emptyPanel = new javax.swing.JPanel();
        closePanel = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        tittlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        panel5star = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelItem5 = new javax.swing.JPanel();
        panel4star = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelItem4 = new javax.swing.JPanel();
        panel3star = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelItem3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 576));

        containerPanel.setOpaque(false);
        containerPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(0, 0, 0));
        topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        topPanel.setPreferredSize(new java.awt.Dimension(400, 40));
        topPanel.setLayout(new java.awt.BorderLayout());

        emptyPanel.setOpaque(false);
        emptyPanel.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        topPanel.add(emptyPanel, java.awt.BorderLayout.WEST);

        closePanel.setBackground(new java.awt.Color(51, 51, 51));
        closePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        closePanel.setOpaque(false);
        closePanel.setPreferredSize(new java.awt.Dimension(40, 0));
        closePanel.setLayout(new java.awt.GridBagLayout());

        btnClose.setBackground(new java.awt.Color(170, 11, 11));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/close.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.setMaximumSize(new java.awt.Dimension(40, 40));
        btnClose.setMinimumSize(new java.awt.Dimension(30, 30));
        btnClose.setPreferredSize(new java.awt.Dimension(30, 30));
        btnClose.addActionListener(this::btnCloseActionPerformed);
        closePanel.add(btnClose, new java.awt.GridBagConstraints());

        topPanel.add(closePanel, java.awt.BorderLayout.LINE_END);

        tittlePanel.setBackground(new java.awt.Color(0, 0, 0));
        tittlePanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("List Anomalies");
        tittlePanel.add(jLabel1, new java.awt.GridBagConstraints());

        topPanel.add(tittlePanel, java.awt.BorderLayout.CENTER);

        containerPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setBackground(new java.awt.Color(0, 0, 0));
        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 20));
        bottomPanel.setLayout(new java.awt.BorderLayout());
        containerPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setOpaque(false);

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        panel5star.setOpaque(false);
        panel5star.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(982, 30));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("★★★★★ Rarity");
        jPanel2.add(jLabel2, new java.awt.GridBagConstraints());

        panel5star.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        panelItem5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        panelItem5.setOpaque(false);
        panelItem5.setLayout(new java.awt.GridLayout(0, 5, 0, 20));
        panel5star.add(panelItem5, java.awt.BorderLayout.CENTER);

        mainPanel.add(panel5star);

        panel4star.setOpaque(false);
        panel4star.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(982, 30));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("★★★★ Rarity");
        jPanel4.add(jLabel3, new java.awt.GridBagConstraints());

        panel4star.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        panelItem4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        panelItem4.setOpaque(false);
        panelItem4.setLayout(new java.awt.GridLayout(0, 5, 0, 20));
        panel4star.add(panelItem4, java.awt.BorderLayout.CENTER);

        mainPanel.add(panel4star);

        panel3star.setOpaque(false);
        panel3star.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(204, 102, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(982, 30));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("★★★ Rarity");
        jPanel6.add(jLabel4, new java.awt.GridBagConstraints());

        panel3star.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        panelItem3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        panelItem3.setOpaque(false);
        panelItem3.setLayout(new java.awt.GridLayout(0, 5, 0, 20));
        panel3star.add(panelItem3, java.awt.BorderLayout.CENTER);

        mainPanel.add(panel3star);

        jScrollPane1.setViewportView(mainPanel);

        containerPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(containerPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel closePanel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panel3star;
    private javax.swing.JPanel panel4star;
    private javax.swing.JPanel panel5star;
    private javax.swing.JPanel panelItem3;
    private javax.swing.JPanel panelItem4;
    private javax.swing.JPanel panelItem5;
    private javax.swing.JPanel tittlePanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
