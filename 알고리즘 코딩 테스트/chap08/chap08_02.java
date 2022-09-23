package chap08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class chap08_02 {
    private static int N, M;
    private static boolean[] visited;
    private static int[] answer;
    private static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        A = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= N; i++)
            maxVal = Math.max(maxVal, answer[i]);

        for (int i = 1; i <= N; i++) {
            if (maxVal == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int index) {
        visited[index] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
