package chap03;

import java.util.Scanner;

public class chap03_04 {

    private static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                arr[i][j] = sc.nextInt();

        D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + arr[i][j];

        for (int i = 0; i < M; i++)
            System.out.println(sum(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }

    private static int sum(int x1, int y1, int x2, int y2) {
        return D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
    }
}
