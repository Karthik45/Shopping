import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class ShoppingPromotionTest {

    @Test
    public void checkForOddPackets()throws Exception{

        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.Milk, 5, 15.0 );

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 7);

        shopping.payMoney();

    }

    @Test
    public void checkForEvenPackets()throws Exception {

        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.Milk, 4, 15.0);

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 6);

        shopping.payMoney();

    }

    @Test
    public void checkForOnePacket()throws Exception{

        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.Milk, 1, 15.0 );

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 1);

        shopping.payMoney();
    }
}

