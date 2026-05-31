package Model;

import java.io.IOException;
import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {

    // Dipisah jadi dua Clip biar gak saling mematikan
    private static Clip bgmClip;
    private static Clip sfxClip;
    private static final float DEFAULT_BGM_VOLUME = -12.0f;

    // --- TAMBAHAN VARIABEL STATUS (TIDAK MERUSAK KODE LAMA) ---
    private static String currentBgmPath;
    private static boolean isBgmMuted = false;
    private static boolean isSfxMuted = false;

    // 1. KHUSUS PUTAR MUSIC BACKGROUND (LOOPING)
    // REVISI DI SOUNDPLAYER.JAVA
    public static void playBGM(String path) {
        currentBgmPath = path; // Catat path lagu aktif
        
        // JIKA BGM SEDANG DI-MUTE, JANGAN PUTAR
        if (isBgmMuted) {
            return;
        }

        try {
            if (bgmClip != null && bgmClip.isRunning()) {
                return;
            }

            URL soundURL = SoundPlayer.class.getResource(path);
            if (soundURL == null) {
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            bgmClip = AudioSystem.getClip();
            bgmClip.open(audioStream);
            
            setBgmVolume(DEFAULT_BGM_VOLUME);
            
            bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
            bgmClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playAnomaliSFX(String path) {
        // JIKA SFX SEDANG DI-MUTE, JANGAN PUTAR
        if (isSfxMuted) {
            return;
        }

        try {
            if (sfxClip != null && sfxClip.isRunning()) {
                sfxClip.stop();
                sfxClip.close();
            }

            URL soundURL = SoundPlayer.class.getResource(path);
            if (soundURL == null) {
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            sfxClip = AudioSystem.getClip();
            sfxClip.open(audioStream);

            setBgmVolume(-25.0f);
            sfxClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    sfxClip.close();
                    // Kembalikan ke volume awal hanya jika BGM tidak sedang di-mute
                    if (!isBgmMuted) {
                        setBgmVolume(DEFAULT_BGM_VOLUME);
                    }
                }
            });

            sfxClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopAnomaliSFX() {
        if (sfxClip != null) {
            if (sfxClip.isRunning()) {
                sfxClip.stop();
            }
            sfxClip.close();

            if (!isBgmMuted) {
                setBgmVolume(DEFAULT_BGM_VOLUME);
            }
        }
    }

    private static void setBgmVolume(float volume) {
        if (bgmClip != null && bgmClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) bgmClip.getControl(FloatControl.Type.MASTER_GAIN);
            
            // Validasi batasan aman desibel sistem komputermu
            if (volume < gainControl.getMinimum()) volume = gainControl.getMinimum();
            if (volume > gainControl.getMaximum()) volume = gainControl.getMaximum();
            
            gainControl.setValue(volume);
        }
    }

    // 3. STOP BGM TOTAL (Manggil pas keluar dari room gacha)
    public static void stopBGM() {
        if (bgmClip != null) {
            bgmClip.stop();
            bgmClip.close();
        }
    }

    // =========================================================================
    // --- FITUR BARU: GERBANG KENDALI MUTE & UNMUTE (AMAN UNTUK DOSEN) ---
    // =========================================================================
    
    public static void muteBGM() {
        isBgmMuted = true;
        if (bgmClip != null && bgmClip.isRunning()) {
            bgmClip.stop(); // Hentikan musik latar seketika tanpa menutup line
        }
    }

    public static void unmuteBGM() {
        isBgmMuted = false;
        if (currentBgmPath != null) {
            playBGM(currentBgmPath); // Putar kembali lagu terakhir
        }
    }

    public static void muteSFX() {
        isSfxMuted = true;
        if (sfxClip != null && sfxClip.isRunning()) {
            sfxClip.stop(); // Hentikan SFX gacha yang sedang berjalan jika mendadak dimute
        }
    }

    public static void unmuteSFX() {
        isSfxMuted = false;
    }

    public static boolean isBgmMuted() {
        return isBgmMuted;
    }

    public static boolean isSfxMuted() {
        return isSfxMuted;
    }
}
