package chap08;

public class p01 {
    public static void main(String[] args) {
        System.out.println(fibo(4));
    }

    public static int fibo(int num) {
        if(num == 1 || num == 2)
            return 1;
        return fibo(num - 1) + fibo(num - 2);
    }
}
