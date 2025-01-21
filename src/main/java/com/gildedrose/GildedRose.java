package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (item.name.startsWith("Conjured")) {
                        updateConjuredItem(item);
                    } else {
                        updateRegularItem(item);
                    }
                    break;
            }
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 10) {
                item.quality++;
            }
            if (item.sellIn <= 5) {
                item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateConjuredItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
    }

    private void updateRegularItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
