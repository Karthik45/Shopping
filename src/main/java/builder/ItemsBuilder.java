package builder;


import core.Item;
import resources.ItemType;

public class ItemsBuilder {

    Item item;

    public ItemsBuilder(){
        item = new Item();
        item.setItemType(ItemType.APPLE);
        item.setPrice(0.0);
    }

    public ItemsBuilder withItems(ItemType itemType){
        item.setItemType(itemType);
        return this;
    }

    public ItemsBuilder withPrice(double price){
        item.setPrice(price);
        return this;
    }
    public ItemsBuilder withOffer(boolean val){
        item.setFree(val);
        return this;
    }

    public Item build(){
        return item;
    }


}
