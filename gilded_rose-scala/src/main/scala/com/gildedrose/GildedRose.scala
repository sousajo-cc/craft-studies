package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def updateQuality() {
    items.foreach { item =>
      item.name match {
        case GildedRose.AGEDBRIE =>
          if (item.quality < 50) {
            item.quality = item.quality + 1
          }
          item.sellIn = item.sellIn - 1
          if (item.sellIn < 0) {
            if (item.quality < 50) {
              item.quality = item.quality + 1
            }
          }
        case GildedRose.BACKSTAGE =>
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
            item.quality = item.quality - item.quality
          }
        case GildedRose.SULFURAS =>
        case _ =>
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
    }
  }
}

object GildedRose {
  private val AGEDBRIE = "Aged Brie"
  private val SULFURAS = "Sulfuras, Hand of Ragnaros"
  private val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
}