package chap03;

import java.util.Scanner;

public class chap03_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] S = new int[N + 1];
        for(int i=1; i<=N; i++)
            S[i] = S[i - 1] + sc.nextInt();

        int[] result = new int[M];
        for(int i=0; i<M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            result[i] = S[end] - S[start - 1];
        }

        for(int i : result)
            System.out.println(i);
    }
}
