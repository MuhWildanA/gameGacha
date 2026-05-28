
package Model;

public class PullHistory {
    private Item item;
    private int pullNumber;

    public PullHistory(Item item, int pullNumber) {
        this.item = item;
        this.pullNumber = pullNumber;
    }
    
    public Item getItem(){
        return this.item;
    }
    public int getPullNumber(){
        return this.pullNumber;
    }
}
