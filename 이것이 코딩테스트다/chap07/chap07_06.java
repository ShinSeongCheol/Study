package chap07;

import java.util.Scanner;

public class chap07_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1000001];
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            arr[sc.nextInt()] += 1;
        }

        int M = sc.nextInt();

        for(int i=0; i<M; i++) {
            if(arr[sc.nextInt()] > 0) {
                System.out.print("yes ");
            }
            else
                System.out.print("no ");
        }

    }
}
