package com.gildedrose.constant;

public enum ItemType {
   // "+5 Dexterity Vest"
    DEXTERITY_VEST("+5 Dexterity Vest"),
    AGED_BRIE("Aged Brie"),
    ELIXIR_MONGOOSE("Elixir of the Mongoose"),
    SULFURAS_HAND_RAGNAROS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_MANA_CAKE("Conjured Mana Cake");


    private String name;

    private ItemType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
