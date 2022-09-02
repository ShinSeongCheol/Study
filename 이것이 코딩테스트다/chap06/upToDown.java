package chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class upToDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Arrays.sort(arr)

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
