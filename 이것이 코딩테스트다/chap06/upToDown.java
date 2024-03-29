package chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class upToDown {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(sc.nextLine());
//        }
//
//        Arrays.sort(arr);
//
//        for (int i = arr.length - 1; i >= 0; i--)
//            System.out.print(arr[i] + " ");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        for(Integer i : arr)
            System.out.print(i + " ");
    }
}
