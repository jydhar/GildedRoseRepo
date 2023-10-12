package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    public void testBackStagePasses_updateQualityTestCases() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21));
    }

    @Test
    public void testAgedBrie_updateQualityTestCases() {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 20)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Aged Brie", 14, 21));
    }

    @Test
    public void testSulfuras_Hand_Of_Ragnaros_updateQualityTestCases() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Sulfuras, Hand of Ragnaros", 1, 80));
    }

    @Test
    public void testConjured_Mana_Cake_updateQualityTestCases() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }


    public static void assertItemEquals(Item input, Item expected) {
        assertEquals(expected.name, input.name);
        assertEquals(expected.quality, input.quality);
        assertEquals(expected.sellIn, input.sellIn);
    }

}
