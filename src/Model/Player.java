
package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Item> inventory;
    private int tungCoin;
    
    public Player() {
        this.inventory = new ArrayList<>();
        this.tungCoin = 500;
    }
    
    public void addItem(Item item){
        this.inventory.add(item);
    }
    
    public List<Item> getInventory(){
        return this.inventory;
    }
    
    public int getTungCoin(){
        return this.tungCoin;
    }
    
    public boolean useCoin(int amount){
        if(tungCoin >= amount){
            tungCoin -= amount;
            return true;
        }
        return false;
    }
    
    public void addCoin(int amount){
        this.tungCoin += amount;
    }
    
    public void resetProgress(){
        tungCoin = 500;
        inventory.clear();
    }
}
