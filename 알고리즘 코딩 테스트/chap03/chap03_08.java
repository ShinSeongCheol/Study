package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class chap03_08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] A = new long[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Arrays.sort(A);

        long count = 0;
        for(int i=0; i<N; i++) {
            long find = A[i];
            int start = 0;
            int end = N-1;

            while(start < end) {
                if(A[start] + A[end] == find) {
                    if(start != i && end != i) {
                        count++;
                        break;
                    } else if(start == i) {
                        start ++;
                    }
                    else if (end == i) {
                        end --;
                    }
                } else if (A[start] + A[end] < find) {
                    start++;
                } else {
                    end --;
                }
            }
        }

        System.out.println(count);
    }
}
