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

    private int pityCounter;
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
    
    public List<Item> getAllItems(){
        List<Item> allItems = new ArrayList<>();
        
        allItems.addAll(poolBintang3);
        allItems.addAll(poolBintang4);
        allItems.addAll(poolBintang5);
        
        return allItems;
    }

    private void isiMasterDataPool() {
        poolBintang3.add(   new Item("Trippi Troppi Troppa Trippa", 3, "/assets/images/Trippi.png", "/assets/sounds/Tripi troppi lengkap.wav"));
        poolBintang3.add(new Item("Br Br Patapim", 3, "/assets/images/Brbr.png", "/assets/sounds/Ber ber patapim.wav"));
        poolBintang3.add(new Item("Lirili Larila", 3, "/assets/images/Lirili.png", "/assets/sounds/Liri lira lira.wav"));
        poolBintang3.add(new Item("Bobrito Bondiro", 3, "/assets/images/Brobito.png", "/assets/sounds/Oborito bondito.wav"));
        poolBintang3.add(new Item("Kar Kir Kur", 3, "/assets/images/Karkirkur.png", "/assets/sounds/Karkirkur.wav"));
        poolBintang3.add(new Item("Bombolini Guzini", 3, "/assets/images/Bombo.png", "/assets/sounds/Bombanini guzini.wav"));
        poolBintang3.add(new Item("Frigo Camelo", 3, "/assets/images/Frigo.png", "/assets/sounds/Frigo camelo.wav"));
        poolBintang3.add(new Item("Anpalibabel", 3, "/assets/images/Anpalibabel.png", "/assets/sounds/Anpalibabel.wav"));
        poolBintang3.add(new Item("Tatata Sahur", 3, "/assets/images/Tatata.png", "/assets/sounds/Tatata sahur.wav"));
        poolBintang3.add(new Item("Cappucino Assasino", 3, "/assets/images/Cappucino.png", "/assets/sounds/Cappucino Assasino.wav"));

        // Isi Keranjang Bintang 4
        poolBintang4.add(new Item("Tralalelo Tralala", 4, "/assets/images/Tralalelo.png", "/assets/sounds/Tralale tralala.wav"));
        poolBintang4.add(new Item("Boneca Ambalabu", 4, "/assets/images/Boneca.png", "/assets/sounds/Boneka ambalabu.wav"));
        poolBintang4.add(new Item("Burbaloni Luliloni", 4, "/assets/images/Burba.png", "/assets/sounds/Burbaloni lulliloli.wav"));
        poolBintang4.add(new Item("Ballerina Cappucina", 4, "/assets/images/Baleri.png", "/assets/sounds/Balerina kapucina.wav"));
        poolBintang4.add(new Item("La Vaca Saturno Saturnita", 4, "/assets/images/Lavaca.png", "/assets/sounds/Labaca sturno saturnita.wav"));
        poolBintang4.add(new Item("Sigma Boy", 4, "/assets/images/Sigma.png", "/assets/sounds/Sigma boy.wav"));

        // Isi Keranjang Bintang 5
        poolBintang5.add(new Item("Tung Tung Sahur", 5, "/assets/images/Tungtung.png", "/assets/sounds/TungTung sahur.wav"));
        poolBintang5.add(new Item("Bombardilo Crocodilo", 5, "/assets/images/Bombar.png","/assets/sounds/Bombardilo corcodilo.wav"));
        poolBintang5.add(new Item("Udin din din dun", 5, "/assets/images/Udin.png","/assets/sounds/Udin din dun.wav"));
        poolBintang5.add(new Item("Chimpanzini Bananini", 5, "/assets/images/Chimpanzini.png","/assets/sounds/Bananini.wav"));
    }

    public void resetProgress() {
        histories.clear();
        pityCounter = 0;
        totalPull = 0;
    }
}
