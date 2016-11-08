import Builder.ItemsBuilder;
import core.Items;
import core.Shopping;
import org.testng.annotations.Test;
import resources.ItemType;

public class TestShopping {

    @Test
    public void testShopping()throws Exception{

        Items items = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
        Shopping shopping = new Shopping();

        shopping.addItemToCart(items,5);

        shopping.payMoney();


    }
}
