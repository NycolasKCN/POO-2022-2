package fib;

public class Fibonacci {

    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib1(n-1) + fib1(n-2));
    }

    public int fib2(int n) {
        int n1 = 0;
        int n2 = 1;
        int temp;

        int count = 1;
        while (count < n) {
//            System.out.println(n1);
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
            count++;
        }
        return n1;
    }

    public int fib3(int n) {
        int n1 = 0;
        int n2 = 1;
        int temp;

        for (int count = 1; count < n; count++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }
    
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib2(7));
    }
}
