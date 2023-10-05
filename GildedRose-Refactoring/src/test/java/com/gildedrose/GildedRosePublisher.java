package com.gildedrose;

import com.gildedrose.consumer.GildedRoseSubscriber;
import com.gildedrose.consumer.PrintGildedRoseSubscriber;

import java.util.concurrent.SubmissionPublisher;

public class GildedRosePublisher {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        SubmissionPublisher<Item[]> publisher = new SubmissionPublisher<>();
        PrintGildedRoseSubscriber printGildedRoseSubscriberDay1 = new PrintGildedRoseSubscriber();
        GildedRoseSubscriber gildedRoseSubscriberDay1 = new GildedRoseSubscriber();


        PrintGildedRoseSubscriber printGildedRoseSubscriberDay2 = new PrintGildedRoseSubscriber();
        GildedRoseSubscriber gildedRoseSubscriberDay2 = new GildedRoseSubscriber();

        publisher.subscribe(printGildedRoseSubscriberDay1);
        publisher.subscribe(gildedRoseSubscriberDay1);
        publisher.subscribe(printGildedRoseSubscriberDay2);
        publisher.subscribe(gildedRoseSubscriberDay2);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        // Run the GildedRose print item and updateQuality subscriber asynchronously through publisher submit method..
        for (int i = 0; i < days; i++) {
            publisher.submit(items);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e0){}
        }


        publisher.close();
    }
}
