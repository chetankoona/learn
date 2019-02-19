package gfg.problem.recursion;

public class Factorial {

    public static void main(String[] args) {
        long input = 5;
        System.out.println("Factorial of " + input + " = " + calculateFactorial(input));
    }

    private static long calculateFactorial(long input) {
        if (input != 0) return input * calculateFactorial(input - 1);
        else return 1;
    }
}
