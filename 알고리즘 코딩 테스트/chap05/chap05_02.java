package chap05;

import java.util.Scanner;

public class chap05_02 {
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int number, int jarisu) {
        if(jarisu == N) {
            System.out.println(number);
            return;
        }

        for(int i=1; i<10; i++) {
            if(i % 2 == 0) {
                continue;
            }
            if(isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i=2; i<=num / 2; i++)
            if(num % i == 0)
                return false;
        return true;
    }
}
