package homework8;

import java.util.List;

public class SubscriberServiceImpl implements SubscriberService {
    private List<Subscriber> subscribers;

    public SubscriberServiceImpl(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    //a) відомості про абонентів, у яких час внутрішньоміських розмов перевищує заданий;
    @Override
    public void printSubscribet_with_CityCallDurationAbove(int duration) {
        System.out.println("Абоненти з внутрішньоміським часом розмов більше " + duration + " хв:");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCityCallDurationMin() > duration) {
                System.out.println(subscriber.getLastName() + " "+ subscriber.getFirstName());
            }
        }
    }

    //b) відомості про абонентів, які користувалися міжміським зв'язком;
    @Override
    public void printSubscriber_with_InterCityCalls() {
        System.out.println("Абоненти, які користувалися міжміським зв'язком:");
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getInterCityCallDurationMin() > 0) {
                System.out.println(subscriber.getLastName() + " "+ subscriber.getFirstName());
            }
        }
    }

    @Override
    public void printSubscribersByName(char letter) {
        System.out.println("Абоненти з прізвищем c першой букви " + letter + ":");
        for (Subscriber subscriber : subscribers) {
            if
            (subscriber.getLastName().charAt(0) == letter) {
                System.out.println(String.format(subscriber.getLastName() +
                        " " +
                        subscriber.getFirstName() +
                        " номер тел: " + subscriber.getPhoneNumber()) +
                        " баланс: " + subscriber.getBalance());
            }
        }
    }

    // d) сумарне споживання трафіку інтернету для певного міста
    @Override
    public double getTotalInternetTrafficForCity(String city) {
        double totalTraffic = 0;
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCity().equals(city)) {
                totalTraffic += subscriber.getInternetTrafficGB();
            }
        }
        return totalTraffic;
    }

    //e) кількість абонентів з негативним балансом
    @Override
    public int countSubscribersWithNegativeBalance() {
        int count = 0;
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getBalance() < 0) {
                count++;
            }
        }
        return count;
    }

}
