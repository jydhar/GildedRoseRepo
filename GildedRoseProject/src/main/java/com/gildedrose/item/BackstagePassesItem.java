package com.gildedrose.item;

public class BackstagePassesItem implements BaseItem{
    private Item item;

    public BackstagePassesItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;

        if( item.sellIn > 10){
            item.quality = 1;
        }else if(item.sellIn > 5){
            item.quality = 2;
        }else if(item.sellIn > 0){
            item.quality = 3;
        }else{
            item.quality = 0;
        }


    }

    private void increaseQualityBy(int qualityValue) {
        item.quality += qualityValue;
    }
}
