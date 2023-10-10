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
        for (Item item : items) {
            updateEachItemQuality(item);
        }
    }

    private void updateEachItemQuality(Item item) {
        if (!item.name.equals(ItemType.AGED_BRIE.getName())
                && !item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
            if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
                updateQualityCounter(item, -1);
            }
        } else {
            updateQualityCounter(item, 1);

            if (item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
                if (item.sellIn < 11) {
                    updateQualityCounter(item, 1);
                }

                if (item.sellIn < 6) {
                    updateQualityCounter(item, 1);
                }
            }
        }

        if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(ItemType.AGED_BRIE.getName())) {
                if (!item.name.equals(ItemType.BACKSTAGE_PASSES_TAFKAL80ETC_CONCERT.getName())) {
                    if (!item.name.equals(ItemType.SULFURAS_HAND_RAGNAROS.getName())) {
                        updateQualityCounter(item, -1);
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                updateQualityCounter(item, 1);
            }
        }
    }

    private void updateQualityCounter(Item item, int counter) {
        int updatedQuality = item.quality + counter;
        boolean isItValid = updatedQuality <= 50 && updatedQuality >= 0;
        if (isItValid) {
            item.quality = updatedQuality;
        }
    }
}