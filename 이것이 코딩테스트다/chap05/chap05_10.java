package chap05;

import java.util.Scanner;

public class chap05_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] tray = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = sc.nextLine();
            for(int j=0; j<M; j++) {
                tray[i][j] = str.charAt(j) - '0';
            }
        }



        for(int[] i : tray) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int dfs() {

    }
}
