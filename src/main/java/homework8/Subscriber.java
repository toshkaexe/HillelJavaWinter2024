package homework8;

public class Subscriber {
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String phoneNumber;
    private int contractNumber;
    private int balance;
    private int cityCallDurationMin;
    private int interCityCallDurationMin;
    private double internetTrafficGB;

    public Subscriber(int id,
                      String lastName,
                      String firstName,
                      String city,
                      String phoneNumber,
                      int contractNumber,
                      int balance,
                      int cityCallDurationMin,
                      int interCityCallDurationMin,
                      double internetTrafficGB) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.contractNumber = contractNumber;
        this.balance = balance;
        this.cityCallDurationMin = cityCallDurationMin;
        this.interCityCallDurationMin = interCityCallDurationMin;
        this.internetTrafficGB = internetTrafficGB;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getCityCallDurationMin() {
        return cityCallDurationMin;
    }

    public int getInterCityCallDurationMin() {
        return interCityCallDurationMin;
    }

    public double getInternetTrafficGB() {
        return internetTrafficGB;
    }
}

