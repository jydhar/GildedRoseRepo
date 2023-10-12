package com.gildedrose;

import com.gildedrose.item.AgedBrieItem;
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
    public void conjuredItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = newGildedRose(ItemType.CONJURED_MANA_CAKE.name(), 0, 0);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }
}
