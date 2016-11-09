package Builder;


import core.Item;
import resources.ItemType;

public class ItemsBuilder {

    Item item = new Item();

    public ItemsBuilder(){
        item.setItemType(ItemType.APPLE);
        item.setPrice(10.0);
    }

    public ItemsBuilder withItems(ItemType itemType){
        item.setItemType(itemType);
        return this;
    }

    public ItemsBuilder withPrice(double price){
        item.setPrice(price);
        return this;
    }

    public Item build(){
        return item;
    }


}
