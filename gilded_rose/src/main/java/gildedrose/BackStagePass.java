package gildedrose;

public class BackStagePass extends ItemUpdatable {
    public BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
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
    }
}
