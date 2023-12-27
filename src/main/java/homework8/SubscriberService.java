package homework8;

public interface SubscriberService {

    // a) відомості про абонентів, у яких час внутрішньоміських
   // розмов перевищує заданий;
    void printSubscriberCityCallDurationAbove(int duration);
    // b) відомості про абонентів, які користувалися міжміським зв'язком;
    void printSubscriberInterCityCalls();

    // c) відомості про абонентів ПІБ, номер телефону,
    // баланс - де перший бука прізвища передається як параметр.
    void printSubscribersByName(char firstLetterInLastName);

    //d) сумарне споживання трафіку інтернету для певного міста
    double getTotalInternetTrafficForCity(String city);

    //e) кількість абонентів з негативним балансом
    int countSubscribersWithNegativeBalance();
}
