package chap04;

import java.util.Scanner;

public class chap04_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        int x = tmp.charAt(0) - 'a' + 1;
        int y = tmp.charAt(1) - '1' + 1;

        int[] dx = { 1, -1, 1, -1, 2, 2, -2, -2 };
        int[] dy = { 2, 2, -2, -2, 1, -1, 1, -1 };
        int cnt = 0;

        for(int i=0; i<8; i++) {
            int nx, ny;
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 1 || ny < 1 || nx > 8 || ny > 8) {
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
