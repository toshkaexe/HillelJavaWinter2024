import org.junit.Test;
import org.springframework.Order;
import org.springframework.OrderRepository;
import org.springframework.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderTests {

    @Test
    public void testAddOrderAndGetOrderById() {

        Product product1 = new Product(1, "Product 1", 10.99);
        Product product2 = new Product(2, "Product 2", 20.49);
        Product product3 = new Product(3, "Product 3", 34.49);
        Product product4 = new Product(4, "Product 4", 45.99);
        Product product5 = new Product(5, "Product 5", 55.99);

        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);

        Order order = new Order(56, new Date(), 31.48, products);

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.addOrder(order);

        Order retrievedOrder = orderRepository.getOrderById(56);

        // Assert that retrieved order is not null and has correct ID
        assertNotNull(retrievedOrder);
        assertEquals(56, retrievedOrder.getId());
    }

    @Test
    public void testGetOrderById_NotFound() {

        OrderRepository orderRepository = new OrderRepository();
        Order retrievedOrder = orderRepository.getOrderById(1000);
        assertNull(retrievedOrder);
    }

    @Test
    public void testGetAllOrders() {

        Product product1 = new Product(1, "Product 1", 10.99);
        Product product2 = new Product(2, "Product 2", 20.49);
        Product product3 = new Product(3, "Product 3", 34.49);
        Product product4 = new Product(4, "Product 4", 45.99);
        Product product5 = new Product(5, "Product 5", 55.99);
        List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);

        Order order = new Order(56, new Date(), 31.48, products);

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.addOrder(order);

        List<Order> allOrders = orderRepository.getAllOrders();

        // Assert that the list contains the added order
        assertEquals(1, allOrders.size());
        assertEquals(order, allOrders.get(0));
    }
}
