package chap07;

import java.util.Scanner;

public class chap07_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextInt();
        long max = sc.nextInt();

        long[] A = new long[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0)
                continue;

            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] != 0) {
                long temp = A[i];
                while ((double) A[i] <= (double) max / (double) temp) {
                    if ((double) A[i] >= (double) min / (double) temp) {
                        count++;
                    }

                    temp = temp * A[i];
                }
            }
        }

        System.out.println(count);
    }
}
