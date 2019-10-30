import gildedrose.GildedRose;
import gildedrose.Item;
import gildedrose.ItemUpdatable;
import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.*;


public class GildedRoseTest {

	@Test
	public void update_quality_approval_test() {
		CombinationApprovals.verifyAllCombinations(this::doUpdate,
													new String[] {"newItem", "Aged Brie",
															"Backstage passes to a TAFKAL80ETC concert",
															"Sulfuras, Hand of Ragnaros"},
													new Integer[] {-1, 0, 2, 6, 11},
													new Integer[] {0, 1, 49, 50});
	}

	private String doUpdate(String name, int sellin, int quality) {
		ItemUpdatable[] items = new ItemUpdatable[]{
		new ItemUpdatable(name, sellin, quality)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app.items[0].name + " , " +
				app.items[0].sellIn + " , " +
				app.items[0].quality;
	}
}
