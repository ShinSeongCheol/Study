package chap04;

import java.util.Scanner;

public class chap04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        for (String s : plans) {
            char plan = s.charAt(0);
            int nx = -1, ny = -1;
            for (int j = 0; j < moveTypes.length; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                continue;
            }

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
