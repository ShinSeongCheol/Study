package chap05;

import java.sql.Array;
import java.util.*;

public class chap05_06 {
    private static boolean visited[];
    private static int[] distance;
    private static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1)
                    break;
                int V = sc.nextInt();
                A[S].add(new Edge(E, V));
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1);
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[i] > distance[max]) {
                max = i;
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];

        BFS(max);

        Arrays.sort(distance);

        System.out.println(distance[N]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();

            for(Edge i : A[nowNode]) {
                int e = i.e;
                int v = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[nowNode] + v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
