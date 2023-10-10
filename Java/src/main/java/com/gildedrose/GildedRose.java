package com.gildedrose;

import com.gildedrose.constant.ItemType;

class GildedRose {
    Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            updateEachItemQuality(item);
        }
    }

    private void updateEachItemQuality(Item item){
        if (!item.name.equals("Aged Brie")
                && !item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
            if (item.quality > 0) {
                if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
                    item.quality =item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(ItemType.AGED_BRIE.getName())) {
                if (!item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
                    if (item.quality > 0) {
                        if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
                            item.quality =item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}