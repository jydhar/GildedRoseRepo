package com.gildedrose.consumer;

import com.gildedrose.Item;

import java.util.Arrays;
import java.util.concurrent.Flow;

public class PrintGildedRoseSubscriber implements Flow.Subscriber<Item[]> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Item[] items) {
        Arrays.stream(items).forEach(System.out::println);
    }

    @Override
    public void onError(Throwable t) {

        System.out.println("Error occurred: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("PrintGildedRoseSubscriber is completed....");
    }
}
