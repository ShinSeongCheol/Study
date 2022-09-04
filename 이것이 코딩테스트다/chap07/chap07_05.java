package chap07;

import java.util.Arrays;
import java.util.Scanner;

public class chap07_05 {
    public static int binarySearch(int[] array, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr1 = new int[N];
        for(int i=0; i<N; i++) {
            arr1[i] = sc.nextInt();
        }

        Arrays.sort(arr1);

        int M = sc.nextInt();

        int[] arr2 = new int[M];
        for(int i=0; i<M; i++) {
            arr2[i] = sc.nextInt();
        }

        for(int i : arr2) {
            int result = binarySearch(arr1, i, 0, N - 1);
            if(result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
