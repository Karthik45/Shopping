import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class EwalletPromotionTest {

    @Test
    public void testShoppingForMoreThan()throws Exception{   //purchase for above 100
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,10,20.0);

        shopping.addItemToCart(ItemType.Milk,4,15.0);

        Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 16);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(),253.0);

    }

    @Test
    public void testShoppingForEqualTo()throws Exception{    //test for exactly equal to 100
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,2,20.0);

        shopping.addItemToCart(ItemType.Milk,4,15.0);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(), 405.0);
    }

    @Test
    public void testShoppingForLessThan()throws Exception{  //test for less than 100.
        Shopping shopping = new Shopping(500.0);

        shopping.addItemToCart(ItemType.APPLE,1, 20.0);

        shopping.addItemToCart(ItemType.NewsPaper,4,5.0);

        shopping.payMoney();

        Assert.assertEquals(shopping.ewallet.getMoney(), 460.0 );
    }

    @Test
    public void testShoppingWhichExceedSLimit(){    //Test which exceeds Limit

        Shopping shopping = new Shopping(500.0);
        try {

            shopping.addItemToCart(ItemType.APPLE, 30,20.0);

            shopping.addItemToCart(ItemType.NewsPaper, 40, 5.0);

            shopping.payMoney();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
