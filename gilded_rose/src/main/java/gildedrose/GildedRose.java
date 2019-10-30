package gildedrose;
import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	public static List<Item> items = null;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            doUpdateQuality(items.get(i));
        }
    }

    private static void doUpdateQuality(Item item) {
        switch (item.getName()) {
            case "Aged Brie":
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                }

                item.setSellIn(item.getSellIn() - 1);

                if (item.getSellIn() < 0) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getSellIn() < 11) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }

                    if (item.getSellIn() < 6) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }

                item.setSellIn(item.getSellIn() - 1);

                if (item.getSellIn() < 0) {
                    item.setQuality(0);
                }
                break;
            case "Sulfuras, Hand of Ragnaros":

                break;
            default:
                if (item.getQuality() > 0) {
                    item.setQuality(item.getQuality() - 1);
                }

                item.setSellIn(item.getSellIn() - 1);

                if (item.getSellIn() < 0) {
                    if (item.getQuality() > 0) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
                break;
        }
    }

}