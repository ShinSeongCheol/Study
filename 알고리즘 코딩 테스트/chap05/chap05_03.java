package chap05;

import java.util.ArrayList;
import java.util.Scanner;

public class chap05_03 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] A;
    private static boolean arrive;

    public static void main(String[] args) {
        int N;
        int M;
        arrive = false;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void DFS(int now, int depth) {
        if(depth == 5 || arrive)
        {
            arrive = true;
            return;
        }

        visited[now] = true;

        for(int i : A[now]) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
