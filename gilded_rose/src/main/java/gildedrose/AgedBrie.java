package gildedrose;

public class AgedBrie extends ItemUpdatable {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }

        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);
            }
        }
    }
}
