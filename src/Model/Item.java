
package Model;

import java.util.List;

public class Item {
    private String name;
    private int rarity;
    private String imagePath;
    private String soundPath;

    public Item(String name, int rarity, String imagePath, String soundPath) {
        this.name = name;
        this.rarity = rarity;
        this.imagePath = imagePath;
        this.soundPath = soundPath;
    }
    
    public String getSoundPath() {
        return this.soundPath;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public String getImagePath() {
        return imagePath;
    }
    
    
    public String toString() {
        String star = "";
        for (int i = 0; i < rarity; i++) {
            star += "★";
        }
        return name + "[" + star + "]";
    }
}
