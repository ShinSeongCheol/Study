package chap07;

import java.io.*;
import java.util.StringTokenizer;

public class chap07_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = gcd(A, B);

        while (result > 0) {
            bw.write("1");
            result--;
        }

        bw.flush();
        bw.close();
    }

    private static long gcd(long A, long B) {
        if (B == 0)
            return A;
        else
            return gcd(B, A % B);
    }
}
