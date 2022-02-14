import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    ShoppingCart codeUnderTest;

    @BeforeEach
    void initTest() {
        codeUnderTest = new ShoppingCart();
    }

    @Test
    void shoppingCartIsEmpty() {
        //GIVEN
        //WHEN
        //THEN
        Assertions.assertTrue(codeUnderTest.getCart().isEmpty());
    }

    @Test
    void shoppingCartGetTotalPrice() {
        //GIVEN
        int expected = 6;
        LineItem item = new LineItem(6, 1, true);
        codeUnderTest.addItem(item);
        //WHEN
        int actual = codeUnderTest.getTotalPrice();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shoppingCartGetQuantity() {
        //GIVEN
        int expected = 2;
        LineItem item = new LineItem(6, 1, true);
        codeUnderTest.addItem(item);
        codeUnderTest.addItem(item);
        //WHEN
        int actual = codeUnderTest.getQuantity();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shoppingCartGetItemizedList() {
        //GIVEN
        LineItem item = new LineItem(6, 2, true);
        codeUnderTest.addItem(item);
        codeUnderTest.addItem(item);
        item.setQuantity(4);
        List<LineItem> expected = new ArrayList<>();
        expected.add(item);
        //WHEN
        List<LineItem> actual = codeUnderTest.itemizedList();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shoppingCartGetTotalPriceWithMultiItemQuantity() {
        //GIVEN
        int expected = 12;
        LineItem item = new LineItem(6, 2, true);
        codeUnderTest.addItem(item);
        //WHEN
        int actual = codeUnderTest.getTotalPrice();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shoppingCartGetQuantityWithMultiItemQuantity() {
        //GIVEN
        int expected = 2;
        LineItem item = new LineItem(6, 2, true);
        codeUnderTest.addItem(item);
        //WHEN
        int actual = codeUnderTest.getQuantity();
        //THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shoppingCartGetOnSaleItems() {
        //GIVEN
        LineItem item = new LineItem(6, 2, true);
        LineItem itemFalse = new LineItem(6, 2, false);
        List<LineItem> expected = new ArrayList<>();
        expected.add(item);
        codeUnderTest.addItem(item);
        codeUnderTest.addItem(itemFalse);
        //WHEN
        List<LineItem> actual = codeUnderTest.oneSalesItem();
        //THEN
        Assertions.assertEquals(expected, actual);
    }


}
