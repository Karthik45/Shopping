package core;


import resources.ItemType;

public class Item {

    private ItemType itemType;
    private Double price;
    private boolean isFree;

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Double getPrice() {
        return price;
    }

}
