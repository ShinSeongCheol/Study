package chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class chap08_03 {
    private static ArrayList<Integer>[] A;
    private static int[] check;
    private static boolean[] visited;
    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            check = new int[V + 1];
            visited = new boolean[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++)
                A[i] = new ArrayList<Integer>();

            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= N; i++) {
                if(isEven)
                    DFS(i);
                else
                    break;
            }

            if(isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
