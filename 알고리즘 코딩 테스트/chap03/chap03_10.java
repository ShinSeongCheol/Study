package chap03;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class chap03_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new LinkedList<>();

        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            if(dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    private static class Node {
        public int index;
        public int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
