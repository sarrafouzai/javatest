package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

        @Test
        void testNormalItemBeforeSellIn() {
            Item[] items = new Item[]{new Item("Normal Item", 10, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].quality);
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void testNormalItemAfterSellIn() {
            Item[] items = new Item[]{new Item("Normal Item", 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(18, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }

        @Test
        void testAgedBrieBeforeSellIn() {
            Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(11, app.items[0].quality);
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void testAgedBrieAfterSellIn() {
            Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(12, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }

        @Test
        void testBackstagePassesBeforeConcert() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
            assertEquals(14, app.items[0].sellIn);
        }

        @Test
        void testBackstagePassesCloseToConcert() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void testBackstagePassesVeryCloseToConcert() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
            assertEquals(4, app.items[0].sellIn);
        }

        @Test
        void testBackstagePassesAfterConcert() {
            Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }

        @Test
        void testSulfurasNeverChanges() {
            Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(80, app.items[0].quality);
            assertEquals(0, app.items[0].sellIn);
        }

        @Test
        void testConjuredItemBeforeSellIn() {
            Item[] items = new Item[]{new Item("Conjured", 10, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(18, app.items[0].quality);
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void testConjuredItemAfterSellIn() {
            Item[] items = new Item[]{new Item("Conjured", 0, 20)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(16, app.items[0].quality);
            assertEquals(-1, app.items[0].sellIn);
        }

        @Test
        void testItemQualityNeverNegative() {
            Item[] items = new Item[]{new Item("Normal Item", 10, 0)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void testItemQualityNeverAbove50() {
            Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

