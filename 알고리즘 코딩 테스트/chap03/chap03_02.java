package chap03;

import java.util.Scanner;

public class chap03_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();

        int M = Integer.MIN_VALUE;
        float total = 0;
        for(int i : arr) {
            if(M < i)
                M = i;
            total += i;
        }

        System.out.print((total * 100 / M) / N);
    }
}
