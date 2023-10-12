package com.gildedrose.item;


import com.gildedrose.item.constant.ItemType;

public class GildedRose {

    private static final int LOWEST_QUALITY_VALUE_POSSIBLE = 0;
    public Item[] items;

    private ItemFactory factory = null;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemFactory factory = new ItemFactory(item);
            factory.customiseItem(item).updateQuality();
            if (item.quality < LOWEST_QUALITY_VALUE_POSSIBLE) {
                item.quality = LOWEST_QUALITY_VALUE_POSSIBLE;
            }
            if (item.quality > highestValuePossible(item)) {
                item.quality = highestValuePossible(item);
            }
        }
    }

    public static int highestValuePossible(Item item) {
        if (item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.name())) {
            return 80;
        }
        return 50;
    }
}