import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class RemovalOfItemsTest {

    @Test
    public void removeItemForOddMilks()throws Exception {//Test for odd milks when 1 milk is deleted no offer milks be deleted
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,5,15.0);

        shopping.removeItemFromCart(ItemType.APPLE,5);

        shopping.removeItemFromCart(ItemType.Milk,1);

       Assert.assertEquals(shopping.getCartSize(), 11);

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

        Assert.assertEquals(shopping.getCartSize(), 9);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(),362.25);
    }

    @Test
    public void removeNonOfferItems()throws Exception{ //Test for non-offer Items removal
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,4,15.0);

        shopping.removeItemFromCart(ItemType.APPLE,5);

        Assert.assertEquals(shopping.getCartSize(), 11);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(),348.0);
    }

    @Test
    public void whenRemovalQuantityZero()throws Exception{//when removal quantity is zero
        Shopping shopping = new Shopping(500.0);

        try {
            shopping.addItemToCart(ItemType.APPLE, 10, 20.0);

            shopping.addItemToCart(ItemType.Milk, 4, 15.0);

            shopping.removeItemFromCart(ItemType.APPLE, 0);

            shopping.payMoney();
        }
        catch (Exception e) {
             System.out.println(e);
        }
    }

    @Test
    public void whenRemovalQuantityIsMore()throws Exception{ //when removal quantity is more
        Shopping shopping = new Shopping(500.0);

        try {
            shopping.addItemToCart(ItemType.APPLE, 5, 20.0);

            shopping.addItemToCart(ItemType.Milk, 4, 15.0);

            shopping.removeItemFromCart(ItemType.APPLE, 7);

            shopping.payMoney();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
