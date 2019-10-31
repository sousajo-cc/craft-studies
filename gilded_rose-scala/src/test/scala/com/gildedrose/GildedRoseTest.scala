package com.gildedrose


import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers {
  "GildedRose" should "foo" in {
    var items = Array[Item](new Item("foo", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).name) should equal("foo")
  }

  "Item quality" should "drop by 1" in {
    var items = Array[Item](new Item("foo", 4, 6))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(5)
  }

  "SellIn" should "drop by 1" in {
    var items = Array[Item](new Item("foo", 4, 6))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).sellIn) should equal(3)
  }

  "Item quality" should "degrade twice as fast when expired" in {
    var items = Array[Item](new Item("foo", 0, 6))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(4)
  }

  "Item quality" should "never be negative" in {
    var items = Array[Item](new Item("foo", 4, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(0)
  }

  "Item quality" should "increase in time for Aged Brie" in {
    var items = Array[Item](new Item("Aged Brie", 4, 6))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(7)
  }

  "Item quality" should "increase in time for Aged Brie even after sell date" in {
    var items = Array[Item](new Item("Aged Brie", 0, 48))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
    app.updateQuality()
    (app.items(0).quality) should equal(50) // quality is updated once at the start of the else
  }

  "Item quality" should "never be above 50" in {
    var items = Array[Item](new Item("Aged Brie", 4, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
  }

  "Sulfuras" should "never decrease quality or sellIn" in {
    var items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 4, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality, app.items(0).sellIn) should equal(40, 4)
  }

  "Sulfuras" should "never decrease quality after sellIn date" in {
    var items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", -1, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(40)
  }

  "Backstage passes" should "increase 1 quality point" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
  }

  "Backstage passes" should "increase 2 quality points between 10 and 5 days" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 11, 47))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(48)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
  }

  "Backstage passes" should "increase 3 quality points between 0 and 5 days" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 6, 44))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(46)
    app.updateQuality()
    (app.items(0).quality) should equal(49)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
    app.updateQuality()
    (app.items(0).quality) should equal(50)
  }

  "Backstage passes" should "worth nothing after concert" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal(0)
  }
}