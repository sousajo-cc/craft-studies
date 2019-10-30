package gildedrose;
import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	public Item items [];

    public GildedRose(Item[] items) {
        this.items = items;
    }


    /**
	 * @param args
	 */
	public void main(String[] args) {
		
        System.out.println("OMGHAI!");

        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
        new Item("Aged Brie", 2, 0),
        new Item("Elixir of the Mongoose", 5, 7),
        new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Conjured Mana Cake", 3, 6)};
        updateQuality();
}


	
    public void updateQuality()
    {
        for (Item item : items) {
            ItemUpdatable itemUpdatable = (ItemUpdatable) item;
            itemUpdatable.doUpdateQuality();
        }
    }

}