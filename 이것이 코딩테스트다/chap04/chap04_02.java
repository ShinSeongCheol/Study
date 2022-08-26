package chap04;

import java.util.Scanner;

public class chap04_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if(i%10==3 || j/10==3 || j%10 ==3 || k/10==3 || k%10==3)
                        cnt++;
//                    if (check(i, j, k)) {
//                        cnt++;
//                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3)
            return true;
        return false;
    }
}
