package com.gildedrose.item;

public class ConjuredItem extends RandomItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int reduceValueOverZeroDaysToSell() {
        return 2;
    }
}
