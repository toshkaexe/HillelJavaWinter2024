import org.hillel.coffee.order.CoffeeOrderBoard;
import org.hillel.coffee.order.Order;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CoffeeOrderBoardTest {
    @Test
    public void testAddOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order = new Order("John Doe");
        orderBoard.add(order);
        assertEquals(1, orderBoard.printOrders().size());
    }

    @Test
    public void testDeliverOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order = new Order("John Doe");
        orderBoard.add(order);
        Order deliveredOrder = orderBoard.deliver();
        assertEquals(order, deliveredOrder);
        assertEquals(0, orderBoard.printOrders().size());
    }

    @Test
    public void testDeliverSpecificOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order1 = new Order( "John Doe");
        Order order2 = new Order( "Jane Smith");
        orderBoard.add(order1);
        orderBoard.add(order2);
        Order deliveredOrder = orderBoard.deliver(2);

        assertEquals(2, orderBoard.printOrders().size());
    }

    @Test
    public void testDeliverNonexistentOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order1 = new Order( "John Doe");
        orderBoard.add(order1);
        Order deliveredOrder = orderBoard.deliver(2);
        assertNull(deliveredOrder);
    }

    @Test
    public void testPrintOrders() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order1 = new Order( "John Doe");
        Order order2 = new Order("Jane Smith");
        orderBoard.add(order1);
        orderBoard.add(order2);
        List<String> printedOrders = orderBoard.printOrders();
        assertEquals(2, printedOrders.size());
        assertEquals("3 | Jane Smith", printedOrders.get(1));
    }
}
