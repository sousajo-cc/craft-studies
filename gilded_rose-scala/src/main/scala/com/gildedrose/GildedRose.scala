package com.gildedrose

import com.gildedrose.GildedRose.{AGEDBRIE, BACKSTAGE, SULFURAS}


class GildedRose(val items: Array[Item]) {
  def updateQuality() {
    items.foreach { item =>
      item.name match {
        case AGEDBRIE =>
          updateAgedBrie(item)
        case BACKSTAGE =>
          updateBackstage(item)
        case SULFURAS =>
          updateSulfuras(item)
        case _ =>
          updateDefault(item)
      }
    }
  }

  private def updateDefault(item: Item) = {
    if (item.quality > 0) {
      item.quality = item.quality - 1
    }

    item.sellIn = item.sellIn - 1

    if (item.sellIn < 0) {
      if (item.quality > 0) {
        item.quality = item.quality - 1
      }
    }
  }

  private def updateSulfuras(item: Item) = {

  }

  private def updateBackstage(item: Item) = {
    if (item.quality < 50) {
      item.quality = item.quality + 1
      if (item.sellIn < 11) {
        if (item.quality < 50) {
          item.quality = item.quality + 1
        }
      }
      if (item.sellIn < 6) {
        if (item.quality < 50) {
          item.quality = item.quality + 1
        }
      }
    }
    item.sellIn = item.sellIn - 1
    if (item.sellIn < 0) {
      item.quality = 0
    }
  }

  private def updateAgedBrie(item: Item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1
    }
    item.sellIn = item.sellIn - 1
    if (item.sellIn < 0) {
      if (item.quality < 50) {
        item.quality = item.quality + 1
      }
    }
  }

}

object GildedRose {
  private val AGEDBRIE = "Aged Brie"
  private val SULFURAS = "Sulfuras, Hand of Ragnaros"
  private val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
}