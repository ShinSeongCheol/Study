package chap02;

import java.io.*;
import java.util.Arrays;

public class numberCardGame {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int N, M;
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[] min = new int[N];

        for (int i = 0; i < N; i++) {
            min[i] = arr[i][0];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (min[i] > arr[i][j]) {
                    min[i] = arr[i][j];
                }
            }
        }
        
        Arrays.sort(min);
        System.out.println(min[N - 1]);
    }
}
