package algorithms.other.recursion;

public class Factorial {

    public static int factorial(int n) {
        // base case:
        if (n == 1) {
            return 1;
        }

        // recursive case:
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}
