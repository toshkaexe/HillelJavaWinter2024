package homework8;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber(1, "Ivanov", "Ivan", "Kyiv", "123456789", 1001, 50, 30, 10, 2));
        subscribers.add(new Subscriber(2, "Petrov", "Petro", "Lviv", "987654321", 1002, 20, 40, 20, 1.5));
        subscribers.add(new Subscriber(3, "Sidorov", "Sidor", "Kharkiv", "567890123", 1003, -10, 25, 15, 3));


        SubscriberService subscriberService = new SubscriberServiceImpl(subscribers);

        System.out.println("Bідомості про абонентів, у яких час внутрішньоміських розмов перевищує заданий");
        subscriberService.printSubscriberCityCallDurationAbove(20);
        System.out.println();

        System.out.println("Bідомості про абонентів, які користувалися міжміським зв'язком");
        subscriberService.printSubscriberInterCityCalls();
        System.out.println();

        System.out.println("Відомості про абонентів ПІБ, номер телефону, баланс - де перший бука прізвища передається як параметр");
        subscriberService.printSubscribersByName('I');
        System.out.println();

        System.out.println("Сумарне споживання трафіку для міста Київ: " + subscriberService.getTotalInternetTrafficForCity("Kyiv") + " GB");
        System.out.println();

        System.out.println("Кількість абонентів з негативним балансом: " + subscriberService.countSubscribersWithNegativeBalance());
    }
}
