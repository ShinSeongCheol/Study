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
        for(int i : arr) {
            if(M < i)
                M = i;
        }

        float result = 0;
        for(int i=0; i<N; i++)
            result += (arr[i] * 100 / M);

        System.out.print(result / N);
    }
}
