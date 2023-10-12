package com.gildedrose.item;

public class AgedBrieItem implements BaseItem{

    private Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;
        item.quality +=1;
    }
}
