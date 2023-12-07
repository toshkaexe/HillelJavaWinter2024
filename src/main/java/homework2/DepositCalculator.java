package homework2;

/*
Програму, яка пропонує користувачеві запровадити суму грошового вкладу у гривнях,
відсоток річних, які виплачує банк, тривалість вкладу (років). Вивести накопичену
суму грошей за кожен рік та нараховані відсотки. (Відсотки складні з капіталізацією щомісяця)

У завданні 3 числа вводити через аргументи програми

приклад

java DepositCalculator <сума> <відсоток> <тривалість_у_роках>
 */
public class DepositCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Потрібно ввести суму вкладу, " +
                    "відсоткову ставку та тривалість вкладу (в роках).");
            return;
        }


        double principal = Double.parseDouble(args[0]);
        double interestRate = Double.parseDouble(args[1]);
        int years = Integer.parseInt(args[2]);

        calculateDeposit(principal, interestRate, years);


    }

    public static void calculateDeposit(double principal, double interestRate, int years) {
        double monthlyInterestRate = interestRate / 100 / 12;


        for (int i = 1; i <= years; i++) {
            double interestEarned = 0;
            for (int j = 0; j < 12; j++) {
                double interest = principal * monthlyInterestRate;
                principal += interest;
                interestEarned += interest;
            }
            System.out.printf(" %d Year: Pricipal amount: %.2f," +
                    " Sum of percentage:  %.2f%n", i, principal, interestEarned);
        }
    }
}
