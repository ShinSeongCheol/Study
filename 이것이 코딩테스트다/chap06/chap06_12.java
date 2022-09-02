package chap06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class chap06_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[][] arr = new Integer[2][N];

        for(int i=0; i<2; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr[0]);
        Arrays.sort(arr[1], Collections.reverseOrder());

        for(int i=0; i<K; i++) {
            if(arr[0][i] < arr[1][i]) {
                int tmp = arr[0][i];
                arr[0][i] = arr[1][i];
                arr[1][i] = tmp;
            }
        }

        int result = 0;
        for(int i : arr[0]) {
            result += i;
        }
        System.out.println(result);
    }
}
