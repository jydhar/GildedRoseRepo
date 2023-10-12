package com.gildedrose.item;

import com.gildedrose.item.constant.ItemType;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private final static Map<ItemType, BaseItem> itemBucketList = new HashMap<>();

    public ItemFactory(Item item) {
        itemBucketList.put(ItemType.SULFURAS_HAND_RAGNAROS, new SulfurasItem(item));
        itemBucketList.put(ItemType.AGED_BRIE, new AgedBrieItem(item));
        itemBucketList.put(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT, new BackstagePassesItem(item));
        itemBucketList.put(ItemType.CONJURED_MANA_CAKE, new ConjuredItem(item));
    }
    public BaseItem customiseItem(Item item) {
        return itemBucketList.get(Enum.valueOf(ItemType.class,item.name));
    }
}
