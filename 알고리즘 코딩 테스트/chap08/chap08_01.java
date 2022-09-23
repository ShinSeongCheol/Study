package chap08;

import javax.sound.sampled.Line;
import java.util.*;

public class chap08_01 {
    private static int[] visited;
    private static ArrayList<Integer>[] A;
    private static int N, M, K, X;
    private static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++)
            visited[i] = -1;

        BFS(X);

        for(int i=0; i<=N; i++) {
            if(visited[i] == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println(-1);
        }
        else {
            Collections.sort(answer);
            for(int temp : answer)
                System.out.println(temp);
        }
    }

    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(int i : A[nowNode]) {
                if(visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
