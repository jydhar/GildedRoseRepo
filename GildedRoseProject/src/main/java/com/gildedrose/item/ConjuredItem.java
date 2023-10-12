package com.gildedrose.item;

public class ConjuredItem implements BaseItem{
    private Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.quality = 2;
    }
}
