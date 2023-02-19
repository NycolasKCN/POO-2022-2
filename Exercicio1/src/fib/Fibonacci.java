package fib;

public class Fibonacci {

    public int fib1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (fib1(n - 1) + fib1(n - 2));
    }

    public void printFibWhile(int n) {
        int n1 = 0;
        int n2 = 1;
        int temp;

        int count = 0;
        while (count < n) {
            System.out.print(n1 + " ");
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
            count++;
        }
        System.out.println();
    }

    public void printFibFor(int n) {
        int n1 = 0;
        int n2 = 1;
        int temp;

        for (int count = 0; count < n; count++) {
            System.out.print(n1 + " ");
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();

        System.out.println("Fibonacci com recursividade:");
        for (int i = 0; i < 20; i++) {
            System.out.print(f.fib1(i) + " ");
        }
        System.out.println();

        System.out.println("Fibonacci com laço while:");
        f.printFibWhile(20);

        System.out.println("Fibonacci com laço for:");
        f.printFibFor(20);

    }
}
