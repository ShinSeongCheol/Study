package chap02;

import java.util.Scanner;

//1이 될때까지
public class chap03_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        while (N != 1) {
            if (N % K == 0) {
                N = N / K;
            } else {
                N = N - 1;
            }
            count++;
        }

        System.out.println(count);
    }
}
