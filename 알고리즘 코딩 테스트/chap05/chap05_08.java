package chap05;

import java.util.Scanner;

public class chap05_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[max] < A[i])
                max = i;
        }

        int totalSize = 0;
        for (int i = 0; i < A.length; i++)
            totalSize += A[i];

        int start = A[max];
        int end = totalSize;
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            if (sum != 0) {
                count++;
            }
            if(count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
