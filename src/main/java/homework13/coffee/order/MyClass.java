package homework13.coffee.order;

public class MyClass {
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        orderBoard.printOrders();

        orderBoard.deliver();

        orderBoard.deliver(4);

        orderBoard.printOrders();
    }

}
