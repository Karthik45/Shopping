package core;


import resources.ItemType;

public class Item {

    private ItemType itemType;
    private Double price;

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

    public Item(){}


}
