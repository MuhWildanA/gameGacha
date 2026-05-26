package View;

import Model.Item;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GachaAnimasiDialog extends javax.swing.JDialog {

    private List<Item> listHasilGacha; // Tempat menampung 10 item dari MainFrame
    private int indexSekarang = 0;     // Penanda urutan item yang tampil (0-9)
    private Clip audioAktif;           // Pemutar suara anomali
    private java.awt.Frame indukFrame; // Mencatat MainFrame pembuka

    // CONSTRUCTOR
    public GachaAnimasiDialog(java.awt.Frame parent, boolean modal, List<Item> hasilGacha) {
        super(parent, modal);
        
        // PENTING: Pindahkan ini ke urutan paling atas!
        initComponents();
        // 1. Paksa jPanelKonten ganti layout ke BoxLayout vertikal (Y_AXIS)
        jPanelKonten.setLayout(new javax.swing.BoxLayout(jPanelKonten, javax.swing.BoxLayout.Y_AXIS));
        jPanelKonten.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 2. Bersihkan layout lama, lalu susun ulang secara vertikal
        jPanelKonten.removeAll();

        // Alingment tengah untuk semua komponen
        lblDisplayGambar.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNamaItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Susun ulang persis seperti struktur JOptionPane gacha 1x
        jPanelKonten.add(lblDisplayGambar);
        jPanelKonten.add(javax.swing.Box.createRigidArea(new Dimension(0, 15))); // Jarak gambar ke teks
        jPanelKonten.add(lblNamaItem);
        jPanelKonten.add(javax.swing.Box.createRigidArea(new Dimension(0, 20))); // Jarak teks ke tombol
        jPanelKonten.add(btnNext);

        // Atur ukuran JDialog agar pas dan proporsional
        this.setSize(400, 450);
        this.setLocationRelativeTo(parent);

        // =======================================================
        this.listHasilGacha = hasilGacha;
        this.indukFrame = parent;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                matikanSuaraSekarang();
            }
        });

        tampilkanKarakterBerikutnya();
    }

    private void tampilkanKarakterBerikutnya() {
        if (indexSekarang < listHasilGacha.size()) {
            Item itemAktif = listHasilGacha.get(indexSekarang);

            // Perbaikan: Menampilkan nama item asli + rating bintangnya di teks atas!
//            lblNamaItem.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
            lblNamaItem.setText("Kamu mendapakan : " + itemAktif.toString());
            this.setTitle("Hasil gacha ke" + (indexSekarang+1));

            // Set gambar ke label yang ada di tengah
            try {
                java.net.URL imgURL = getClass().getResource(itemAktif.getImagePath());
                if (imgURL != null) {
                    lblDisplayGambar.setText(""); // Hapus sisa teks eror jika ada
                    lblDisplayGambar.setIcon(new ImageIcon(imgURL));
                } else {
                    lblDisplayGambar.setIcon(null);
                    lblDisplayGambar.setText("<html><center>[Gambar " + itemAktif.getName() + "<br>Tidak Ditemukan]</center></html>");
                }
            } catch (Exception ex) {
                lblDisplayGambar.setIcon(null);
                lblDisplayGambar.setText("[Gambar Gagal Dimuat]");
            }

            // Putar suara anomali
            putarSuaraAnomali(itemAktif.getSoundPath());

            // Naikkan index untuk klik berikutnya
            indexSekarang++;

            // Jika ini sudah item ke-10, ubah tulisan tombol menjadi "Selesai"
            if (indexSekarang == listHasilGacha.size()) {
                btnNext.setText("Selesai & Masukkan Koleksi");
            }

        } else {
            // JIKA ITEM SUDAH HABIS DAN DIKLIK LAGI:
            matikanSuaraSekarang();
            dispose(); // Tutup dialog

            // Munculkan pemberitahuan akhir
            javax.swing.JOptionPane.showMessageDialog(indukFrame, "Gacha 10x Selesai! Semua anomali telah masuk ke koleksimu.");
        }
    }

    private void putarSuaraAnomali(String pathSuara) {
        try {
            matikanSuaraSekarang(); // Matikan suara item sebelumnya dulu

            URL urlSuara = getClass().getResource(pathSuara);
            if (urlSuara != null) {
                AudioInputStream stream = AudioSystem.getAudioInputStream(urlSuara);
                audioAktif = AudioSystem.getClip();
                audioAktif.open(stream);
                audioAktif.start();
            }
        } catch (Exception e) {
            System.out.println("Gagal memutar audio animasi: " + e.getMessage());
        }
    }

    private void matikanSuaraSekarang() {
        if (audioAktif != null) {
            if (audioAktif.isRunning()) {
                audioAktif.stop();
            }
            audioAktif.close();
            audioAktif = null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelKonten = new javax.swing.JPanel();
        lblDisplayGambar = new javax.swing.JLabel();
        lblNamaItem = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelKonten.setLayout(new javax.swing.BoxLayout(jPanelKonten, javax.swing.BoxLayout.Y_AXIS));

        lblDisplayGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/1.png"))); // NOI18N
        lblDisplayGambar.setAlignmentX(0.5F);
        jPanelKonten.add(lblDisplayGambar);

        lblNamaItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNamaItem.setText("jLabel1");
        lblNamaItem.setAlignmentX(0.5F);
        jPanelKonten.add(lblNamaItem);

        btnNext.setText("Next");
        btnNext.setAlignmentX(0.5F);
        btnNext.addActionListener(this::btnNextActionPerformed);
        jPanelKonten.add(btnNext);

        getContentPane().add(jPanelKonten, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        tampilkanKarakterBerikutnya();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JPanel jPanelKonten;
    private javax.swing.JLabel lblDisplayGambar;
    private javax.swing.JLabel lblNamaItem;
    // End of variables declaration//GEN-END:variables
}
