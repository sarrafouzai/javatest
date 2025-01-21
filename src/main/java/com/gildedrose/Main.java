package com.gildedrose;

public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[] {
            new Item("item1", 10, 20),
            new Item("item2", 5, 30)
        };
        GildedRose gildedRose = new GildedRose(items);

        for (Item item : items) {
            System.out.println(item.name + ", " + item.sellIn + ", " + item.quality);
        }
    }
}
