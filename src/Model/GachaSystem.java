package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GachaSystem {

    private List<Item> poolBintang3;
    private List<Item> poolBintang4;
    private List<Item> poolBintang5;

    private List<PullHistory> histories;
    private int totalPull;

    private int pityCounter; // Mengikuti attribute di dokumen tugas
    private Random random;

    public GachaSystem() {
        poolBintang3 = new ArrayList<>();
        poolBintang4 = new ArrayList<>();
        poolBintang5 = new ArrayList<>();
        this.pityCounter = 0;
        this.random = new Random();
        this.histories = new ArrayList<>();
        this.totalPull = 0;
        isiMasterDataPool();
    }

    public Item pull() {
        int angkaKeberuntungan = random.nextInt(100) + 1; // Mengocok angka 1 - 100
        Item itemTerambil;

        if (pityCounter == 89) {
            pityCounter = 0;
            itemTerambil = ambilItemAcak(poolBintang5);
        } else if (pityCounter >= 80 && pityCounter <= 88) {
            if (angkaKeberuntungan >= 1 && angkaKeberuntungan <= 30) {
                pityCounter++;
                itemTerambil = ambilItemAcak(poolBintang3);
            } else if (angkaKeberuntungan >= 31 && angkaKeberuntungan <= 55) {
                pityCounter++; // Dapat Bintang 4, pity naik 1
                itemTerambil = ambilItemAcak(poolBintang4);
            } else {
                pityCounter = 0; // HORE Bintang 5! Reset pity ke 0
                itemTerambil = ambilItemAcak(poolBintang5);
            }
        } else {
            if (angkaKeberuntungan >= 1 && angkaKeberuntungan <= 5) {
                pityCounter = 0;
                itemTerambil = ambilItemAcak(poolBintang5);
            } else if (angkaKeberuntungan >= 6 && angkaKeberuntungan <= 35) {
                pityCounter++;
                itemTerambil = ambilItemAcak(poolBintang4);
            } else {
                pityCounter++;
                itemTerambil = ambilItemAcak(poolBintang3);
            }
        }
        
        totalPull++;
        histories.add(new PullHistory(itemTerambil, totalPull));
        return itemTerambil;
    }

    public List<Item> pullTenTimes() {
        List<Item> hasilGacha10x = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            hasilGacha10x.add(this.pull());
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

    public List<Item> getPool() {
        List<Item> semuaItem = new ArrayList<>();

        semuaItem.addAll(poolBintang3);
        semuaItem.addAll(poolBintang4);
        semuaItem.addAll(poolBintang5);

        return semuaItem;
    }

    public List<PullHistory> getPoolHistory() {
        return new ArrayList<>(histories);
    }

    private void isiMasterDataPool() {
        poolBintang3.add(new Item("Sigma Boy", 3, "/assets/images/9.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Burbaloni Luliloli", 3, "/assets/images/10.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Karkirkur Karkarkur", 3, "/assets/images/11.png", "/assets/sounds/tung-tung.wav"));
        poolBintang3.add(new Item("Udin din din dun", 3, "/assets/images/12.png", "/assets/sounds/tung-tung.wav"));

        // Isi Keranjang Bintang 4
        poolBintang4.add(new Item("Balerina Cappucina", 4, "/assets/images/5.png", "/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Chimpanzini Bananini", 4, "/assets/images/6.png", "/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Lirili Larila", 4, "/assets/images/7.png", "/assets/sounds/tung-tung.wav"));
        poolBintang4.add(new Item("Boneca Ambalabu", 4, "/assets/images/8.png", "/assets/sounds/tung-tung.wav"));

        // Isi Keranjang Bintang 5
        poolBintang5.add(new Item("tung tung tung sahur", 5, "/assets/images/tungtungCard2.png", "/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Bombardilo Crocodilo", 5, "/assets/images/2.png","/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Br Br Patapim", 5, "/assets/images/4.png","/assets/sounds/tung-tung.wav"));
//        poolBintang5.add(new Item("Tralalelo Tralala", 5, "/assets/images/3.png","/assets/sounds/tung-tung.wav"));
    }

    public void resetProgress() {
        histories.clear();
        pityCounter = 0;
        totalPull = 0;
    }
}
