package chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap08_16 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static long distance[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (distance[S][E] > V)
                distance[S][E] = V;
        }

        for(int k=1; k<=N; k++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(distance[s][e] > distance[s][k] + distance[k][e])
                        distance[s][e] = distance[s][k] + distance[k][e];
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(distance[i][j] == Integer.MAX_VALUE)
                    System.out.print("0 ");
                else
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
