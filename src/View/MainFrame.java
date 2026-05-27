/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import Model.GachaSystem;
import Model.Item;
import Model.Player;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.List;

public class MainFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    // Memanggil objek Model
    private GachaSystem gachaSystem;
    private Player player;

//    private JLabel lblPity;
//    private JPanel panelTengah;
//    private JTextArea txtInventory;
    private Clip audioAktif;

    public MainFrame() {
        initComponents();
        gachaSystem = new GachaSystem();
        player = new Player();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelKanan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnPull1 = new javax.swing.JButton();
        pull10 = new javax.swing.JButton();
        jLihatPool = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblDisplayGambar = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GACHA ANOMALI");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 576));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(829, 70));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pity counter : 0 / 90");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 733;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel6, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        panelKanan.setBackground(new java.awt.Color(230, 230, 230));
        panelKanan.setPreferredSize(new java.awt.Dimension(200, 291));
        panelKanan.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("History Gacha");
        jLabel1.setPreferredSize(new java.awt.Dimension(82, 30));
        panelKanan.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        p.setEditable(false);
        p.setColumns(20);
        p.setRows(5);
        jScrollPane1.setViewportView(p);

        panelKanan.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelKanan, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(829, 50));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        btnPull1.setText("gacha 1x");
        btnPull1.addActionListener(this::btnPull1ActionPerformed);
        jPanel3.add(btnPull1);

        pull10.setText("gacha 10x");
        pull10.addActionListener(this::pull10ActionPerformed);
        jPanel3.add(pull10);

        jLihatPool.setText("lihat pool");
        jLihatPool.addActionListener(this::jLihatPoolActionPerformed);
        jPanel3.add(jLihatPool);

        jButton2.setText("reset");
        jPanel3.add(jButton2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel2.add(lblDisplayGambar, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPull1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPull1ActionPerformed
        Item hasilGacha = gachaSystem.pull();
        ImageIcon iconGacha = null;

        player.addItem(hasilGacha);

        int currentPity = gachaSystem.getPity();
        jLabel6.setText("Pity counter : " + currentPity + " / 90");

//        lblInf.setText("Kamu mendapakan : " + hasilGacha.toString());
        putarSuara(hasilGacha.getSoundPath());

        try {
            lblDisplayGambar.setIcon(new ImageIcon(getClass().getResource(hasilGacha.getImagePath())));
            iconGacha = new ImageIcon(getClass().getResource(hasilGacha.getImagePath()));

        } catch (Exception e) {
            e.getMessage();
        }

//        p.setText("");
        int nomor = 1;
        for (Item i : player.getInventory()) {
            p.append(nomor + ". " + i.toString() + "\n");
            nomor++;
        }

        tampilkanJOptionPane(hasilGacha, iconGacha);

    }//GEN-LAST:event_btnPull1ActionPerformed

    private void jLihatPoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLihatPoolActionPerformed
        new PoolDialog(this, true, gachaSystem).setVisible(true);
    }//GEN-LAST:event_jLihatPoolActionPerformed

    private void pull10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pull10ActionPerformed
        List<Item> hasil = gachaSystem.pullTenTimes();

        // 2. Masukkan semua item baru tersebut ke dalam inventori player (di latar belakang)
        for (Item item : hasil) {
            player.addItem(item);
        }

        int currentPity = gachaSystem.getPity();
        jLabel6.setText("Pity counter : " + currentPity + " / 90");

//        lblInf.setText("Membuka 10 berkas anomali secara berurutan...");
        GachaAnimasiDialog animasiDialog = new GachaAnimasiDialog(this, true, hasil);

        animasiDialog.setVisible(true);

        p.setText("");

        // Perbarui isi kolom teks list Koleksi Anomali (JTextArea p) di sebelah kanan
        int nomor = 1;
        for (Item i : player.getInventory()) {
            p.append(nomor + ". " + i.toString() + "\n");
            nomor++;
        }

//        lblInf.setText("Gacha 10x selesai. Koleksi anomali telah diperbarui!");
    }//GEN-LAST:event_pull10ActionPerformed

    private void putarSuara(String pathSuara) {
        try {
            if (audioAktif != null && audioAktif.isRunning()) {
                audioAktif.stop();
                audioAktif.close();
            }
            URL urlSuara = getClass().getResource(pathSuara);

            if (urlSuara == null) {
                System.out.println("Error: File suara tidak ditemukan di path: " + pathSuara);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(urlSuara);

            audioAktif = AudioSystem.getClip();
            audioAktif.open(audioStream);

            audioAktif.setFramePosition(0);
            audioAktif.start();

        } catch (Exception e) {
            System.out.println("Gagal memutar suara: " + e.getMessage());
        }
    }

    private void tampilkanJOptionPane(Item hasilGacha, Icon iconGacha) {
        JPanel panelPopUp = new JPanel();
        panelPopUp.setLayout(new BoxLayout(panelPopUp, BoxLayout.Y_AXIS));

        // =====================================================================
        // MODIFIKASI: Mengunci ukuran panel agar SAMA PERSIS dengan JDialog konstan
        // Silakan sesuaikan angka (300, 450) di bawah dengan ukuran setSize() JDialog-mu
        panelPopUp.setPreferredSize(new Dimension(380, 380));

        // Memberikan padding/jarak dalam 20px di setiap sisi agar layout tidak mepet ke tepi
        panelPopUp.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // =====================================================================

        // Logika pewarnaan background berdasarkan Rarity
        if (hasilGacha.getRarity() == 5) {
            panelPopUp.setBackground(new Color(255, 215, 0)); // Gold / Kuning Bintang 5
        } else if (hasilGacha.getRarity() == 4) {
            panelPopUp.setBackground(new Color(186, 85, 211)); // Medium Orchid / Ungu Bintang 4
        } else {
            panelPopUp.setBackground(new Color(240, 240, 240)); // Abu-abu Terang / Putih Bintang 3
        }

        // Pengaturan teks nama anomali
        JLabel lblText = new JLabel("Kamu mendapatkan anomali: " + hasilGacha.toString());
        lblText.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        // Pengaturan gambar anomali
        JLabel lblGambar = new JLabel(iconGacha);
        lblGambar.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        // Menyusun komponen ke dalam panelPopUp secara vertikal
        panelPopUp.add(lblGambar);
        panelPopUp.add(Box.createRigidArea(new Dimension(0, 10))); // Jarak antar elemen
        panelPopUp.add(lblText);

        // Memunculkan JOptionPane dengan panel kustom yang sudah dikunci ukurannya
        JOptionPane.showMessageDialog(
                this,
                panelPopUp,
                "Hasil Gacha 1x",
                JOptionPane.PLAIN_MESSAGE,
                null // Di-null karena gambarnya sudah menyatu di dalam panelPopUp
        );

        soundOff();
    }

    private void soundOff() {
        try {
            if (audioAktif != null) {
                if (audioAktif.isRunning()) {
                    audioAktif.stop();
                }
                audioAktif.close();
                audioAktif = null;
            }
        } catch (Exception e) {
            System.out.println("Gagal mematikan suara: " + e.getMessage());
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPull1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jLihatPool;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisplayGambar;
    private javax.swing.JTextArea p;
    private javax.swing.JPanel panelKanan;
    private javax.swing.JButton pull10;
    // End of variables declaration//GEN-END:variables
}
