
package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Item> inventory;

    public Player() {
        this.inventory = new ArrayList<>();
    }
    
    public void addItem(Item item){
        this.inventory.add(item);
    }
    
    public List<Item> getInventory(){
        return this.inventory;
    }
    
}
