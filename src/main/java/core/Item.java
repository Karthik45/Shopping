package core;


import resources.ItemType;

public class Item {

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    ItemType itemType;
    Double price;

    public ItemType getItemType() {
        return itemType;
    }

    public Double getPrice() {
        return price;
    }

    public Item(){}


}
