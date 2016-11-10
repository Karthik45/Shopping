import Builder.ItemsBuilder;
import core.Item;
import core.Shopping;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.ItemType;

public class TestShopping {





    @Test
    public void testShoppingForMoreThan()throws Exception{   //purchase for above 100
        Shopping shopping = new Shopping(500.0);
        Item item,item2;
        item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
        shopping.addItemToCart(item,10);

        item2 = new ItemsBuilder().withItems(ItemType.Milk).withPrice(15.0).build();
        shopping.addItemToCart(item2,4);

        shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(),253.0);


   }

   @Test
    public void testShoppingForEqualTo()throws Exception{    //test for exactly equal to 100
       Shopping shopping = new Shopping(500.0);
       Item item,item2;
       item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
       shopping.addItemToCart(item,2);

       item2 = new ItemsBuilder().withItems(ItemType.Milk).withPrice(15.0).build();
       shopping.addItemToCart(item2,4);

       shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(), 405.0);
   }

   @Test
    public void testShoppingForLessThan()throws Exception{  //test for less than 100.
       Shopping shopping = new Shopping(500.0);
       Item item,item2;
       item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
       shopping.addItemToCart(item,1);

       item2 = new ItemsBuilder().withItems(ItemType.NewsPaper).withPrice(5.0).build();
       shopping.addItemToCart(item2,4);

       shopping.payMoney();

       Assert.assertEquals(shopping.ewallet.getMoney(), 460.0 );
   }

   @Test
    public void testShoppingWhichExceedSLimit(){    //Test which exceeds Limit
       Shopping shopping = new Shopping(500.0);
       Item item,item2;
    try {
        item = new ItemsBuilder().withItems(ItemType.APPLE).withPrice(20.0).build();
        shopping.addItemToCart(item, 30);

        item2 = new ItemsBuilder().withItems(ItemType.NewsPaper).withPrice(5.0).build();
        shopping.addItemToCart(item2, 40);

        shopping.payMoney();
       }
       catch (Exception e)
       {
           System.out.println(e);

       }

   }

   @Test
    public void testShoppingToCheckPromotion()throws Exception{
       Shopping shopping = new Shopping(500.0);
       Item item,item2;

       item = new ItemsBuilder().withItems(ItemType.Milk).withPrice(20.0).build();
       shopping.addItemToCart(item, 5 );

       shopping.payMoney();

       Assert.assertEquals(shopping.shoppingCart.getNoOfItems(), 7);
   }
}
