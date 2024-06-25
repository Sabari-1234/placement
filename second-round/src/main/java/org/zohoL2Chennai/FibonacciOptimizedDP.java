package org.zohoL2Chennai;

import java.util.Scanner;

public class FibonacciOptimizedDP {
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long prev1 = 0, prev2 = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(fibonacci(n));
    }
}


