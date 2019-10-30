import gildedrose.GildedRose;
import gildedrose.Item;
import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.*;


public class GildedRoseTest {

	@Test 
	public void update_quality_approval_test() {
		String name = "newItem";
		int sellin = 0;
		int quality = 0;
		String itemString = doUpdate(name, sellin, quality);
		//Approvals.verify(itemString);
		CombinationApprovals.verifyAllCombinations(this::doUpdate,
													new String[] {name},
													new Integer[] {sellin},
													new Integer[] {quality});
	}

	private String doUpdate(String name, int sellin, int quality) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(name,sellin,quality));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app.items.get(0).name + " , " +
				app.items.get(0).sellIn + " , " +
				app.items.get(0).quality;
	}
}
