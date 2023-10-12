package com.gildedrose.item.constant;

import com.gildedrose.item.Item;

import java.util.Arrays;

public enum ItemType {
    AGED_BRIE,
    SULFURAS_HAND_RAGNAROS,
    BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT,
    CONJURED_MANA_CAKE;


    public static boolean isItemExist(Item item) {
        try {
            return Arrays.asList(ItemType.values()).contains(Enum.valueOf(ItemType.class,item.name));
        }catch (Exception e){
            return false;
        }

    }
}
