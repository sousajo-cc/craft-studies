package gildedrose;

public class ItemUpdatable extends Item {
    ItemUpdatable(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static ItemUpdatable createItemUpdatable(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedBrie(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackStagePass(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasHand(name, sellIn, quality);
            default:
                return new ItemUpdatable(name, sellIn, quality);
        }
    }

    protected void doUpdateQuality() {
        if (getQuality() > 0) {
            setQuality(getQuality() - 1);
        }

        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {
            if (getQuality() > 0) {
                setQuality(getQuality() - 1);
            }
        }
    }
}

