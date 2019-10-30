import static org.junit.Assert.*;

import gildedrose.GildedRose;
import gildedrose.Item;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.*;


public class GildedRoseTest {

	@Test
	public void update_quality_approval_test() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("newItem",0,0));
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		//assertEquals("newItem", app.items.get(0).name);
		Approvals.verify(app.items.get(0).name);
	}

}
