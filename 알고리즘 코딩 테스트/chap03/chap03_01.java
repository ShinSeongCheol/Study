package chap03;

import java.util.Scanner;

public class chap03_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        int result = 0;
        for(int i=0; i<N; i++)
            result += str.charAt(i) - '0';

        System.out.print(result);
        sc.close();
    }
}
