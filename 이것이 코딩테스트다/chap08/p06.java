package chap08;

import java.util.Scanner;

public class p06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++)
            array[i] = sc.nextInt();

        int[] d = new int[100];
        d[0] = array[0];
        d[1] = Math.max(array[0], array[1]);
        for(int i=2; i<n; i++)
            d[i] = Math.max(d[i - 1], d[i - 2] + array[i]);

        System.out.println(d[n - 1]);
    }
}
