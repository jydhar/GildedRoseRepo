package com.gildedrose.consumer;

import com.gildedrose.Item;

import java.util.concurrent.Flow;

public class GildedRoseSubscriber implements Flow.Subscriber<Item[]> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Item[] items) {
        updateQuality(items);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Error occurred: " + t.getMessage());
    }

    @Override
    public void onComplete() {

        System.out.println("GildedRoseSubscriber is completed....");
    }

    public void updateQuality(Item[] items) {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = decreaseQuality(item, 1);
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11 || item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = increaseQuality(item,1);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = decreaseQuality(item, 1);
                            }
                        }
                    } else {
                        item.quality =decreaseQuality(item, item.quality);
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = increaseQuality(item,1);
                    }
                }
            }
        }
    }


    private int increaseQuality(Item item, int increaseBy) {
        return item.quality = item.quality + increaseBy;
    }

    private int decreaseQuality(Item item, int decreaseBy) {
        return item.quality = item.quality - decreaseBy;
    }
}
