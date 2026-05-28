package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GachaSystem {

    private List<Item> poolBintang3;
    private List<Item> poolBintang4;
    private List<Item> poolBintang5;

    private int pityCounter; // Mengikuti attribute di dokumen tugas
    private Random random;

    public GachaSystem() {
        poolBintang3 = new ArrayList<>();
        poolBintang4 = new ArrayList<>();
        poolBintang5 = new ArrayList<>();
        this.pityCounter = 0;
        this.random = new Random();
        isiMasterDataPool();
    }

    public Item pull() {
        int angkaKeberuntungan = random.nextInt(100) + 1; // Mengocok angka 1 - 100

        // 1. MEKANISME HARD PITY (Pity ke-90 wajib dapet bintang 5)
        if (pityCounter >= 90) {
            pityCounter = 0; // Reset kembali ke 0 karena sudah mendapatkan 5 Star
            return ambilItemAcak(poolBintang5);
        }
        
        // 2. MEKANISME SOFT PITY (Pity 81 - 89, peluang bintang 5 naik pesat)
        else if (pityCounter >= 81 && pityCounter <= 89) {
            if (angkaKeberuntungan >= 1 && angkaKeberuntungan <= 30) {
                pityCounter++; // Dapat Bintang 3, pity naik 1
                return ambilItemAcak(poolBintang3);
            } else if (angkaKeberuntungan >= 31 && angkaKeberuntungan <= 55) {
                pityCounter++; // Dapat Bintang 4, pity naik 1
                return ambilItemAcak(poolBintang4);
            } else {
                pityCounter = 0; // HORE Bintang 5! Reset pity ke 0
                return ambilItemAcak(poolBintang5);
            }
        }

        // 3. JALUR PROBABILITAS DINAMIS NORMAL (Pity 0 sampai 80)
        if (angkaKeberuntungan == 1) { 
            pityCounter = 0; // Beruntung dapat bintang 5 tanpa jaminan, reset pity
            return ambilItemAcak(poolBintang5);
        } else if (angkaKeberuntungan <= 10) { 
            // Angka 2 sampai 10 (Peluang 9%) dapet bintang 4
            pityCounter++; // Pity tetap naik karena bukan bintang 5
            return ambilItemAcak(poolBintang4);
        }
        
        // Peluang sisa terbesar dapet bintang 3
        pityCounter++; 
        return ambilItemAcak(poolBintang3);
    }
    
    public List<Item> pullTenTimes() {
        List<Item> hasilGacha10x = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            // Memanggil pull() tanpa parameter. Pity counter otomatis ter-update 
            // satu per satu di memori setiap kali loop berjalan.
            Item itemTerambil = this.pull(); 
            hasilGacha10x.add(itemTerambil);
        }
        
        return hasilGacha10x; // Mengembalikan list isi 10 item berurutan siap saji
    }

    // Fungsi pembantu untuk mengambil satu item secara acak di dalam keranjang yang terpilih
    private Item ambilItemAcak(List<Item> poolPilihan) {
        int indexAcak = random.nextInt(poolPilihan.size());
        return poolPilihan.get(indexAcak);
    }

    public int getPity() {
        return this.pityCounter;
    }
    
    public List<Item> getPool(){
        List<Item> semuaItem = new ArrayList<>();
        
        semuaItem.addAll(poolBintang3);
        semuaItem.addAll(poolBintang4);
        semuaItem.addAll(poolBintang5);
        
        return semuaItem;
    }
    
    private void isiMasterDataPool() {
        poolBintang3.add(new Item("Sigma Boy", 3, "/assets/images/9.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Burbaloni Luliloli", 3, "/assets/images/10.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Karkirkur Karkarkur", 3, "/assets/images/11.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Udin din din dun", 3, "/assets/images/12.png","/assets/sounds/tung-tung.wav"));

        // Isi Keranjang Bintang 4
        poolBintang4.add(new Item("Balerina Cappucina", 4, "/assets/images/5.png","/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Chimpanzini Bananini", 4, "/assets/images/6.png","/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Lirili Larila", 4, "/assets/images/7.png","/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Boneca Ambalabu", 4, "/assets/images/8.png","/assets/sounds/tung-tung.wav"));

        // Isi Keranjang Bintang 5
        poolBintang5.add(new Item("tung tung tung sahur", 5, "/assets/images/tungtungCard2.png","/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Bombardilo Crocodilo", 5, "/assets/images/2.png","/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Br Br Patapim", 5, "/assets/images/4.png","/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Tralalelo Tralala", 5, "/assets/images/3.png","/assets/sounds/tung-tung.wav"));
    }
}
