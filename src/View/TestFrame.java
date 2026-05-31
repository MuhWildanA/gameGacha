/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.GachaSystem;
import Model.Item;
import Model.Player;
import Model.SoundPlayer;
import View.PullResultDialog.PullMode;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mw300
 */
public class TestFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TestFrame.class.getName());
    private Player player;
    private GachaSystem gachaSystem;
    private BufferedImage[] banners;
    private int currentBanner = 0;
    private BannerPanel lblBanner;
    private javax.swing.Timer bannerTimer;

    public TestFrame() {
        initComponents();

        gachaSystem = new GachaSystem();
        player = new Player();

        // background
        BackgroundPanel customBg = new BackgroundPanel();
        customBg.setLayout(new java.awt.BorderLayout());

        setContentPane(customBg);
        customBg.add(mainPanel, java.awt.BorderLayout.CENTER);

        // banner
        lblBanner = new BannerPanel();

        java.awt.Dimension bannerSize = new java.awt.Dimension(700, 350);
        lblBanner.setPreferredSize(bannerSize);
        lblBanner.setMinimumSize(bannerSize);
        lblBanner.setMaximumSize(bannerSize);

        bannerPanel.setLayout(new java.awt.BorderLayout());

        bannerPanel.removeAll();

// 5. Masukkan lblBanner langsung ke tengah bannerPanel
        bannerPanel.add(lblBanner, java.awt.BorderLayout.CENTER);

        // transparan
        mainPanel.setOpaque(false);

        currencyPanel.setBackground(new Color(0, 0, 0, 120));
        menuAnomali.setBackground(new Color(0, 0, 0, 120));
        menuInventory.setBackground(new Color(0, 0, 0, 120));
        menuHistory.setBackground(new Color(0, 0, 0, 120));
        menuDetail.setBackground(new Color(0, 0, 0, 120));
        pityBg.setBackground(new Color(0, 0, 0, 190));

        // load image
        try {
            // Pastikan array diinisialisasi dulu
            banners = new BufferedImage[4];

            // Load gambar dengan pengaman biar gak langsung crash kalau salah satu ilang
            for (int i = 0; i < 4; i++) {
                java.net.URL imgUrl = getClass().getResource("/assets/images/" + (i + 1) + ".png");
                if (imgUrl != null) {
                    banners[i] = ImageIO.read(imgUrl);
                } else {
                    System.out.println("PENGAMAN: Gambar " + (i + 1) + ".png gak ketemu!");
                }
            }


        } catch (Exception e) {
            System.out.println("ERROR PAS LOAD GAMBAR BANNER:");
            e.printStackTrace();
        }

// Tampilkan banner pertama jika ada yang berhasil di-load
        if (banners != null && banners[0] != null) {
            setBanner(banners[0]);
            startBannerSlider();
        }

        lblCoinAmount.setText(String.valueOf(player.getTungCoin()));

        revalidate();
        repaint();
        SoundPlayer.playBGM("/assets/sounds/bgm.wav");
    }

    private void startBannerSlider() {

        if (bannerTimer != null && bannerTimer.isRunning()) {
            bannerTimer.stop();
        }

        bannerTimer = new javax.swing.Timer(3000, e -> {
            if (banners == null || banners.length == 0) {
                return;
            }

            // Loop index banner (0 -> 1 -> 2 -> 3 -> balik ke 0)
            currentBanner = (currentBanner + 1) % banners.length;

            // Pasang gambar kalau tidak null
            if (banners[currentBanner] != null) {
                setBanner(banners[currentBanner]);
            }
        });

        bannerTimer.start();
    }

    private void setBanner(BufferedImage image) {
        lblBanner.setImage(image);
        lblBanner.revalidate();
        lblBanner.repaint();
        bannerPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bgPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        btnBackContainer = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        pityContainer = new javax.swing.JPanel();
        pityBg = new javax.swing.JPanel();
        lblPity = new javax.swing.JLabel();
        currencyPanel = new javax.swing.JPanel();
        lblTungCoin = new javax.swing.JLabel();
        lblCoinAmount = new javax.swing.JLabel();
        btnAddCoin = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        menuContainer = new javax.swing.JPanel();
        menuAnomali = new javax.swing.JPanel();
        lblIconBintang = new javax.swing.JLabel();
        lblAnomali = new javax.swing.JLabel();
        menuInventory = new javax.swing.JPanel();
        lblIconInventory = new javax.swing.JLabel();
        lblInventory = new javax.swing.JLabel();
        menuHistory = new javax.swing.JPanel();
        lblIconHistory = new javax.swing.JLabel();
        lblHistory = new javax.swing.JLabel();
        menuDetail = new javax.swing.JPanel();
        lblIconDetail = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        footerCenter = new javax.swing.JPanel();
        gachaBtnContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGacha1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGacha10 = new javax.swing.JButton();
        resetContainer = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        dummyLeftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        bannerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anomali Gacha");

        bgPanel.setLayout(new java.awt.BorderLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        mainPanel.setFocusable(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 10, 10));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(791, 60));
        topPanel.setLayout(new java.awt.GridBagLayout());

        btnBackContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnBackContainer.setOpaque(false);
        btnBackContainer.setLayout(new java.awt.GridBagLayout());

        btnBack.setBackground(new java.awt.Color(170, 11, 11));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/previous.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this::btnBackActionPerformed);
        btnBackContainer.add(btnBack, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        topPanel.add(btnBackContainer, gridBagConstraints);

        pityContainer.setOpaque(false);
        pityContainer.setLayout(new java.awt.GridBagLayout());

        pityBg.setBackground(new java.awt.Color(255, 255, 255));
        pityBg.setPreferredSize(new java.awt.Dimension(85, 25));
        pityBg.setLayout(new java.awt.GridBagLayout());

        lblPity.setBackground(new java.awt.Color(0, 153, 51));
        lblPity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPity.setForeground(new java.awt.Color(255, 255, 255));
        lblPity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPity.setText("Pity : 0 / 90");
        pityBg.add(lblPity, new java.awt.GridBagConstraints());

        pityContainer.add(pityBg, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        topPanel.add(pityContainer, gridBagConstraints);

        currencyPanel.setBackground(new java.awt.Color(255, 255, 255));
        currencyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 9, 1, 9));
        currencyPanel.setPreferredSize(new java.awt.Dimension(100, 60));
        currencyPanel.setLayout(new java.awt.GridBagLayout());

        lblTungCoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tungCoin.png"))); // NOI18N
        currencyPanel.add(lblTungCoin, new java.awt.GridBagConstraints());

        lblCoinAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCoinAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblCoinAmount.setText("0");
        currencyPanel.add(lblCoinAmount, new java.awt.GridBagConstraints());

        btnAddCoin.setBackground(new java.awt.Color(255, 200, 0));
        btnAddCoin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddCoin.setText("+");
        btnAddCoin.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnAddCoin.setBorderPainted(false);
        btnAddCoin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCoin.setFocusPainted(false);
        btnAddCoin.setFocusable(false);
        btnAddCoin.setPreferredSize(new java.awt.Dimension(20, 20));
        btnAddCoin.addActionListener(this::btnAddCoinActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        currencyPanel.add(btnAddCoin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        topPanel.add(currencyPanel, gridBagConstraints);

        mainPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(160, 100));
        leftPanel.setLayout(new java.awt.BorderLayout());

        menuContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 50, 1));
        menuContainer.setOpaque(false);
        menuContainer.setLayout(new java.awt.GridBagLayout());

        menuAnomali.setBackground(new java.awt.Color(102, 102, 102));
        menuAnomali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAnomali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAnomaliMouseClicked(evt);
            }
        });
        menuAnomali.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblIconBintang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/star.png"))); // NOI18N
        lblIconBintang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAnomali.add(lblIconBintang);

        lblAnomali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAnomali.setForeground(new java.awt.Color(255, 255, 255));
        lblAnomali.setText("Anomali");
        lblAnomali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAnomali.add(lblAnomali);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        menuContainer.add(menuAnomali, gridBagConstraints);

        menuInventory.setBackground(new java.awt.Color(102, 102, 102));
        menuInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInventoryMouseClicked(evt);
            }
        });
        menuInventory.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblIconInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/inventory.png"))); // NOI18N
        lblIconInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInventory.add(lblIconInventory);

        lblInventory.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInventory.setForeground(new java.awt.Color(255, 255, 255));
        lblInventory.setText("Inventory");
        lblInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInventory.add(lblInventory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        menuContainer.add(menuInventory, gridBagConstraints);

        menuHistory.setBackground(new java.awt.Color(102, 102, 102));
        menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHistoryMouseClicked(evt);
            }
        });
        menuHistory.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblIconHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/history.png"))); // NOI18N
        lblIconHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuHistory.add(lblIconHistory);

        lblHistory.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistory.setForeground(new java.awt.Color(255, 255, 255));
        lblHistory.setText("History");
        lblHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuHistory.add(lblHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        menuContainer.add(menuHistory, gridBagConstraints);

        menuDetail.setBackground(new java.awt.Color(102, 102, 102));
        menuDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDetailMouseClicked(evt);
            }
        });
        menuDetail.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblIconDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/danger (1).png"))); // NOI18N
        lblIconDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDetail.add(lblIconDetail);

        lblDetail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDetail.setForeground(new java.awt.Color(255, 255, 255));
        lblDetail.setText("Detail");
        lblDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDetail.add(lblDetail);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        menuContainer.add(menuDetail, gridBagConstraints);

        leftPanel.add(menuContainer, java.awt.BorderLayout.SOUTH);

        mainPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new java.awt.BorderLayout());

        footerCenter.setOpaque(false);
        footerCenter.setLayout(new javax.swing.BoxLayout(footerCenter, javax.swing.BoxLayout.Y_AXIS));

        gachaBtnContainer.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(240, 184, 61));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tung x1");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        btnGacha1.setBackground(new java.awt.Color(240, 184, 61));
        btnGacha1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGacha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tungCoin.png"))); // NOI18N
        btnGacha1.setText("10");
        btnGacha1.setBorder(null);
        btnGacha1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGacha1.setFocusPainted(false);
        btnGacha1.setPreferredSize(new java.awt.Dimension(150, 30));
        btnGacha1.addActionListener(this::btnGacha1ActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(btnGacha1, gridBagConstraints);

        gachaBtnContainer.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(170, 11, 11));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setBackground(new java.awt.Color(170, 11, 11));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tung x10");
        jPanel2.add(jLabel2, new java.awt.GridBagConstraints());

        btnGacha10.setBackground(new java.awt.Color(170, 11, 11));
        btnGacha10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGacha10.setForeground(new java.awt.Color(255, 255, 255));
        btnGacha10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tungCoin.png"))); // NOI18N
        btnGacha10.setText("100");
        btnGacha10.setBorder(null);
        btnGacha10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGacha10.setFocusPainted(false);
        btnGacha10.setPreferredSize(new java.awt.Dimension(150, 30));
        btnGacha10.addActionListener(this::btnGacha10ActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(btnGacha10, gridBagConstraints);

        gachaBtnContainer.add(jPanel2);

        footerCenter.add(gachaBtnContainer);

        bottomPanel.add(footerCenter, java.awt.BorderLayout.CENTER);

        resetContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        resetContainer.setOpaque(false);
        resetContainer.setLayout(new java.awt.BorderLayout());

        btnReset.setBackground(new java.awt.Color(255, 0, 0));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(this::btnResetActionPerformed);
        resetContainer.add(btnReset, java.awt.BorderLayout.PAGE_END);

        bottomPanel.add(resetContainer, java.awt.BorderLayout.EAST);

        dummyLeftPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        dummyLeftPanel.setOpaque(false);
        dummyLeftPanel.setPreferredSize(new java.awt.Dimension(72, 10));
        bottomPanel.add(dummyLeftPanel, java.awt.BorderLayout.WEST);

        mainPanel.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new java.awt.Dimension(160, 100));
        mainPanel.add(rightPanel, java.awt.BorderLayout.LINE_END);

        bannerPanel.setOpaque(false);
        bannerPanel.setLayout(new java.awt.GridBagLayout());
        mainPanel.add(bannerPanel, java.awt.BorderLayout.CENTER);

        bgPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(bgPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (bannerTimer != null && bannerTimer.isRunning()) {
            bannerTimer.stop(); // Menghentikan hitungan 2 detik
        }
        HalamanAwal h = new HalamanAwal();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void menuDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDetailMouseClicked
        RateDialog dialog = new RateDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuDetailMouseClicked

    private void btnGacha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGacha1ActionPerformed
        if (!player.useCoin(10)) {
            JOptionPane.showMessageDialog(this, "tung coin tidak cukup");
            return;
        }

        lblCoinAmount.setText(String.valueOf(player.getTungCoin()));
        Item hasil = gachaSystem.pull();
        player.addItem(hasil);
        List<Item> hasilList = new ArrayList<>();
        hasilList.add(hasil);

        lblPity.setText("Pity : " + gachaSystem.getPity() + " / 90");

        PullResultDialog dialog
                = new PullResultDialog(
                        this,
                        true,
                        hasilList,
                        PullMode.SINGLE
                );
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGacha1ActionPerformed

    private void btnGacha10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGacha10ActionPerformed
        if (!player.useCoin(100)) {
            JOptionPane.showMessageDialog(this, "tung coin tidak cukup");
            return;
        }
        lblCoinAmount.setText(String.valueOf(player.getTungCoin()));

        List<Item> hasil10 = gachaSystem.pullTenTimes();

        for (Item item : hasil10) {
            player.addItem(item);
        }

        lblPity.setText("Pity : " + gachaSystem.getPity() + " / 90");
        PullResultDialog dialog
                = new PullResultDialog(
                        this,
                        true,
                        hasil10,
                        PullMode.MULTI);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGacha10ActionPerformed

    private void menuInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInventoryMouseClicked
        InventoryDialog d = new InventoryDialog(this, true, player.getInventory());
        d.setVisible(true);
    }//GEN-LAST:event_menuInventoryMouseClicked

    private void menuHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHistoryMouseClicked
