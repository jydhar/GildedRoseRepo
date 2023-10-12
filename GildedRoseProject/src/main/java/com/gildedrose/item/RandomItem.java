package com.gildedrose.item;

public class RandomItem implements BaseItem {

    private final Item item;

    public RandomItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        reduceSellByDayValueByOne();
        if (isSellByDayValueIsOverZero()) {
            reduceQualityBy(reduceValueOverZeroDaysToSell());
        } else {
            reduceQualityBy(reducingValueForZeroOrLessDaysToSell());
        }
    }

    public int reduceValueOverZeroDaysToSell() {
        return 1;
    }

    private void reduceSellByDayValueByOne() {
        item.sellIn -= 1;
    }

    private boolean isSellByDayValueIsOverZero() {
        return item.sellIn > 0;
    }

    private void reduceQualityBy(int qualityValue) {
        item.quality -= qualityValue;
    }

    private int reducingValueForZeroOrLessDaysToSell() {
        return reduceValueOverZeroDaysToSell() * 2;
    }
}
