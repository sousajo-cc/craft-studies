package gildedrose;

public class ItemUpdatable extends Item {
    public ItemUpdatable(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void doUpdateQuality() {
        switch (getName()) {
            case "Aged Brie":
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);

                }

                setSellIn(getSellIn() - 1);

                if (getSellIn() < 0) {
                    if (getQuality() < 50) {
                        setQuality(getQuality() + 1);
                    }
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);

                    if (getSellIn() < 11) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }

                    if (getSellIn() < 6) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }
                }

                setSellIn(getSellIn() - 1);

                if (getSellIn() < 0) {
                    setQuality(0);
                }
                break;
            case "Sulfuras, Hand of Ragnaros":

                break;
            default:
                if (getQuality() > 0) {
                    setQuality(getQuality() - 1);
                }

                setSellIn(getSellIn() - 1);

                if (getSellIn() < 0) {
                    if (getQuality() > 0) {
                        setQuality(getQuality() - 1);
                    }
                }
                break;
        }
    }
}

