package chap04;

import java.io.*;

public class chap04_08 {
    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(A, 5);

        for(int i=0; i<N; i++)
            bw.write(A[i] + "\n");

        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] A, int maxSize) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;

        while(count != maxSize) {
            int[] bucket = new int[10];

            for(int i=0; i<A.length; i++)
                bucket[(A[i] / jarisu) % 10]++;

            for(int i=1; i<10; i++)
                bucket[i] += bucket[i-1];

            for(int i=A.length-1; i>=0; i--){
                output[bucket[A[i] / jarisu % 10] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            for(int i=0; i<A.length; i++) {
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }
}
