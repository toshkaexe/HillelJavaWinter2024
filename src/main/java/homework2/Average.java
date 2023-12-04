package homework2;

//1. Програма, яка знаходить середнє арифметичне значення двох чисел.
public class Average {


    public static void main(String[] args) {

        int a = 11;
        int b = 2;

        double average = (double) (a + b) / 2;

        System.out.println(String.format("a = %d ", a));
        System.out.println(String.format("b = %d ", b));
        System.out.println(String.format("average of %d and %d is %f", a, b, average));
    }
}