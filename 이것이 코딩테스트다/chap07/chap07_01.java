package chap07;

import java.util.Scanner;

public class chap07_01 {
    private static int sequential_search(int n, String target, String[] array) {
        for(int i=0; i<n; i++) {
            if(array[i].equals(target)) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");

        int n = sc.nextInt();
        String target = sc.next();
        sc.nextLine();

        System.out.println("앞서 적은 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        String[] array = sc.nextLine().split(" ");

        System.out.println(sequential_search(n, target, array));
    }
}
