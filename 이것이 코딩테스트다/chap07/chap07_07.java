package chap07;

import java.util.HashSet;
import java.util.Scanner;

public class chap07_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i<N; i++) {
            int x = sc.nextInt();
            s.add(x);
        }

        int M = sc.nextInt();
        int[] targets = new int[M];
        for(int i=0; i<M; i++) {
            targets[i] = sc.nextInt();
        }

        for(int i=0; i<M; i++) {
            if(s.contains(targets[i]))
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
}
