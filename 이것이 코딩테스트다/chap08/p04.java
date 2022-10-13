package chap08;

public class p04 {
    static long[] d = new long[100];
    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;

        for(int i=3; i<100; i++)
            d[i] = d[i-1] + d[i-2];

        System.out.print(d[50]);
    }
}
