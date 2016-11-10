import Builder.ItemsBuilder;
import core.Item;
import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class TestShopping {


    Shopping shopping = new Shopping(500.0);
    Item item,item2;

    @Test
    public void testShoppingForMoreThan()throws Exception{      //purchase for above 100

        item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
        shopping.addItemToCart(item,10);

        item2 = new ItemsBuilder().withItems(ItemType.Milk).withPrice(15.0).build();
        shopping.addItemToCart(item2,4);

        shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(),253.0);


   }

   @Test
    public void testShoppingForEqualTo()throws Exception{    //test for exactly equal to 100

       item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
       shopping.addItemToCart(item,2);

       item2 = new ItemsBuilder().withItems(ItemType.Milk).withPrice(15.0).build();
       shopping.addItemToCart(item2,4);

       shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(), 405.0);
   }

   @Test
    public void testShoppingForLessThan()throws Exception{  //test for less than 100.

       item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
       shopping.addItemToCart(item,1);

       item2 = new ItemsBuilder().withItems(ItemType.NewsPaper).withPrice(5.0).build();
       shopping.addItemToCart(item2,4);

       shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(), 460.0 );
   }
}
