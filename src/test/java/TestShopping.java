import Builder.ItemsBuilder;
import core.Item;
import core.Shopping;
import org.testng.annotations.Test;
import resources.ItemType;

public class TestShopping {

    @Test
    public void testShopping()throws Exception{

        Item item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
        Shopping shopping = new Shopping();

        shopping.addItemToCart(item,5);

        shopping.payMoney();


    }
}