import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class removalOfItemsTest {

    @Test
    public void removeItemForOddMilks()throws Exception {//Test for odd milks when 1 milk is deleted no offer milks be deleted
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,5,15.0);

        shopping.removeItemFromCart(ItemType.APPLE,5);

        shopping.removeItemFromCart(ItemType.Milk,1);

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 11);

        shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(),348.0);
    }

    @Test
    public void removeItemsForEvenMilks()throws Exception {//Test for Even milks when 1 milk is deleted 1 offer milk be deleted
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,4,15.0);

        shopping.removeItemFromCart(ItemType.APPLE,5);

        shopping.removeItemFromCart(ItemType.Milk,1);

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 9);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(),362.25);
    }

    @Test
    public void removeNonOfferItems()throws Exception{ //Test for non-offer Items removal
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,4,15.0);

        shopping.removeItemFromCart(ItemType.APPLE,5);

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 11);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(),348.0);
    }
}
