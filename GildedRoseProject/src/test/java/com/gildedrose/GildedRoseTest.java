package com.gildedrose;

import com.gildedrose.item.GildedRose;
import com.gildedrose.item.Item;
import com.gildedrose.item.constant.ItemType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void standardItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose("standard item", 0, 0);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void standardItemDecreasesQualityByTwoDaysSell() {
        GildedRose app = newGildedRose("standard item", 2, 1);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void brieDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose(ItemType.AGED_BRIE.name(), 0, 0);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void brieIncreasesInQualityEachTime() {
        GildedRose app = newGildedRose(ItemType.AGED_BRIE.name(), 1, 1);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void brieQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = newGildedRose(ItemType.AGED_BRIE.name(), 1, 49);

        app.updateQuality();
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstagePassesItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 0, 0);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesItemDecreasesQualityByOneIfSellByDayMoreThanEleven() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 12, 1);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void backstagePassesItemDecreasesQualityByTwoIfSellByDayIsMoreThanSix() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 10, 1);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void backstagePassesItemDecreasesQualityByThreeIfSellByDayIsMoreThanZero() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 5, 1);

        app.updateQuality();

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void backstagePassesItemQualityDropsToZeroIfSellByDayIsZeroOrLess() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 0, 50);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstagePassesItemQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = newGildedRose(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.name(), 5, 50);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasHasQualityEighty() {
        GildedRose app = newGildedRose(ItemType.SULFURAS_HAND_RAGNAROS.name(), 1, 80);

        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void sulfurasItemDoesNotAlterValues() {
        GildedRose app = newGildedRose(ItemType.SULFURAS_HAND_RAGNAROS.name(), 1, 80);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }


    @Test
    public void conjuredItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose(ItemType.CONJURED_MANA_CAKE.name(), 0, 0);

        app.updateQuality();

        assertEquals(-1,  app.items[0].sellIn);
    }

    @Test
    public void conjuredItemDecreasesQualityByTwoIfSellByDayIsAboveZero() {
        GildedRose app = newGildedRose(ItemType.CONJURED_MANA_CAKE.name(), 2, 5);

        app.updateQuality();

        assertEquals(3,  app.items[0].quality);
    }

    @Test
    public void conjuredItemDecreasesQualityByFourOnceSellByDayIsZeroOrLess() {
        GildedRose app = newGildedRose(ItemType.CONJURED_MANA_CAKE.name(),0, 5);

        app.updateQuality();

        assertEquals(1,  app.items[0].quality);
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        GildedRose app = newGildedRose(ItemType.CONJURED_MANA_CAKE.name(), 0, 0);

        app.updateQuality();

        assertEquals(0,  app.items[0].quality);
    }
    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[]{new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }
}
