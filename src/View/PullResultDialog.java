/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.Item;
import Model.SoundPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;

/**
 *
 * @author mw300
 */
public class PullResultDialog extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PullResultDialog.class.getName());
    private List<Item> items;
    private int currentIndex = 0;
    private PullMode mode;

    public enum PullMode {
        SINGLE,
        MULTI
    }

    public PullResultDialog(Frame parent,
            boolean modal,
            List<Item> items,
            PullMode mode) {
        super(parent, modal);
        this.items = items;
        this.mode = mode;

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));

        initComponents();

        tittlePanel.setBackground(new Color(0,0,0, 180));

        tampilkanItem(items.get(0));

        if (mode == PullMode.SINGLE) {
            btnSkip.setVisible(false);
            btnNext.setText("OKE");
        }
    }

    private void tampilkanItem(Item item) {
        jPanelMain.removeAll();
        CharacterDisplayPanel charPanel = new CharacterDisplayPanel(item.getImagePath());
        charPanel.setOpaque(false);
        jPanelMain.add(charPanel);
        jPanelMain.revalidate();
        jPanelMain.repaint();
        SoundPlayer.play(item.getSoundPath());
        jPanelMain.setOpaque(false);
    }

    private void selesaiDialog(){
        SoundPlayer.stop();
        dispose();
        if(mode == PullMode.MULTI){
            PullSummaryDialog summary = new PullSummaryDialog((Frame) getParent(), true, items);
            summary.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transparantPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        tittlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSkip = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(342, 438));

        transparantPanel.setOpaque(false);
        transparantPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(232, 30));
        topPanel.setLayout(new java.awt.GridBagLayout());

        tittlePanel.setPreferredSize(new java.awt.Dimension(500, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Kamu Mendapatkan");
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 20));
        tittlePanel.add(jLabel1);

        topPanel.add(tittlePanel, new java.awt.GridBagConstraints());

        transparantPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(232, 40));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnSkip.setBackground(new java.awt.Color(240, 184, 61));
        btnSkip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSkip.setText("Skip");
        btnSkip.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 30, 5, 30));
        btnSkip.setBorderPainted(false);
        btnSkip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSkip.setFocusPainted(false);
        btnSkip.addActionListener(this::btnSkipActionPerformed);
        jPanel4.add(btnSkip, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel4);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnNext.setBackground(new java.awt.Color(240, 184, 61));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNext.setText("Next");
        btnNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 30, 5, 30));
        btnNext.setBorderPainted(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setFocusPainted(false);
        btnNext.addActionListener(this::btnNextActionPerformed);
        jPanel5.add(btnNext, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel5);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanelMain.setOpaque(false);
        jPanelMain.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanelMain, java.awt.BorderLayout.CENTER);

        transparantPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(transparantPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (mode == PullMode.SINGLE) {
            selesaiDialog();
            return;
        }

        currentIndex++;
        if (currentIndex >= items.size()) {
            selesaiDialog();
            return;
        }

        tampilkanItem(items.get(currentIndex));
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipActionPerformed
        selesaiDialog();
    }//GEN-LAST:event_btnSkipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSkip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel tittlePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel transparantPanel;
    // End of variables declaration//GEN-END:variables
}
