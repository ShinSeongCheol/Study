package chap02;

import java.util.Scanner;

public class numberCardGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int result = 0;

        for(int i=0; i<N; i++) {
            int min_value = 100001;
            for(int j=0; j<M; j++) {
                min_value = Math.min(min_value, sc.nextInt());
            }
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
