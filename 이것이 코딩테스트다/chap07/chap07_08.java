package chap07;

import java.util.Arrays;
import java.util.Scanner;

public class chap07_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int start = 0;
        int end = arr[N - 1];
        long result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for(int i=0; i<N; i++) {
                if(arr[i] > mid)
                    total += arr[i] - mid;
            }

            if(total < M) {
                end = mid - 1;
            }
            else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
