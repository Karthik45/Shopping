package core;


import resources.ItemType;

public class Items {

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

    public Items(){}


}
