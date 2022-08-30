package chap05;

import java.util.ArrayList;
import java.util.Scanner;

public class chap05_10 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph.get(i).add(str.charAt(j) - '0');
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
            System.out.println();
        }

        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {
        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }

        if (graph.get(x).get(y) == 0) {
            graph.get(x).set(y, 1);
            dfs(x, y + 1);
            dfs(x, y - 1);
            dfs(x - 1, y);
            dfs(x + 1, y);
            return true;
        }

        return false;
    }
}
