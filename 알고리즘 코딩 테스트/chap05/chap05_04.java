package chap05;

import java.util.*;

public class chap05_04 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(A[i]);

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }

    private static void DFS(int V) {
        System.out.print(V + " ");
        visited[V] = true;
        for(int i : A[V]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            int nowV = queue.poll();
            System.out.print(V + " ");
            for(int i : A[nowV]) {
                if (!visited[i]) {
                    visited[i] = true;
                    BFS(i);
                }
            }
        }

    }
}
