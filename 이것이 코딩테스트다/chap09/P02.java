package chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node1 implements Comparable<Node1> {
    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node1 other) {
        if (this.distance < other.distance)
            return -1;
        return 1;
    }
}

public class P02 {
    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        pq.offer(new Node1(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node1 node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if (d[now] < dist)
                continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Node1>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node1(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for(int i=1; i<=n; i++) {
            if(d[i] == INF)
                System.out.println("INFINITY");
            else
                System.out.println(d[i]);
        }
    }
}
