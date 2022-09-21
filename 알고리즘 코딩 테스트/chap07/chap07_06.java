package chap07;

import java.util.Scanner;

public class chap07_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = 0, B = 0;

        for (int i = 0; i < T; i++) {
            A = sc.nextInt();
            B = sc.nextInt();
            int result = A * B / gcd(A, B);
            System.out.println(result);
        }
    }

    private static int gcd(int A, int B) {
//        int temp = 0;
//        while(true) {
//            temp = A % B;
//
//            if(temp == 0)
//                return B;
//
//            A = B;
//            B = temp;
//        }

        if(B == 0)
            return A;
        else
            return gcd(B, A % B);
    }
}