//        HistoryDialog h = ;
        new HistoryDialog(this, true, gachaSystem).setVisible(true);

    }//GEN-LAST:event_menuHistoryMouseClicked

    private void btnAddCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCoinActionPerformed

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/assets/images/tungCoin.png")
        );

        String input = (String) JOptionPane.showInputDialog(
                this,
                "TOP UP Tung Coin, masukkan jumlah : ",
                "Top Up Tung Coin",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                null,
                ""
        );
        if (input == null) {
            return;
        }

        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Jumlah top up harus lebih dari 0");
                return;
            }
            player.addCoin(amount);
            lblCoinAmount.setText(String.valueOf(player.getTungCoin()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "input harus angka");
        }
    }//GEN-LAST:event_btnAddCoinActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Semua progress anda akan di reset!, apakah anda yakin?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        player.resetProgress();
        gachaSystem.resetProgress();
        lblCoinAmount.setText(String.valueOf(player.getTungCoin()));
        lblPity.setText("Pity : " + String.valueOf(gachaSystem.getPity()) + " / 90");
        JOptionPane.showMessageDialog(this, "Progress berhasil di reset");
    }//GEN-LAST:event_btnResetActionPerformed

    private void menuAnomaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAnomaliMouseClicked
        AnomaliDialog d = new AnomaliDialog(this, true, gachaSystem.getAllItems());
        d.setVisible(true);
    }//GEN-LAST:event_menuAnomaliMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TestFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bannerPanel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnAddCoin;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel btnBackContainer;
    private javax.swing.JButton btnGacha1;
    private javax.swing.JButton btnGacha10;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel currencyPanel;
    private javax.swing.JPanel dummyLeftPanel;
    private javax.swing.JPanel footerCenter;
    private javax.swing.JPanel gachaBtnContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAnomali;
    private javax.swing.JLabel lblCoinAmount;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblIconBintang;
    private javax.swing.JLabel lblIconDetail;
    private javax.swing.JLabel lblIconHistory;
    private javax.swing.JLabel lblIconInventory;
    private javax.swing.JLabel lblInventory;
    private javax.swing.JLabel lblPity;
    private javax.swing.JLabel lblTungCoin;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuAnomali;
    private javax.swing.JPanel menuContainer;
    private javax.swing.JPanel menuDetail;
    private javax.swing.JPanel menuHistory;
    private javax.swing.JPanel menuInventory;
    private javax.swing.JPanel pityBg;
    private javax.swing.JPanel pityContainer;
    private javax.swing.JPanel resetContainer;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
