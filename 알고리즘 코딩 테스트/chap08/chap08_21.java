package chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chap08_21 {
    static int parent[];
    static int N, sum;
    static PriorityQueue<lEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    }
}

class lEdge implements Comparable<lEdge> {
    int s,e,v;
    lEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge o){
        return this.v - o.v;
    }
}
