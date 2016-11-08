package Builder;


import core.Items;
import resources.ItemType;

public class ItemsBuilder {

    Items items = new Items();

    public ItemsBuilder withItems(ItemType itemType){
        items.setItemType(itemType);
        return this;
    }

    public ItemsBuilder withPrice(double price){
        items.setPrice(price);
        return this;
    }

    public Items build(){
        return items;
    }


}
